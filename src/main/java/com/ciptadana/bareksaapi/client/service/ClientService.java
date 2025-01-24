package com.ciptadana.bareksaapi.client.service;


import com.ciptadana.bareksaapi.api.PagingResponse;
import com.ciptadana.bareksaapi.api.ResourceNotFoundException;


import com.ciptadana.bareksaapi.client.business.*;

import com.ciptadana.bareksaapi.client.dto.*;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.OutstandingWithdrawalListJpaRepository;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.PaymentViewJpaRepository;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.TPaymentWithdrawJpaRepository;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.projection.GetOutstandingWithdrawalList;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.projection.ViewBCAIASRMutasi;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.*;

import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.*;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCharge;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCommission;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientClosingAccEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientUpdatedDataEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientUpdatedDataKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqTradingLimitEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.*;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.*;
import com.ciptadana.bareksaapi.util.DayCalculator;
import com.ciptadana.bareksaapi.util.FormatDate;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClientService {

    private final int pageSize = 500;
    private final MasterMitraMapJpaRepository masterMitraMapJpaRepository;
    private final TempBalanceJpaRepository tempBalanceJpaRepository;
    private final RDNBalanceJpaRepository rdnBalanceJpaRepository;
    private final PaymentViewJpaRepository paymentViewJpaRepository;
    private final ClientCommissionJpaRepository clientCommissionJpaRepository;
    private final ClientChargeJpaRepository clientChargeJpaRepository;
    private final ClientSuspendedBareksaJpaRepository clientSuspendedBareksaJpaRepository;
    private final ClientPortfolioPrevBalJpaRepository clientPortfolioPrevBalJpaRepository;
    private final ClientTransactionArApJpaRepository clientTransactionArApJpaRepository;
    private final ClientTransactionRepository clientTransactionRepository;
    private final MasterHolidayJpaRepository masterHolidayJpaRepository;
    private final TempClientThreeDaysJpaRepository threeDaysMPPEJpaRepository;
    private final TPaymentWithdrawJpaRepository tPaymentWithdrawJpaRepository;
    private final TempHPokokJpaRepository tempHPokokJpaRepository;
    private final LedgerJpaRepository ledgerJpaRepository;
    private final DayCalculator dayCalculator;
    private final FormatDate formatDate;
    private final ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
    private final TempClientFinancingMPPEJpaRepository tempClientFinancingMPPERepository;
    private final SubmitTradingLimitClientJpaRepository submitTradingLimitClientJpaRepository;
    private final ReqClientUpdatedDataJpaRepository reqClientUpdatedDataJpaRepository;
    private final ReqClientClosingAccJpaRepository reqClientClosingAccJpaRepository;
    private final OutstandingWithdrawalListJpaRepository outstandingWithdrawalListJpaRepository;
    private final ClientJpaRepository clientJpaRepository;
    private final ClientPropertyJpaRepository clientPropertyJpaRepository;
    private final ClientAsyncService clientAsyncService;
    private final ClientCache clientCache;


    @Transactional
    public PagingResponse<ProfitLoss> getProfitLoss(GetProfitLoss getProfitLoss){
        LocalDate start = LocalDate.parse(getProfitLoss.getStartDate(), formatDate.getYyyyMMddHypen());
        LocalDate end = LocalDate.parse(getProfitLoss.getEndDate(), formatDate.getYyyyMMddHypen());
        tempBalanceJpaRepository.callPortfolioClientPLSummary(formatDate.formatYYYYmmDD(start), formatDate.formatYYYYmmDD(end), "", getProfitLoss.getClientCode());
        List<TempHPokokEntity> hPokoks = tempHPokokJpaRepository.findAllByOrderByNshareAscTransDateAsc();

        TreeMap<String, List<TempHPokokEntity>> hPokokGroupByCode = hPokoks.stream()
                .collect(Collectors.groupingBy(
                        TempHPokokEntity::getNshare,
                        TreeMap::new,
                        Collectors.toList()));

        List<ProfitLoss> profitLosses = new ArrayList<>();

        hPokokGroupByCode.forEach((code, grouped) -> {

            BigDecimal totalDebit = BigDecimal.ZERO;
            BigDecimal totalCredit = BigDecimal.ZERO;
            BigDecimal totalProfitLoss;

            for (TempHPokokEntity hPokok : grouped) {
                totalDebit =  totalDebit.add(hPokok.getDebit());
                totalCredit = totalCredit.add(hPokok.getCredit());

                profitLosses.add(ProfitLoss.builder()
                        .nShare(hPokok.getNshare())
                        .transDate(formatDate.formatDDmmmYY(hPokok.getTransDate()))
                        .qSell(String.valueOf(hPokok.getQsell()))
                        .qBuy(String.valueOf(hPokok.getQbuy()))
                        .credit(String.valueOf(hPokok.getCredit()))
                        .debit(String.valueOf(hPokok.getDebit()))
                        .price(String.valueOf(hPokok.getPrice()))
                        .profitLoss("")
                        .build());
            }

            totalProfitLoss = (totalDebit
                    .subtract(totalCredit)
                    .multiply(BigDecimal.valueOf(-1))
                    .setScale(2, RoundingMode.HALF_UP));


            profitLosses.add(ProfitLoss.builder()
                    .nShare(code)
                    .transDate("")
                    .qSell("")
                    .qBuy("")
                    .credit("")
                    .debit("")
                    .price("")
                    .profitLoss(String.valueOf(totalProfitLoss))
                    .build());

        });

        return PagingResponse.<ProfitLoss>builder()
                .total(profitLosses.size())
                .data(profitLosses)
                .build();
    }

    //@Transactional
    public SummaryProfitLossResponse getProfitLossSummary(GetSummaryProfitLoss getSummaryProfitLoss){
       // Pageable pageable = PageRequest.of(getSummaryProfitLoss.getPage() - 1, 500);
        List<TempBalanceEntity> tempBalanceEntities = new ArrayList<>();
        List<GetMasterMitra> masterMitras;
        List<GetMasterMitraDTO> masterMitraDTOS;

        if(getSummaryProfitLoss.getClientCode().isEmpty())
            masterMitras =  masterMitraMapJpaRepository.getMasterMitra();
        else
            masterMitras =  masterMitraMapJpaRepository.getMasterMitraByClientCode(getSummaryProfitLoss.getClientCode());


        masterMitraDTOS =  masterMitras.stream()
                .map(getMasterMitra -> GetMasterMitraDTO.builder()
                        .code(getMasterMitra.getCode())
                        .name(getMasterMitra.getName())
                        .build()).toList();

        LocalDate start = LocalDate.parse(getSummaryProfitLoss.getStartDate(), formatDate.getYyyyMMddHypen());
        LocalDate end = LocalDate.parse(getSummaryProfitLoss.getEndDate(), formatDate.getYyyyMMddHypen());
/*        masterMitraDTOS.forEach(mitraDTO -> {
            tempBalanceJpaRepository.callPortfolioClientPLSummary(formatDate.formatYYYYmmDD(start), formatDate.formatYYYYmmDD(end), "", mitraDTO.getCode());
            tempBalanceEntities.addAll(tempBalanceJpaRepository.getAllTempBalance());
        });*/

        List<CompletableFuture<Void>> futures = masterMitraDTOS.stream()
                .map(mitraDTO -> CompletableFuture.runAsync(() -> {
                    tempBalanceEntities.addAll(clientAsyncService.processAsync(mitraDTO, getSummaryProfitLoss));
                }, executorService))
                .toList();


        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        return SummaryProfitLossResponse.builder()
                .total(tempBalanceEntities.size())
                .summaryProfitLosses(tempBalanceEntities.stream()
                        .map(tempBalanceEntity -> SummaryProfitLoss.builder()
                                .account(tempBalanceEntity.getAccount())
                                .subAccount(tempBalanceEntity.getId().getSubaccount())
                                .period(formatDate.formatYYYYmm(tempBalanceEntity.getId().getDealDate()))
                                .name(tempBalanceEntity.getName())
                                .debit(String.valueOf(tempBalanceEntity.getDebit()))
                                .credit(String.valueOf(tempBalanceEntity.getCredit()))
                                .profitLoss(String.valueOf(tempBalanceEntity.getCredit() - tempBalanceEntity.getDebit()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public PagingResponse<ClientMutation> getClientMutation(String date) {
        List<String> bankAccNumbers = masterMitraMapJpaRepository.getBankAccNoInvestorUpdate();
        List<ViewBCAIASRMutasi> bcaiasrMutasiList;
        if(date.trim().isEmpty())
            bcaiasrMutasiList = paymentViewJpaRepository.getBCAIASRMutasi(bankAccNumbers);
        else
            bcaiasrMutasiList = paymentViewJpaRepository.getBCAIASRMutasiByDate(bankAccNumbers, date);


        return PagingResponse.<ClientMutation>builder()
                .total(bcaiasrMutasiList.size())
                .data(bcaiasrMutasiList.stream()
                        .map(mutasi ->  ClientMutation.builder()
                                .bankCode(mutasi.getBankCode())
                                .recDate(mutasi.getRecDate())
                                .recTime(mutasi.getRecTime())
                                .accountId(mutasi.getAccountId())
                                .clientName(mutasi.getClientName())
                                .timestamp(mutasi.getTimeStamp())
                                .beginBalance(mutasi.getBeginBalance())
                                .mutasiType(mutasi.getMutasiType())
                                .currentValue(mutasi.getCurrentValue())
                                .closingBalance(mutasi.getClosingBalance())
                                .remark(mutasi.getRemark())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public List<ClientMutationBlueChip> getClientMutationBlueChip(String code, String startDate, String endDate){
        List<String> bankAccNumbers = masterMitraMapJpaRepository.getBankAccNoInvestorBluechip(code);
        List<ViewBCAIASRMutasi> bcaiasrMutasiList;
        if(startDate.trim().isEmpty())
            bcaiasrMutasiList = paymentViewJpaRepository.getBCAIASRMutasi(bankAccNumbers);
        else
            bcaiasrMutasiList = paymentViewJpaRepository.getBCAIASRMutasiByRangeDate(bankAccNumbers, startDate, endDate);


        return bcaiasrMutasiList.stream()
                .map(mutasi ->  ClientMutationBlueChip.builder()
                        .bankCode(mutasi.getBankCode())
                        .recDate(mutasi.getRecDate())
                        .recTime(mutasi.getRecTime())
                        .accountId(mutasi.getAccountId())
                        .clientName(mutasi.getClientName())
                        .timestamp(mutasi.getTimeStamp())
                        .beginBalance(mutasi.getBeginBalance())
                        .mutationType(mutasi.getMutasiType())
                        .currentValue(mutasi.getCurrentValue())
                        .closingBalance(mutasi.getClosingBalance())
                        .remark(mutasi.getRemark())
                        .build())
                .collect(Collectors.toList());
    }


    public PagingResponse<ClientMPPE> getClientMPPE(int page) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<GetClientListMPPE> clients = masterMitraMapJpaRepository.getClientListMPPE(pageable);
        return PagingResponse.<ClientMPPE>builder()
                .total(clients.getTotalElements())
                .data(clients.stream()
                        .map(client -> ClientMPPE.builder()
                                .mitraCode(client.getMitraCode())
                                .mitraName(client.getMitraName())
                                .code(client.getCode())
                                .name(client.getName())
                                .foreigner(client.getForeigner())
                                .sid(client.getSid())
                                .kseiSubRek(client.getKseiSubRek())
                                .contactHome(client.getContactHome())
                                .contactFax(client.getContactFax())
                                .contactOffice(client.getContactOffice())
                                .contactOther(client.getContactOther())
                                .contactEmail(client.getContactEmail())
                                .bankAccountName(client.getBankAccountName())
                                .bankAccountNo(client.getBankAccountNo())
                                .bankName(client.getBankName())
                                .bankBranch(client.getBankBranch())
                                .bankAccNoInvestor(client.getBankAccNoInvestor())
                                .clientRating(client.getClientRating())
                                .tradingLimit(String.valueOf(client.getTradingLimit()))
                                .memberSince(client.getMemberSince())
                                .lastModified(client.getLastModified())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public PagingResponse<ClientThreeDays> getCashThreeDays(int page) {
        int searchPage = page - 1;
        int start = searchPage * pageSize;
        AtomicInteger count = new AtomicInteger((start) + 1);

        Pageable pageable = PageRequest.of(page - 1, pageSize);
        List<LocalDate> holidays = masterHolidayJpaRepository.findByHolidayGreaterThanEqualOrderByHoliday(LocalDate.of(2019, 1, 1)).stream()
                .map(MasterHolidayEntity::getHoliday)
                .toList();

        Page<GetClientThreeDaysDistinct> threeDays = threeDaysMPPEJpaRepository.getClientThreeDays(pageable);

        return PagingResponse.<ClientThreeDays>builder()
                .total(threeDays.getTotalElements())
                .data(threeDays.stream()
                        .map(client -> {
                            LocalDate now = LocalDate.now();
                            LocalDate dueDate = LocalDate.parse(formatDate.formatMMMMyyyy(client.getTransDueDate()));

                            int dueDay = dayCalculator.getWorkingDays(now, dueDate, holidays);
                            return ClientThreeDays.builder()
                                    .transDueDate(String.valueOf(dueDay))
                                    .amountIDR(String.valueOf(client.getAmountIdr()))
                                    .name(client.getName())
                                    .subAccount(client.getSubAccount())
                                    .amount(String.valueOf(client.getAmount()))
                                    .rnum(String.valueOf(count.getAndIncrement()))
                                    .build();
                        }).collect(Collectors.toList()))
                .build();
    }

    public PagingResponse<ClientCommission> getClientCommission(int page){
        int searchPage = page - 1;
        int start = searchPage * pageSize;
        AtomicInteger count = new AtomicInteger((start) + 1);

        List<GetClientCommission> clientCommissions = clientCommissionJpaRepository.getClientCommission(start, pageSize * page);

        return PagingResponse.<ClientCommission>builder()
                .total(clientCommissionJpaRepository.getClientCommissionCount())
                .data(clientCommissions.stream()
                        .map(commission -> ClientCommission.builder()
                                .clientId(commission.getClientId())
                                .name(commission.getName())
                                .sid(commission.getSid())
                                .commissionBuy(String.valueOf(commission.getCommissionBuy()))
                                .commissionSell(String.valueOf(commission.getCommissionSell()))
                                .minimumCommission(String.valueOf(commission.getMinimumCommission()))
                                .effective(commission.getEffective().toString())
                                .rnum(String.valueOf(count.getAndIncrement()))
                                .build())
                        .collect(Collectors.toList())
                ).build();
    }

    public List<GetRDNBalanceDTO> getRDNBalanceDTOList(String clientCode){
        return rdnBalanceJpaRepository.getRDIBalanceByClientCode(clientCode).stream()
                .map(getRDIBalance -> GetRDNBalanceDTO.builder()
                        .recDate(getRDIBalance.getRecDate())
                        .recTime(getRDIBalance.getRecTime())
                        .clientCode(getRDIBalance.getClientCode())
                        .noRek(getRDIBalance.getNoRek())
                        .balance(getRDIBalance.getBalance())
                        .contraBal(getRDIBalance.getContraBal())
                        .bankNameInvestor(formatBankName(getRDIBalance.getBankNameInvestor()))
                        .build()
                ).toList();
    }

    public PagingResponse<ClientCharge> getClientCharge(String date){
        List<GetClientCharge> clientCharges;
        if(!date.isEmpty()){
            clientCharges = clientChargeJpaRepository.getClientChargesByDate(date);
        }else{
            clientCharges = clientChargeJpaRepository.getAllClientCharges();
        }

        AtomicInteger count = new AtomicInteger( 1);
        return PagingResponse.<ClientCharge>builder()
                .total(clientCharges.size())
                .data(clientCharges.stream()
                        .map(getClientCharge -> ClientCharge.builder()
                                .clientId(getClientCharge.getClientId())
                                .name(getClientCharge.getName())
                                .effective(getClientCharge.getEffective().toString())
                                .lessFundRate(getClientCharge.getLessFundRate())
                                .rnum(String.valueOf(count.getAndIncrement()))
                                .build())
                                .collect(Collectors.toList())
                ).build();
    }

    public PagingResponse<ClientTransaction> getClientTransactions(String clientCode, String date){
         List<ClientTransaction> transactions =  clientTransactionRepository.getClientTransactionByClientCodeAndDate(clientCode, date).stream()
                .map(getClientTransaction -> ClientTransaction.builder()
                        .nDeal(getClientTransaction.getNDeal())
                        .quantity(getClientTransaction.getQuantity())
                        .price(getClientTransaction.getPrice())
                        .clientCode(getClientTransaction.getClientCode())
                        .stockCode(getClientTransaction.getStockCode())
                        .dealDate(getClientTransaction.getDealDate())
                        .settleDate(getClientTransaction.getSettleDate())
                        .amountNett(getClientTransaction.getAmountNet())
                        .build()
                ).toList();

        return PagingResponse.<ClientTransaction>builder()
                .total(transactions.size())
                .data(transactions)
                .build();
    }

    public PagingResponse<RDNMPPE> getAllRDN(int page){
        int searchPage = page - 1;
        int start = searchPage * pageSize;
        AtomicInteger count = new AtomicInteger((start) + 1);
        Pageable pageable = PageRequest.of(page - 1, pageSize);

        if(clientCache.getRdnCache().get(searchPage) == null){
            Page<GetRDNBareksa> bareksaRdn = rdnBalanceJpaRepository.getAllBareksaRDN(pageable);
            log.info("GET RDN FINISH");
            List<RDNMPPE> rdns = bareksaRdn.stream().parallel()
                    .map(rdn -> {
                        String clientCode = rdn.getClientCode();
                        Long sumAmountThreeDays = Optional.ofNullable(rdnBalanceJpaRepository.getBalanceSumThreeDaysByClientCode(clientCode))
                                .orElse(0L);

                        Long sumWithdraw = Optional.ofNullable(tPaymentWithdrawJpaRepository.getSumPaymentSaldoByClientCode(clientCode))
                                .orElse(0L);

                        return RDNMPPE.builder()
                                .clientCode(clientCode)
                                .norek(rdn.getNoRek())
                                .recTime(String.valueOf(rdn.getRecTime()))
                                .recDate(String.valueOf(rdn.getRecDate()))
                                .bankNameInvestor(formatBankName(rdn.getBankNameInvestor()))
                                .threeDays(String.valueOf(sumAmountThreeDays))
                                .withdraw(String.valueOf(sumWithdraw))
                                .balance(String.valueOf(rdn.getBalance()))
                                .build();
                    })
                    .toList();

            log.info("SUM THREE DAYS RDN FINISH");
            clientCache.getRdnCache().put(searchPage, rdns);
            clientCache.getRdnPageTotalCountCache().put(searchPage, bareksaRdn.getTotalElements());
            rdns.forEach(rdnmppe -> rdnmppe.setRnum((String.valueOf(count.getAndIncrement()))));

            return PagingResponse.<RDNMPPE>builder()
                    .total(bareksaRdn.getTotalElements())
                    .data(rdns)
                    .build();
        }else{
            List<RDNMPPE> rdns = clientCache.getRdnCache().get(searchPage).parallelStream()
                    .peek(rdn -> {
                        Long sumWithdraw = Optional.ofNullable(tPaymentWithdrawJpaRepository.getSumPaymentSaldoByClientCode(rdn.getClientCode()))
                                .orElse(0L);
                        rdn.setWithdraw(String.valueOf(sumWithdraw));
                    }).collect(Collectors.toList());

            rdns.forEach(rdnmppe -> rdnmppe.setRnum((String.valueOf(count.getAndIncrement()))));

            return PagingResponse.<RDNMPPE>builder()
                    .total(clientCache.getRdnPageTotalCountCache().get(searchPage))
                    .data(rdns)
                    .build();
        }


    }

    public List<ClientSuspended> getClientSuspendedBareksa(){
        return clientSuspendedBareksaJpaRepository.getClientSuspendedBareksa().stream()
                .map(item -> ClientSuspended.builder()
                        .clientId(item.getClientId())
                        .name(item.getName())
                        .effective(formatDate.formatDDmmmYY(item.getEffective()))
                        .suspended(String.valueOf(item.getSuspended()))
                        .build()
                ).toList();
    }

    public PagingResponse<ClientSuspended> getClientUnsuspendedBareksa(){
        List<ClientSuspended> suspended = clientSuspendedBareksaJpaRepository.getClientUnsuspendedBareksa().stream()
                .map(item -> ClientSuspended.builder()
                        .clientId(item.getClientId())
                        .name(item.getName())
                        .effective(formatDate.formatDDmmmYY(item.getEffective()))
                        .suspended(String.valueOf(item.getSuspended()))
                        .build()
                ).toList();

        return PagingResponse.<ClientSuspended>builder()
                .total(suspended.size())
                .data(suspended)
                .build();
    }

    public List<ClientPortfolioPrevBalResponse> getClientPortfolioPrevBal(){

        return clientPortfolioPrevBalJpaRepository.getAllPreviousBalance().stream()
                .map(item -> ClientPortfolioPrevBalResponse.builder()
                        .nclient(item.getId().getNClient())
                        .nshare(item.getId().getNShare())
                        .prevbal(String.valueOf(item.getPreviousBalance()))
                        .build()
                ).toList();
    }

    public List<ClientTransactionArAp> getClientTransactionArAp(String date){
        List<GetTransactionArAp> transactionArAps;

        if(date.isEmpty())
            transactionArAps = clientTransactionArApJpaRepository.getClientTransactionArAP();
        else
            transactionArAps = clientTransactionArApJpaRepository.getClientTransactionArAPByDate(date);

        return transactionArAps.stream()
                .map(item -> ClientTransactionArAp.builder()
                        .nClient(item.getNClient())
                        .outStanding(String.valueOf(item.outstanding()))
                        .transDate(item.transDate())
                        .build()
                ).toList();
    }

    public List<ClientLatePayment> getClientLatePayment(String period){
        return ledgerJpaRepository.getClientLatePayment(period).stream()
                .map(item -> ClientLatePayment.builder()
                        .transSeq(item.getId())
                        .clientCode(item.getSubAccount())
                        .transNo(item.getTransNo())
                        .transDate(item.getTransDate())
                        .transDueDate(item.getTransDueDate())
                        .amount(item.getAmount())
                        .description(item.getDescription())
                        .build()
                ).toList();
    }

    public PagingResponse<ClientAveragePrice> getClientAveragePrice(int page){
        int searchPage = page - 1;
        int start = searchPage * pageSize;
        AtomicInteger count = new AtomicInteger((start) + 1);

        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<GetClientAveragePrice> averagePrices =  masterMitraMapJpaRepository.getClientAveragePrice(pageable);

        return PagingResponse.<ClientAveragePrice>builder()
                .total(averagePrices.getTotalElements())
                .data(averagePrices.stream()
                        .map(client -> ClientAveragePrice.builder()
                                .averagePrice(String.valueOf(client.getAveragePrice()))
                                .clientCode(client.getClientCode())
                                .lastUpdated(client.getLastUpdated())
                                .nShare(client.getNShare())
                                .rnum(String.valueOf(count.getAndIncrement()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    public List<UpdateClientPropertyResponse>  getUpdateClientProperty(){
        return reqClientUpdatedDataJpaRepository.getClientUpdateLastThirtyDays().stream()
                .map(getUpdateClientProperty -> UpdateClientPropertyResponse.builder()
                        .code(getUpdateClientProperty.getCode())
                        .status(getUpdateClientProperty.getStatus())
                        .email(getUpdateClientProperty.getEmail())
                        .idCardNo(getUpdateClientProperty.getIdCardNo())
                        .modifiedDate(getUpdateClientProperty.getModifiedDate())
                        .rejectReason(getUpdateClientProperty.getRejectReason())
                        .build()
                ).toList();
    }

    public List<ClientFinancing> getTempClientFinancingMPPEData(int period){

        return tempClientFinancingMPPERepository.getByPeriod(period).stream()
                .map(tempClientFinancingMPPEEntity -> ClientFinancing.builder()
                        .transSeq(String.valueOf(tempClientFinancingMPPEEntity.getId().getTransSeq()))
                        .transNo(tempClientFinancingMPPEEntity.getTransNo())
                        .transPeriod(String.valueOf(tempClientFinancingMPPEEntity.getTransPeriod()))
                        .transDue(String.valueOf(tempClientFinancingMPPEEntity.getTransDue()))
                        .transDate(String.valueOf(tempClientFinancingMPPEEntity.getTransDate()))
                        .clientCode(String.valueOf(tempClientFinancingMPPEEntity.getId().getClientCode()))
                        .side(tempClientFinancingMPPEEntity.getSide())
                        .quantity(String.valueOf(tempClientFinancingMPPEEntity.getQuantity()))
                        .price(String.valueOf(tempClientFinancingMPPEEntity.getPrice()))
                        .amount(String.valueOf(tempClientFinancingMPPEEntity.getAmount()))
                        .description(tempClientFinancingMPPEEntity.getDescription())
                        .lastUpdated(String.valueOf(tempClientFinancingMPPEEntity.getLastUpdated()))
                        .build()
                ).toList();

//        TempClientFinancingMPPEEntity clientFinancingMPPEEntity = tempClientFinancingMPPERepository.getByPeriod(period);

//        return ClientFinancing.builder()
//                .transSeq(clientFinancingMPPEEntity.getId().getTransSeq())
//                .transNo(clientFinancingMPPEEntity.getTransNo())
//                .transPeriod(clientFinancingMPPEEntity.getTransPeriod())
//                .transDue(clientFinancingMPPEEntity.getTransDue())
//                .clientCode(clientFinancingMPPEEntity.getId().getClientCode())
//                .side(clientFinancingMPPEEntity.getSide())
//                .quantity(clientFinancingMPPEEntity.getQuantity())
//                .price(clientFinancingMPPEEntity.getPrice())
//                .amount(clientFinancingMPPEEntity.getAmount())
//                .description(clientFinancingMPPEEntity.getDescription())
//                .lastUpdated(clientFinancingMPPEEntity.getLastUpdated())
//                .build();

    }

    public PagingResponse<ClientListMitraPPEInactive> getClientListMitraPPEInactive(int page){
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<GetClientListMitraPPEInactive> clientListMitraPPEInactives = masterMitraMapJpaRepository.getInactiveClients(pageable);

        return PagingResponse.<ClientListMitraPPEInactive>builder()
                .total(clientListMitraPPEInactives.getTotalElements())
                .data(clientListMitraPPEInactives.stream()
                        .map(getClientListMitraPPEInactive -> ClientListMitraPPEInactive.builder()
                                .mitraCode(getClientListMitraPPEInactive.getMitraCode())
                                .code(getClientListMitraPPEInactive.getCode())
                                .name(getClientListMitraPPEInactive.getName())
                                .contactHome(getClientListMitraPPEInactive.getContactHome())
                                .contactOffice("xxxxxxx")
                                .contactFax("xxxxxxx")
                                .contactOther("xxxxxxx")
                                .contactEmail(getClientListMitraPPEInactive.getContactEmail())
                                .bankAccountName(getClientListMitraPPEInactive.getBankAccountName())
                                .bankAccountNo(getClientListMitraPPEInactive.getBankAccountNo())
                                .bankName(getClientListMitraPPEInactive.getBankName())
                                .bankBranch(getClientListMitraPPEInactive.getBankBranch())
                                .build()
                        ).collect(Collectors.toList())
                ).build();
    }

    public String submitClosingAccount(SubmitClosingAccountResponse submitClosingAccountResponse){
        reqClientClosingAccJpaRepository.save(ReqClientClosingAccEntity.builder()
                .code(submitClosingAccountResponse.getClientCode())
                .sid(submitClosingAccountResponse.getSid())
                .sre(submitClosingAccountResponse.getSre())
                .rdn(submitClosingAccountResponse.getRdn())
                .build());
        return "Success";
    }

    public PagingResponse<OutstandingWithdrawal> getOutstandingWithdrawalList(){
        LocalDate now = LocalDate.now();
        String date = now.toString();
        List<GetOutstandingWithdrawalList> outstandingWithdrawals = outstandingWithdrawalListJpaRepository.getOutstandingWithdrawalList(date);

        return PagingResponse.<OutstandingWithdrawal>builder()
                .total(outstandingWithdrawals.size())
                .data(outstandingWithdrawals.stream()
                        .map(item -> OutstandingWithdrawal.builder()
                                .withdrawalId(String.valueOf(item.getWithdrawalId()))
                                .clientCode(item.getClientCode())
                                .clientName(item.getClientName())
                                .amount((item.getAmount()))
                                .paymentDate(String.valueOf(item.getPaymentDate()))
                                .build())
                        .collect(Collectors.toList())
                ).build();
    }

    public String submitTradingLimitClient(GetSubmitTradingLimitClient getSubmitTradingLimitClient){
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String date = dateTimeNow.format(formatter);

        submitTradingLimitClientJpaRepository.save(ReqTradingLimitEntity.builder()
                        .code(getSubmitTradingLimitClient.getCode())
                        .xCash(getSubmitTradingLimitClient.getXCash())
                        .xStock(getSubmitTradingLimitClient.getXStock())
                        .xRdpu(getSubmitTradingLimitClient.getXRdpu())
                        .feeBuy(getSubmitTradingLimitClient.getFeeBuy())
                        .feeSell(getSubmitTradingLimitClient.getFeeSell())
                        .effectiveDate(getSubmitTradingLimitClient.getEffectiveDate())
                        .submitDate(getSubmitTradingLimitClient.getSubmitDate())
                        .modifiedDate(date)
                        .credit(getSubmitTradingLimitClient.getCredit())
                .build()
        );

        return "Success";
    }

    public List<ClientArAp> getClientArAp(GetClientArAp getClientArAp){
        String accountType = "'LEVY PAYABLE','KPEI PAYABLE','PPh PAYABLE','PPn PAYABLE','REGULAR COMMISSION','TITIPAN COMMISSION'";
        String period = getClientArAp.getStartDate().replace("-", "").substring(0, 6);
        return ledgerJpaRepository.getClientArAp(getClientArAp.getClientCode(),
                "10401021",
                accountType,
                period,
                getClientArAp.getStartDate(),
                getClientArAp.getEndDate()
                ).stream()
                .map(client -> ClientArAp.builder()
                        .id(client.getId())
                        .transNo(client.getTrans_No())
                        .transDate(client.getTrans_Date())
                        .transDueDate(client.getTrans_DueDate())
                        .nShare(client.getNShare())
                        .account(client.getAccount())
                        .subAccount(client.getSubAccount())
                        .description(client.getDescription())
                        .amountIdr(client.getAmountIdr())
                        .build())
                .collect(Collectors.toList());
    }


    public String updateClientData(GetUpdatedClientData item){
        LocalDate now = LocalDate.now();
        String date = now.toString();

        reqClientUpdatedDataJpaRepository.save(ReqClientUpdatedDataEntity.builder()
                        .id(ReqClientUpdatedDataKey.builder()
                                .code(item.getClientCode())
                                .modifiedDate(date)
                                .build())
                        .address(item.getAddress())
                        .city(item.getCity())
                        .handPhone(item.getHandphone())
                        .maritalStatus(item.getMaritalStatus())
                        .religion(item.getReligion())
                        .income(item.getIncome())
                        .sourceIncome(item.getSourceIncome())
                        .accountNo(item.getAccountNo())
                        .accountName(item.getAccountName())
                        .bankName(item.getBankName())
                        .occupation(item.getOccupation())
                        .email(item.getEmail())
                        .idCard(item.getIdCardNo())
                .build());

        ClientEntity clientEntity = clientJpaRepository.findById(item.getClientCode())
                .orElseThrow(() -> new ResourceNotFoundException("CLIENT NOT FOUND!"));
        clientJpaRepository.save(validateUpdatedFieldClientEntity(clientEntity, item));

        ClientPropertyEntity clientPropertyEntity = clientPropertyJpaRepository.findById(item.getClientCode())
                .orElseThrow(() -> new ResourceNotFoundException("CLIENT NOT FOUND!"));
        clientPropertyJpaRepository.save(validateUpdatedFieldClientPropertyEntity(clientPropertyEntity, item));

        return "Success";

    }

    private String formatBankName(String bankName) {
        String lowerCaseName = bankName.toLowerCase();
        if (lowerCaseName.contains("bca")) {
            return "BCA";
        } else if (lowerCaseName.contains("bng")) {
            return "CIMB NIAGA";
        } else if (lowerCaseName.contains("bma")) {
            return "BANK MANDIRI";
        } else if (lowerCaseName.contains("nob")) {
            return "NOBU BANK";
        } else {
            return bankName;
        }
    }

    private ClientEntity validateUpdatedFieldClientEntity(ClientEntity clientEntity, GetUpdatedClientData item){

        if(!item.getAddress().isEmpty()){
            clientEntity.setPhysicalAddress1(item.getAddress());
        }

        if(!item.getCity().isEmpty()){
            clientEntity.setPhysicalCity(item.getCity());
        }

        if(!item.getHandphone().isEmpty()){
            clientEntity.setContactOther(item.getHandphone());
        }

        if(!item.getAccountName().isEmpty()){
            clientEntity.setBankAccountName(item.getAccountName());
        }

        if(!item.getAccountNo().isEmpty()){
            clientEntity.setBankAccountNo(item.getAccountNo());
        }

        if(!item.getBankName().isEmpty()){
            clientEntity.setBankName(item.getBankName());
        }

        if(!item.getAddress().isEmpty()){
            clientEntity.setPhysicalAddress1(item.getAddress());
        }

        return clientEntity;
    }

    private ClientPropertyEntity validateUpdatedFieldClientPropertyEntity(ClientPropertyEntity clientPropertyEntity, GetUpdatedClientData item){

        if(!item.getMaritalStatus().isEmpty()){
            clientPropertyEntity.setMaritalStatus(item.getMaritalStatus());
        }

        if(!item.getReligion().isEmpty()){
            clientPropertyEntity.setReligion(item.getReligion());
        }

        if(!item.getIncome().isEmpty()){
            clientPropertyEntity.setIncomePerNum(item.getIncome());
        }

        if(!item.getSourceIncome().isEmpty()){
            clientPropertyEntity.setFundSourceText(item.getSourceIncome());
        }

        if(!item.getOccupation().isEmpty()){
            clientPropertyEntity.setOccupationText(item.getOccupation());
        }



        return clientPropertyEntity;
    }
}
