package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class PfPrevBalKey implements Serializable {
    @Column(name = "NCLIENT")
    String nClient;

    @Column(name = "NSHARE")
    String nShare;
}
