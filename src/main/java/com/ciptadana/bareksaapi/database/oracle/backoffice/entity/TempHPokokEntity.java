package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEMP_HPOKOK", schema = "DENPASAR")
public class TempHPokokEntity {

    @Id
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "TRANS_PERIOD")
    private String transPeriod;

    @Column(name = "TRANS_MODULE")
    private int transModule;

    @Column(name = "TRANS_NO")
    private String transNo;

    @Column(name = "TRANS_DATE")
    private LocalDate transDate;

    @Column(name = "TRANS_DUEDATE")
    private LocalDate transDuedate;

    @Column(name = "TRANS_CURRENT")
    private Boolean transCurrent;

    @Column(name = "NSHARE")
    private String nshare;

    @Column(name = "NCLIENT")
    private String nClient;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "SUBACCOUNT_TYPE")
    private int subAccountType;

    @Column(name = "SUBACCOUNT")
    private String subAccount;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "NFAKTUR")
    private String nFaktur;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QBUY")
    private BigDecimal qbuy;

    @Column(name = "QSELL")
    private BigDecimal qsell;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "EXCHANGERATE")
    private Integer exchangeRate;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "AMOUNTIDR")
    private BigDecimal amountIDR;

    @Column(name = "DEBIT")
    private BigDecimal debit;

    @Column(name = "DEBITIDR")
    private BigDecimal debitIDR;

    @Column(name = "CREDIT")
    private BigDecimal credit;

    @Column(name = "CREDITIDR")
    private BigDecimal creditIDR;

    @Column(name = "PL")
    private BigDecimal pl;

    @Column(name = "PLIDR")
    private BigDecimal plidr;

    @Column(name = "CONTRACT_DUEDATE")
    private LocalDate contractDueDate;
}
