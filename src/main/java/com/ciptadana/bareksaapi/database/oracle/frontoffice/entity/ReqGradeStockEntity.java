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
@Table(name = "REQ_GRADE_STOCK", schema = "BAREKSA")
public class ReqGradeStockEntity {

    @Id
    @Column(name = "STOCKCODE")
    private String stockCode;

    @Column(name = "GRADE_STOCK")
    private String gradeStock;

    @Column(name = "MAX_CAPPING_AMOUNT")
    private int maxCappingAmount;

    @Column(name = "MAX_CAPPING_QTY")
    private int maxCappingQty;

    @Column(name = "EFFECTIVE_DATE")
    private String effectiveDate;

    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;
}
