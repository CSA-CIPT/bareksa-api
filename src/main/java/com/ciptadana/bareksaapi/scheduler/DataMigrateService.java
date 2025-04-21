package com.ciptadana.bareksaapi.scheduler;

import com.ciptadana.bareksaapi.config.DataSyncConfig;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.TPaymentWithdrawJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.ClientChargeJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.ClientCommissionJpaRepository;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCharge;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCommission;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.PfPrevBalEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.RdiBalanceHistoricalEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TempClientFinancingMPPEEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.*;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientAveragePrice;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientListMPPE;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientThreeDaysDistinct;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetRDNBareksa;
import com.ciptadana.bareksaapi.database.postgres.entity.*;
import com.ciptadana.bareksaapi.database.postgres.repository.*;
import com.ciptadana.bareksaapi.util.AsyncUtil;
import com.ciptadana.bareksaapi.util.FormatDate;
import com.ciptadana.bareksaapi.util.ReflectionUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataMigrateService {
    private final DataSyncConfig dataSyncConfig;
    private final ReflectionUtil reflectionUtil;
    private final FormatDate formatDate;
    private final MasterMitraMapJpaRepository masterMitraMapJpaRepository;
    private final ClientMppeJpaRepository clientMppeJpaRepository;
    private final BareksaClientCommissionJpaRepository bareksaClientCommissionJpaRepository;
    private final ClientCommissionJpaRepository clientCommissionJpaRepository;
    private final ClientChargeJpaRepository clientChargeJpaRepository;
    private final BareksaClientChargeJpaRepository bareksaClientChargeJpaRepository;
    private final RDNBalanceJpaRepository rdnBalanceJpaRepository;
    private final TPaymentWithdrawJpaRepository tPaymentWithdrawJpaRepository;
    private final BareksaClientRDNJpaRepository bareksaClientRDNJpaRepository;
    private final ClientPortfolioPrevBalJpaRepository clientPortfolioPrevBalJpaRepository;
    private final BareksaClientPortfolioPrevBalanceJpaRepository bareksaClientPortfolioPrevBalanceJpaRepository;
    private final TempClientFinancingMPPEJpaRepository tempClientFinancingMPPEJpaRepository;
    private final BareksaClientFinancingJpaRepository bareksaClientFinancingJpaRepository;
    private final RdiBalanceHistoricalJpaRepository rdiBalanceHistoricalJpaRepository;
    private final BareksaRDNListHistoricalJpaRepository bareksaRDNListHistoricalJpaRepository;
    private final AsyncUtil asyncUtil;
    private final TempClientThreeDaysJpaRepository tempClientThreeDaysJpaRepository;
    private final BareksaClientThreeDaysJpaRepository bareksaClientThreeDaysJpaRepository;
    private final BareksaAveragePriceListJpaRepository bareksaAveragePriceListJpaRepository;

    public void startMigrate(){
        if(dataSyncConfig.isMigrate()){
            log.info("START MIGRATING");
            scheduleSync();
            log.info("FINISH MIGRATING");
        }

    }

    private void syncAll(){
        try{
            syncClientListMppe();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        try{
            syncClientCommission();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        try{
            syncClientCharge();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }


        try{
            syncClientRdn();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        try{
            syncClientPortfolio();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        try{
            syncClientFinancing();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }


        try{
            syncClientThreeDays();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }


        try{
            syncRdiBalanceHistorical();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }

        try{
            syncAveragePrice();
        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }


//        CompletableFuture<Void> syncClientList = asyncUtil.runAsync(this::, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientCommission = asyncUtil.runAsync(this::syncClientCommission, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientCharge = asyncUtil.runAsync(this::syncClientCharge, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientRdn = asyncUtil.runAsync(this::syncClientRdn, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientPortfolio = asyncUtil.runAsync(this::syncClientPortfolio, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientFinancing = asyncUtil.runAsync(this::syncClientFinancing, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> syncClientThreeDays = asyncUtil.runAsync(this::syncClientThreeDays, Executors.newVirtualThreadPerTaskExecutor());
//        CompletableFuture<Void> allOf = CompletableFuture.allOf(
////                syncClientList,
//                syncClientCommission,
//                syncClientCharge,
//                syncClientRdn,
//                syncClientPortfolio,
//                syncClientFinancing,
//                syncClientThreeDays
//        );

      //  allOf.join();
    }

    private void syncClientFinancing() {
        log.info("Start sync client financing");
        List<BareksaClientFinancingEntity> clientFinancing = tempClientFinancingMPPEJpaRepository.getCurrentPeriod().stream()
                .map(this::toBareksaClientFinancingEntity)
                .toList();
        bareksaClientFinancingJpaRepository.saveAll(clientFinancing);
        log.info("Finish sync client financing: {}", clientFinancing.size());
    }

    private void syncClientPortfolio() {
        log.info("Start sync client portfolio");
        List<BareksaClientPortfolioPrevBalanceEntity> portfolios = clientPortfolioPrevBalJpaRepository.getAllPreviousBalance().stream()
                .map(this::toBareksaClientPortfolioPrevBalanceEntity)
                .toList();
        bareksaClientPortfolioPrevBalanceJpaRepository.saveAll(portfolios);
        log.info("Finish sync client portfolio: {}", portfolios.size());
    }

    private void syncClientRdn() {
        log.info("Start sync client RDN");
        List<BareksaClientRDNEntity> clientRdn = rdnBalanceJpaRepository.getAllBareksaRDN().parallelStream()
                .map(this::toBareksaClientRDNEntity)
                .toList();
        bareksaClientRDNJpaRepository.saveAll(clientRdn);
        log.info("Finish sync client RDN: {}", clientRdn.size());
    }

    private void syncClientCharge() {
        log.info("Start sync client charge");
        List<BareksaClientChargeEntity> clientCharges = clientChargeJpaRepository.getAllClientCharges().stream()
                .map(this::toBareksaClientChargeEntity)
                .toList();
        bareksaClientChargeJpaRepository.saveAll(clientCharges);
        log.info("Finish sync client charge: {}", clientCharges.size());
    }

    private void syncClientListMppe() {
        log.info("Start sync client list mppe");
        List<ClientMppeEntity> clients = masterMitraMapJpaRepository.getAllClientMppe()
                .stream()
                .map(this::toClientMppeEntity)
                .toList();
        clientMppeJpaRepository.saveAll(clients);
        log.info("Finish sync client list mppe: {}", clients.size());
    }

    private void syncClientCommission() {
        log.info("Start sync client commission");
        List<BareksaClientCommissionEntity> clientCommissions = clientCommissionJpaRepository.getClientCommission().stream()
                .map(this::toBareksaClientCommissionEntity)
                .toList();
        bareksaClientCommissionJpaRepository.saveAll(clientCommissions);
        log.info("Finish sync client commission: {}", clientCommissions.size());
    }

    private void syncClientThreeDays(){
        log.info("Start sync client three-days");
        List<BareksaClientThreeDaysEntity> threeDays = tempClientThreeDaysJpaRepository.getClientThreeDays().stream()
                .map(this::toBareksaClientThreeDaysEntity)
                .toList();
        bareksaClientThreeDaysJpaRepository.saveAll(threeDays);
        log.info("Finish sync client three-days: {}", threeDays.size());
    }

    //clientcode
    //norek
    private void syncRdiBalanceHistorical(){
        log.info("Start sync rdi balance historical");
        Set<String> seen = new HashSet<>();
        List<BareksaRDNListHistoricalEntity> entities = rdiBalanceHistoricalJpaRepository.getBareksa().stream()
                .map(this::toBareksaRDNListHistoricalEntity)
                .filter(entity -> seen.add(entity.getClientId()))
                .toList();


        bareksaRDNListHistoricalJpaRepository.saveAll(entities);
        log.info("Finish sync rdi balance historical: {}", entities.size());
    }

    private void syncAveragePrice(){
        log.info("Start sync average price");
        List<BareksaAveragePriceListEntity> entities = masterMitraMapJpaRepository.getClientAveragePrice().stream()
                .map(this::toBareksaAveragePriceListEntity)
                .toList();
        bareksaAveragePriceListJpaRepository.saveAll(entities);
        log.info("Finish sync average price: {}", entities.size());
    }


    public void scheduleSync(){

        clientMppeJpaRepository.deleteAll();
        bareksaClientCommissionJpaRepository.deleteAll();
        bareksaClientChargeJpaRepository.deleteAll();
        bareksaClientRDNJpaRepository.deleteAll();
        bareksaRDNListHistoricalJpaRepository.deleteAll();
        bareksaClientPortfolioPrevBalanceJpaRepository.deleteAll();
        bareksaClientFinancingJpaRepository.deleteAll();
        bareksaClientThreeDaysJpaRepository.deleteAll();
        bareksaAveragePriceListJpaRepository.deleteAll();
        syncAll();
        log.info("Finish sync data");
        
    }

    private ClientMppeEntity toClientMppeEntity(GetClientListMPPE client){
        ClientMppeEntity entity = ClientMppeEntity.builder()
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
                .tradingLimit(client.getTradingLimit())
                .memberSince(client.getMemberSince())
                .lastModified(client.getLastModified())
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(entity);
        return entity;

    }

    private BareksaClientCommissionEntity toBareksaClientCommissionEntity(GetClientCommission client){
        BareksaClientCommissionEntity bareksaClientCommissionEntity = BareksaClientCommissionEntity.builder()
                .clientId(client.getClientId())
                .sid(client.getSid())
                .name(client.getName())
                .effective(client.getEffective().toString())
                .commissionBuy(client.getCommissionBuy())
                .commissionSell(client.getCommissionSell())
                .minimumCommission(client.getMinimumCommission())
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(bareksaClientCommissionEntity);
        return bareksaClientCommissionEntity;
    }

    private BareksaClientChargeEntity toBareksaClientChargeEntity(GetClientCharge client){
        BareksaClientChargeEntity bareksaClientChargeEntity = BareksaClientChargeEntity.builder()
                .clientId(client.getClientId())
                .name(client.getName())
                .effective(client.getEffective().toString())
                .lessFundRate(client.getLessFundRate() == null ? 0 : Double.parseDouble(client.getLessFundRate()))
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(bareksaClientChargeEntity);
        return bareksaClientChargeEntity;
    }

    private BareksaClientRDNEntity toBareksaClientRDNEntity(GetRDNBareksa rdnBareksa){
        String code = rdnBareksa.getClientCode();
        Long sumAmountThreeDays = Optional.ofNullable(rdnBalanceJpaRepository.getBalanceSumThreeDaysByClientCode(code))
                .orElse(0L);

        Long sumWithdraw = Optional.ofNullable(tPaymentWithdrawJpaRepository.getSumPaymentSaldoByClientCode(code))
                .orElse(0L);
        BareksaClientRDNEntity entity = BareksaClientRDNEntity.builder()
                .clientId(code)
                .norek(rdnBareksa.getNoRek())
                .recTime(rdnBareksa.getRecTime())
                .recDate(rdnBareksa.getRecDate())
                .balance(rdnBareksa.getBalance())
                .norek(rdnBareksa.getNoRek())
                .bankNameInvestor(rdnBareksa.getBankNameInvestor())
                .sumWithdraw(BigInteger.valueOf(sumWithdraw))
                .sumAmountThreeDays(BigInteger.valueOf(sumAmountThreeDays))
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(entity);
        return entity;
    }

    private BareksaClientPortfolioPrevBalanceEntity toBareksaClientPortfolioPrevBalanceEntity(PfPrevBalEntity entity){
        BareksaClientPortfolioPrevBalanceEntity bareksaClientPortfolioPrevBalanceEntity = BareksaClientPortfolioPrevBalanceEntity.builder()
                .id(BareksaClientPortfolioPrevBalanceKey.builder()
                        .clientId(entity.getId().getNClient())
                        .nShare(entity.getId().getNShare())
                        .build())
                .prevbal(BigInteger.valueOf(entity.getPreviousBalance()))
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(bareksaClientPortfolioPrevBalanceEntity);
        return bareksaClientPortfolioPrevBalanceEntity;
    }


    private BareksaClientFinancingEntity toBareksaClientFinancingEntity(TempClientFinancingMPPEEntity entity){
        BareksaClientFinancingEntity bareksaClientFinancingEntity = BareksaClientFinancingEntity.builder()
                .transSeq(entity.getId().getTransSeq())
                .transNo(entity.getTransNo())
                .transPeriod(entity.getTransPeriod())
                .transDue(entity.getTransDue())
                .transDate(entity.getTransDate())
                .clientId(String.valueOf(entity.getId().getClientCode()))
                .side(entity.getSide())
                .quantity(entity.getQuantity())
                .price(entity.getPrice())
                .amount(entity.getAmount())
                .description(entity.getDescription())
                .lastUpdate(String.valueOf(entity.getLastUpdated()))
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(bareksaClientFinancingEntity);
        return bareksaClientFinancingEntity;
    }

    private BareksaClientThreeDaysEntity toBareksaClientThreeDaysEntity(GetClientThreeDaysDistinct client){
        BareksaClientThreeDaysKey bareksaClientThreeDaysKey = new BareksaClientThreeDaysKey();
        bareksaClientThreeDaysKey.setClientId(client.getSubAccount());

        LocalDate now = LocalDate.now();
        LocalDate dueDate = LocalDate.parse(formatDate.formatYYYYmmDDHypen(client.getTransDueDate()));
        String transDueDate;
        if(dueDate.isEqual(now)){
            transDueDate = "0";
        }else{
            transDueDate = "1";
        }
        bareksaClientThreeDaysKey.setTransDueDate(transDueDate);
        bareksaClientThreeDaysKey.setDueDate(dueDate.toString());

        BareksaClientThreeDaysEntity entity = BareksaClientThreeDaysEntity.builder()
                .id(bareksaClientThreeDaysKey)
                .name(client.getName())
                .amount(client.getAmount())
                .amountIdr(client.getAmountIdr())
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(entity);
        return entity;
    }

    private BareksaRDNListHistoricalEntity toBareksaRDNListHistoricalEntity(RdiBalanceHistoricalEntity entity){
        BareksaRDNListHistoricalEntity bareksaRDNListHistoricalEntity = BareksaRDNListHistoricalEntity.builder()
                .recDate(entity.getRecdate())
                .recTime(entity.getRectime())
                .clientId(entity.getClientCode())
                .noRek(entity.getNorek())
                .balance(BigDecimal.valueOf(entity.getBalance()))
                .contraBal(BigDecimal.valueOf(entity.getContrabal()))
                .contraDate(entity.getContradate())
                .isNew(true)
                .build();

        reflectionUtil.assignDefaultValues(bareksaRDNListHistoricalEntity);
        return bareksaRDNListHistoricalEntity;
    }

    private BareksaAveragePriceListEntity toBareksaAveragePriceListEntity(GetClientAveragePrice averagePrice){
        BareksaAveragePriceListEntity entity = BareksaAveragePriceListEntity.builder()
                .id(BareksaAveragePriceListKey.builder()
                        .clientId(averagePrice.getClientCode())
                        .nShare(averagePrice.getNShare())
                        .build())
                .averagePrice(BigDecimal.valueOf(averagePrice.getAveragePrice()))
                .lastUpdated(averagePrice.getLastUpdated())
                .isNew(true)
                .build();
        reflectionUtil.assignDefaultValues(entity);
        return entity;
    }
}
