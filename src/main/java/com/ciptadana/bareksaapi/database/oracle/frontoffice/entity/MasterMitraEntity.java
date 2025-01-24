package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MASTER_MITRA", schema = "BAREKSA")
public class MasterMitraEntity {


    @Id
    @Column(name = "MITRA_CODE")
    private String mitraCode;

    @Column(name = "MITRA_NAME")
    private String mitraName;

    @Column(name = "CREATED_TIME")
    private Date createdTime;

}
