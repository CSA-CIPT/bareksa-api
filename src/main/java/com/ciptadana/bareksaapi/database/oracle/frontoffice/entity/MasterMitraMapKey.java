package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Data
public class MasterMitraMapKey implements Serializable {

    @Column(name = "MITRA_CODE")
    private String mitraCode;

    @Column(name = "SALESMAN_ID")
    private String salesmanId;
}
