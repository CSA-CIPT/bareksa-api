package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TRANSACTION_AR_AP", schema = "BAREKSA")
public class TransactionArApEntity {
    @Id
    private TransactionArApKey id;

    @Column(name = "RECDATE")
    private Date recDate;

    @Column(name = "OUTSTANDING")
    private int outstanding;

    @Column(name = "RDN_AMOUNT")
    private int rdnAmount;

    @Column(name = "OLD_SUSPENDED")
    private int oldSuspended;

    @Column(name = "NEW_SUSENDED")
    private int newSuspended;

    @Column(name = "NEW_EFFECTIVE")
    private Date newEffective;

    @Column(name = "FLAGSP")
    private int flagsp;

    @Column(name = "NOTES")
    private String notes;
}
