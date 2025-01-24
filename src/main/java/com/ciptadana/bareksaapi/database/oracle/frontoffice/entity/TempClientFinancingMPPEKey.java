package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;


import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class TempClientFinancingMPPEKey implements Serializable {

    @Column(name = "TRANS_SEQ")
    private long transSeq;

    @Column(name = "CLIENTCODE")
    private long clientCode;

}
