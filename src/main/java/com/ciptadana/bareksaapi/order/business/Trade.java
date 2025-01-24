package com.ciptadana.bareksaapi.order.business;

import lombok.Builder;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Builder
public class Trade {

    private String seqNum;
    private String execId;
    private String tradeNumber;
    private BigInteger orderId;
    private String transActTime;
    private String effectiveTime;
    private String side;
    private String clorId;
    private String execBroker;
    private String contraTrader;
    private String contraBroker;
    private BigInteger price;
    private BigInteger cumQty;
    private String text;
    private String execType;
    private long lastPx;
    private long noContraBrokers;
    private long execTransType;
    private String orderStatus;
    private long leavesQty;
    private BigInteger avgPx;
    private String descriptionError;
    private String account;
    private String clientId;
    private double weightAveragePrice;
    private String symbol;
    private String symbolSFX;
    private long securityId;
    private String clearingAccount;
    private String futSettDate;
    private long isLot;
    private String complianceId;
    private long settFlag;
    private long tradeSeqNo;

    public void initialize() {
        seqNum = "0";
        execId = "0";
        effectiveTime = LocalDateTime.now().toString();
        execBroker = "KI";
        contraBroker = "";
        text = "";
        execType = "2";
        noContraBrokers = 1;
        execTransType = 3;
        orderStatus = "2";
        leavesQty = 0;
        avgPx = BigInteger.ZERO;
        descriptionError = "-";
        clientId = "KI";
        weightAveragePrice = 0;
        securityId = 0;
        clearingAccount = "-";
        isLot = 0;
        settFlag = 0;
        tradeSeqNo = 0;
    }
}
