package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "TR_ORDERS", schema = "CORE", catalog = "")
public class TrOrderEntity {

    @Id
    @Column(name = "CLORDID")
    private String clordid;

    @Column(name = "ORDERPARENTID")
    private String orderparentid;

    @Column(name = "ORIGCLORDID")
    private String origclordid;

    @Column(name = "OBTID")
    private Long obtid;

    @Column(name = "OMID")
    private Long omid;

    @Column(name = "ORDERID")
    private Integer orderid;

    @Column(name = "SECONDARYORDERID")
    private Long secondaryorderid;

    @Column(name = "CLIENTID")
    private String clientid;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "HANDLINST")
    private Long handlinst;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "SYMBOLSFX")
    private String symbolsfx;

    @Column(name = "SECURITYID")
    private BigInteger securityid;

    @Column(name = "SIDE")
    private String side;

    @Column(name = "TRANSACTTIME")
    private String transacttime;

    @Column(name = "ORDERQTY")
    private BigInteger orderqty;

    @Column(name = "PRICE")
    private BigInteger price;

    @Column(name = "STOPPX")
    private BigInteger stoppx;

    @Column(name = "EXPIREDATE")
    private String expiredate;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CLEARINGACCOUNT")
    private String clearingaccount;

    @Column(name = "COMPLIANCEID")
    private String complianceid;

    @Column(name = "EXECID")
    private String execid;

    @Column(name = "EXECREFID")
    private String execrefid;

    @Column(name = "EXECTRANSTYPE")
    private String exectranstype;

    @Column(name = "EXECTYPE")
    private String exectype;

    @Column(name = "ORDSTATUS")
    private String ordstatus;

    @Column(name = "LEAVESQTY")
    private BigInteger leavesqty;

    @Column(name = "CUMQTY")
    private BigInteger cumqty;

    @Column(name = "AVGPX")
    private BigInteger avgpx;

    @Column(name = "LASTPX")
    private Long lastpx;

    @Column(name = "LASTSHARES")
    private String lastshares;

    @Column(name = "CXLREJRESPONSETO")
    private String cxlrejresponseto;

    @Column(name = "IOIID")
    private String ioiid;

    @Column(name = "FUTSETTDATE")
    private String futsettdate;

    @Column(name = "EXECBROKER")
    private String execbroker;

    @Column(name = "TRADEDATE")
    private String tradedate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "OWNERID")
    private String ownerid;

    @Column(name = "CREATEDTIME")
    private String createdtime;

    @Column(name = "UPDATEDTIME")
    private String updatedtime;

    @Column(name = "UPDATEID")
    private String updateid;

    @Column(name = "CLIENTCODE")
    private String clientcode;

    @Column(name = "APPTYPE")
    private Long apptype;

    @Column(name = "BATCHID")
    private Long batchid;

    @Column(name = "REASON_TEXT")
    private String reasonText;

    @Column(name = "BATCHTIME")
    private String batchtime;

    @Column(name = "ORDSEQNO")
    private BigInteger ordseqno;

    @Column(name = "MSGTYPE")
    private String msgtype;

    @Column(name = "CPARTY")
    private String cparty;

    @Column(name = "QTYSPLITTER")
    private String qtysplitter;

    @Column(name = "BULKID")
    private BigInteger bulkid;

    @Column(name = "SENDERSUBID")
    private String sendersubid;

}
