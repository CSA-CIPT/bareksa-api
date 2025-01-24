package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "RDI_BALANCE_HISTORICAL")
public class RdiBalanceHistoricalEntity {

    @Id
    @Column(name = "CLIENTCODE")
    private String clientCode;

    @NotNull
    @Column(name = "RECDATE", nullable = false)
    private Long recdate;

    @NotNull
    @Column(name = "RECTIME", nullable = false)
    private Long rectime;

    @Size(max = 20)
    @NotNull
    @Column(name = "NOREK", nullable = false, length = 20)
    private String norek;

    @NotNull
    @Column(name = "BALANCE", nullable = false)
    private Double balance;

    @NotNull
    @Column(name = "CONTRABAL", nullable = false)
    private Double contrabal;

    @Column(name = "CONTRADATE")
    private Long contradate;

    @NotNull
    @Column(name = "ISREAD", nullable = false)
    private Boolean isread = false;

}