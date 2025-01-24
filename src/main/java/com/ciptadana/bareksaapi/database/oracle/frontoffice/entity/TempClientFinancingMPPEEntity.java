package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TEMP_CLIENT_FINANCING_MPPE", schema = "CORE")
public class TempClientFinancingMPPEEntity {

    @EmbeddedId
    private TempClientFinancingMPPEKey id;

    @Column(name = "TRANS_NO")
    private String transNo;

    @Column(name = "TRANS_PERIOD")
    private long transPeriod;

    @Column(name = "TRANS_DATE")
    private long transDate;

    @Column(name = "TRANS_DUE")
    private long transDue;

    @Column(name = "SIDE")
    private String side;

    @Column(name = "QUANTITY")
    private  long quantity;

    @Column(name = "PRICE")
    private long price;

    @Column(name = "AMOUNT")
    private long amount;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "LAST_UPDATED")
    private LocalDate lastUpdated;

}
