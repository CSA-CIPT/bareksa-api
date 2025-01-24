package com.ciptadana.bareksaapi.database.mysql.payment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "DRAW_SUM_OT", schema = "WITHDRAW")
public class DrawSumOtDevEntity {
    @Id
    @Column(name = "DRAW_ID")
    private int drawId;

    @Column(name = "NO_URUT")
    private String noUrut;

    @Column(name = "CLIENT_CODE")
    private String clientCode;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "STAT_AMOUNT")
    private String statAmount;

    @Column(name = "WD_DATE")
    private Date wdDate;

    @Column(name = "NAMA_BANK")
    private String namaBank;

    @Column(name = "ACC_NOMOR")
    private String accNomor;

    @Column(name = "ACC_NAMA")
    private String accNama;

    @Column(name = "ORDER_DATE")
    private Date orderDate;

    @Column(name = "LASTUPDATE")
    private Timestamp lastUpdate;

    @Column(name = "AGREEMENT")
    private String agreement;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "ALASAN")
    private String alasan;

    @Column(name = "REJECT")
    private String reject;

    @Column(name = "CEK_CREL")
    private int cekCrel;

    @Column(name = "CEK_CRIS")
    private int cekCris;

    @Column(name = "CEK_FIN")
    private int cekFin;

    @Column(name = "ACC_INVESTOR")
    private String accInvestor;

    @Column(name = "EMAILMARK")
    private int emailMark;
}
