package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TR_TRADES", schema = "CORE", catalog = "")
public class TrTradeEntity {

    @EmbeddedId
    private TrTradeEntityPK id;

    @Column(name = "SEQNUM")
    private String seqnum;

    @Column(name = "EXECID")
    private String execid;

    @Column(name = "TRANSACTTIME")
    private String transacttime;

    @Column(name = "EFFECTIVETIME")
    private String effectivetime;

    @Column(name = "SIDE")
    private String side;

    @Column(name = "CLORDID")
    private String clordid;

    @Column(name = "EXECBROKER")
    private String execbroker;

    @Column(name = "CONTRATRADER")
    private String contratrader;

    @Column(name = "CONTRABROKER")
    private String contrabroker;

    @Column(name = "PRICE")
    private BigInteger price;

    @Column(name = "CUMQTY")
    private BigInteger cumqty;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "EXECTYPE")
    private String exectype;

    @Column(name = "LASTPX")
    private BigInteger lastpx;

    @Column(name = "NOCONTRABROKERS")
    private BigInteger nocontrabrokers;

    @Column(name = "EXECTRANSTYPE")
    private BigInteger exectranstype;

    @Column(name = "ORDSTATUS")
    private String ordstatus;

    @Column(name = "LEAVESQTY")
    private BigInteger leavesqty;

    @Column(name = "AVGPX")
    private BigInteger avgpx;

    @Column(name = "PROCESSED_AT")
    private String processedAt;

    @Column(name = "DESCRIPTION_ERROR")
    private String descriptionError;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "CLIENTID")
    private String clientid;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "SYMBOLSFX")
    private String symbolsfx;

    @Column(name = "SECURITYID")
    private BigInteger securityid;

    @Column(name = "CLEARINGACCOUNT")
    private String clearingaccount;

    @Column(name = "FUTSETTDATE")
    private String futsettdate;

    @Column(name = "IS_LOT")
    private BigInteger isLot;

    @Column(name = "COMPLIANCEID")
    private String complianceid;

    @Column(name = "WEIGHT_AVERAGE_PRICE")
    private Double weightAveragePrice;

    @Column(name = "SETTFLAG")
    private BigInteger settflag;

    @Column(name = "TRADESEQNO")
    private BigInteger tradeseqno;
}
