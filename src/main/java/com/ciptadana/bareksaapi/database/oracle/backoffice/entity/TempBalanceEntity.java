package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TEMP_BALANCE", schema = "DENPASAR")
@NamedStoredProcedureQuery(
        name = "PortfolioClientPL_Summary",
        procedureName = "DENPASAR.PortfolioClientPL_Summary",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "start", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "end", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "empty", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientCode", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = String.class)
        }
)
@ToString
public class TempBalanceEntity {

    @EmbeddedId
    private TempBalanceEntityKey id;

    @Column(name = "CODE")
    private int code;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DEBIT")
    private Long debit;

    @Column(name = "CREDIT")
    private Long credit;


    @Column(name = "DEBIT_DUE")
    private Date debitDue;

    @Column(name = "CREDIT_DUE")
    private Date creditDue;

    @Column(name = "NDAYS")
    private int ndays;

    @Column(name = "INTEREST")
    private Integer interest;

    @Column(name = "INVOICE_NO")
    private String invoiceNo;

    @Column(name = "INVOICE_DUE")
    private Date invoiceDue;

    @Column(name = "CLIENT_GROUP")
    private String clientGroup;

    @Column(name = "CLIENT_TYPE")
    private String clientType;

    @Column(name = "CURRENCY")
    private String currency;
}
