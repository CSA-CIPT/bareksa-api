package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;

import java.io.Serializable;

public class TransactionArApKey implements Serializable {
    @Column(name = "NCLIENT")
    private String nClient;

    @Column(name = "TRANS_DATE")
    private String transDate;
}
