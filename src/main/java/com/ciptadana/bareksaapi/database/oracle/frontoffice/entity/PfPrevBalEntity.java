package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PF_PREVBAL", schema = "BOGOR")
public class PfPrevBalEntity {

    @EmbeddedId
    private PfPrevBalKey id;

    @Column(name = "UPDTIME")
    private Timestamp updateTime;

    @Column(name = "PREVBAL")
    private int previousBalance;
}
