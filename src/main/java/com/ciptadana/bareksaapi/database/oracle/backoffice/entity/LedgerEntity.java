package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LEDGER", schema = "DENPASAR", catalog = "")

public class LedgerEntity {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "TRANS_PERIOD")
    private String transPeriod;

    @Column(name = "TRANS_MODULE")
    private int transModule;

    @Column(name = "TRANS_NO")
    private String transNo;

    @Column(name = "TRANS_DATE")
    private Date transDate;

    @Column(name = "TRANS_DUEDATE")
    private Date transDuedate;

    @Column(name = "TRANS_CURRENT")
    private Boolean transCurrent;

    @Column(name = "NSHARE")
    private String nshare;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "SUBACCOUNT_TYPE")
    private int subAccountType;

    @Column(name = "SUBACCOUNT")
    private String subAccount;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "NFAKTUR")
    private String nfaktur;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "EXCHANGERATE")
    private Integer exchangeRate;

    @Column(name = "AMOUNTIDR")
    private Long amountIdr;

    @Column(name = "CONTRACT_DUEDATE")
    private Date contractDuedate;
}
