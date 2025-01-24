package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class RDIBalanceKey implements Serializable {

    @Column(name = "REC_TIME")
    private String recTime;

    @Column(name = "CLIENTCODE")
    private String clientCode;
}
