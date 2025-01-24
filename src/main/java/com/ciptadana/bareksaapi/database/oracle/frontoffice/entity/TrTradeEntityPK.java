package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrTradeEntityPK implements Serializable {


    @Column(name = "TRADENUMBER")
    private String tradenumber;


    @Column(name = "ORDERID")
    private BigInteger orderid;
}
