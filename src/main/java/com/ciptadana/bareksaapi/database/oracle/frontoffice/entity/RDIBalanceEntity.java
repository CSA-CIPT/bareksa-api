package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RDI_BALANCE", schema = "CORE")
public class RDIBalanceEntity {

    @EmbeddedId
    private RDIBalanceKey id;

    @Column(name = "RECDATE")
    private long recDate;

    @Column(name = "NOREK")
    private String norek;

    @Column(name = "BALANCE")
    private double balance;

    @Column(name = "CONTRABAL")
    private double contrabal;

    @Column(name = "ISREAD")
    private  int isRead;
}
