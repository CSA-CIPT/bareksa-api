package com.ciptadana.bareksaapi.order.business;

import com.sun.jdi.event.StepEvent;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
@Data
@Builder
public class Order {
    private String orderParentId;
    private int obtId;
    private int omId;
    private String orderId;
    private String secondaryOrderId;
    private String clorId;
    private String clientId;
    private String account;
    private String handlist;
    private String symbol;
    private String symbolSfx;
    private String securityId;
    private String side;
    private String transactTime;
    private String cParty;
    private int orderQty;
    private int price;
    private int stoppx;
    private String expireDate;
    private String text;
    private String clearingAccount;
    private String complienceId;
    private String execId;
    private int execRefId;
    private int execTransType;
    private int execType;
    private String orderStatus;
    private int leavesQty;
    private int cumQty;
    private int avgPx;
    private int lastPx;
    private int lastShares;
    private int cxlrejResponseto;
    private int ioiid;
    private int futsettDate;
    private String execBroker;
    private int tradeDate;
    private String description;
    private String ownerId;
    private String createdTime;
    private String updatedTime;
    private String updateId;
    private String clientCode;
    private String  appType;
    private String msgType;
    private int batchTime;
    private int bulkId;
    private String senderSubId;

    public void initialize(){
        LocalDate date = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmssSSS");
        orderParentId = "";
        orderId = "0";
        obtId = 0;
        omId = 0;
        secondaryOrderId = "0";
        clientId = "kift1003";
        handlist =  "1";
        securityId = "0";
        stoppx = 0;
        expireDate = date.toString();
        text = "";
        execId = now.format(formatter);
        execRefId = -1;
        execTransType = 0;
        execType = 0;
        leavesQty = 0;
        cumQty = 0;
        avgPx = 0;
        lastPx = 0;
        lastShares = 0;
        cxlrejResponseto = 0;
        ioiid = 0;
        futsettDate = 2;
        execBroker = "-";
        tradeDate = 0;
        description = "";
        ownerId = "bareksa";
        createdTime = dateTime.format(dateTimeFormatter).toString();
        updatedTime = dateTime.format(dateTimeFormatter).toString();
        updateId = "bareksa";
        appType = "2";
        msgType = "D";
        batchTime = 0;
        bulkId = -1;
        senderSubId = "RMS";

    }

    public void validateOrderId() {
        if (orderId.length() == 0) {
            orderId = "0";
        }
    }
    public void validateQty() {
        if (!symbolSfx.equals("ONG")) {
            orderQty = orderQty/100;;
        }

    }

}
