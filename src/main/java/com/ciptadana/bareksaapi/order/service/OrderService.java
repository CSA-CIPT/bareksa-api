package com.ciptadana.bareksaapi.order.service;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TrOrderEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TrTradeEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TrTradeEntityPK;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.TrOrderJpaRepositoy;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.TrTradeRepository;
import com.ciptadana.bareksaapi.order.business.Order;
import com.ciptadana.bareksaapi.order.business.Trade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final TrTradeRepository trTradeRepository;
    private final TrOrderJpaRepositoy trOrderJpaRepositoy;

    public String uploadOrders(MultipartFile file){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));

             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withTrim())) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            List<Order> orders = new ArrayList<>();
            for (CSVRecord csvRecord : csvRecords) {
                Order order = Order.builder()
                        .orderId(csvRecord.get(1))
                        .clorId(csvRecord.get(0))
                        .account(csvRecord.get(12))
                        .symbol(csvRecord.get(6))
                        .symbolSfx(csvRecord.get(7))
                        .side(csvRecord.get(8))
                        .transactTime(csvRecord.get(14))
                        .cParty(csvRecord.get(13))
                        .orderQty(Integer.parseInt(csvRecord.get(9)))
                        .price(Integer.parseInt(csvRecord.get(10)))
                        .clearingAccount(csvRecord.get(4))
                        .complienceId(csvRecord.get(11))
                        .orderStatus(csvRecord.get(2))
                        .clientCode(csvRecord.get(3))
                        .build();
                order.initialize();
                order.validateOrderId();
                order.validateQty();
                orders.add(order);
            }

            List<TrOrderEntity> trOrderEntities = orders.stream()
                    .map(item -> TrOrderEntity.builder()
                    .orderid(Integer.valueOf(item.getOrderId()))
                    .clordid(item.getClorId())
                    .account(item.getAccount())
                    .symbol(item.getSymbol())
                    .symbolsfx(item.getSymbolSfx())
                    .side(item.getSide())
                    .transacttime(item.getTransactTime())
                    .cparty(item.getCParty())
                    .orderqty(BigInteger.valueOf(item.getOrderQty()))
                    .price(BigInteger.valueOf(item.getPrice()))
                    .clearingaccount(item.getClearingAccount())
                    .complianceid(item.getComplienceId())
                    .ordstatus(item.getOrderStatus())
                    .clientcode(item.getClientCode())
                    .orderparentid(item.getOrderParentId())
                    .obtid(Long.valueOf(item.getObtId()))
                    .omid(Long.valueOf(item.getOmId()))
                    .secondaryorderid(Long.valueOf(item.getSecondaryOrderId()))
                    .clientid(item.getClientId())
                    .handlinst(Long.valueOf(item.getHandlist()))
                    .securityid(BigInteger.valueOf(Long.parseLong(item.getSecurityId())))
                    .stoppx(BigInteger.valueOf(item.getStoppx()))
                    .expiredate(item.getExpireDate())
                    .text(item.getText())
                    .execid(item.getExecId())
                    .execrefid(String.valueOf(item.getExecRefId()))
                    .exectranstype(String.valueOf(item.getExecTransType()))
                    .exectype(String.valueOf(item.getExecType()))
                    .leavesqty(BigInteger.valueOf(item.getLeavesQty()))
                    .cumqty(BigInteger.valueOf(item.getCumQty()))
                    .avgpx(BigInteger.valueOf(item.getAvgPx()))
                    .lastpx(Long.valueOf(item.getOmId()))
                    .lastshares(String.valueOf(item.getLastShares()))
                    .cxlrejresponseto(String.valueOf(item.getCxlrejResponseto()))
                    .ioiid(String.valueOf(item.getIoiid()))
                    .futsettdate(String.valueOf(item.getFutsettDate()))
                    .execbroker(item.getExecBroker())
                    .tradedate(String.valueOf(item.getTradeDate()))
                    .description(item.getDescription())
                    .ownerid(item.getOwnerId())
                    .createdtime(item.getCreatedTime())
                    .updatedtime(item.getUpdatedTime())
                    .updateid(item.getUpdateId())
                    .apptype(Long.valueOf(item.getAppType()))
                    .msgtype(item.getMsgType())
                    .batchtime(String.valueOf(item.getBatchTime()))
                    .bulkid(BigInteger.valueOf(item.getBulkId()))
                    .sendersubid(item.getSenderSubId())
                    .build()
                    ).toList();

        trOrderJpaRepositoy.saveAll(trOrderEntities);
        } catch (Exception e) {
           log.error(e.getMessage());
        }

        return "Success";
    }

    public String uploadTrade(MultipartFile file){
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));

             CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withTrim())) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            List<Trade> trades = new ArrayList<>();

            for (CSVRecord csvRecord : csvRecords) {
                String orderId = csvRecord.get(1).replaceAll("-", "");
                Trade trade = Trade.builder()
                        .tradeNumber(csvRecord.get(2))
                        .orderId(new BigInteger(orderId))
                        .transActTime(csvRecord.get(14))
                        .side((csvRecord.get(8)))
                        .clorId(csvRecord.get(0))
                        .contraTrader(csvRecord.get(13))
                        .price(new BigInteger(csvRecord.get(10)))
                        .cumQty(new BigInteger(csvRecord.get(9)).divide(BigInteger.valueOf(100)))
                        .lastPx(Long.parseLong(csvRecord.get(10)))
                        .account(csvRecord.get(12))
                        .symbol(csvRecord.get(6))
                        .symbolSFX(csvRecord.get(7))
                        .futSettDate(csvRecord.get(4))
                        .complianceId(csvRecord.get(11))
                        .build();

                trade.initialize();
                trades.add(trade);
                log.info(trade.toString());
            }

            List<TrTradeEntity> tradeEntities = trades.stream().map(trade -> TrTradeEntity.builder()
                    .id(TrTradeEntityPK.builder()
                            .tradenumber(trade.getTradeNumber())
                            .orderid(trade.getOrderId())
                            .build())
                    .seqnum(trade.getSeqNum())
                    .execid(trade.getExecId())
                    .effectivetime(trade.getEffectiveTime())
                    .execbroker((trade.getExecBroker()))
                    .contrabroker(trade.getContraBroker())
                    .text(trade.getText())
                    .exectype(trade.getExecType())
                    .nocontrabrokers(BigInteger.valueOf(trade.getNoContraBrokers()))
                    .exectranstype(BigInteger.valueOf(trade.getExecTransType()))
                    .ordstatus(trade.getOrderStatus())
                    .leavesqty(BigInteger.valueOf(trade.getLeavesQty()))
                    .avgpx(trade.getAvgPx())
                    .descriptionError(trade.getDescriptionError())
                    .clientid(trade.getClientId())
                    .weightAveragePrice(trade.getWeightAveragePrice())
                    .securityid(BigInteger.valueOf(trade.getSecurityId()))
                    .clearingaccount(trade.getClearingAccount())
                    .isLot(BigInteger.valueOf(trade.getIsLot()))
                    .settflag(BigInteger.valueOf(trade.getSettFlag()))
                    .tradeseqno(BigInteger.valueOf(trade.getTradeSeqNo()))
                    .transacttime(trade.getTransActTime())
                    .side(trade.getSide())
                    .clordid(trade.getClorId())
                    .contratrader(trade.getContraTrader())
                    .price(trade.getPrice())
                    .cumqty(trade.getCumQty())
                    .lastpx(BigInteger.valueOf(trade.getLastPx()))
                    .account(trade.getAccount())
                    .symbol(trade.getSymbol())
                    .symbolsfx(trade.getSymbolSFX())
                    .futsettdate(trade.getFutSettDate())
                    .complianceid(trade.getComplianceId())
                    .build()).toList();

            trTradeRepository.saveAll(tradeEntities);

        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "Success";

    }

}
