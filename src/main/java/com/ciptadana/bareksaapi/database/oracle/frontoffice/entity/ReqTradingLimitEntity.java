package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "REQ_TRADING_LIMIT", schema = "BAREKSA")
public class ReqTradingLimitEntity {
    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "XCASH")
    private int xCash;

    @Column(name = "XSTOCK")
    private int xStock;

    @Column(name = "XRDPU")
    private int xRdpu;

    @Column(name = "FEE_BUY")
    private float feeBuy;

    @Column(name = "FEE_SELL")
    private float feeSell;

    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate;

    @Column(name = "SUBMIT_DATE")
    private String submitDate;

    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;

    @Column(name = "CREDIT")
    private int credit;
}
