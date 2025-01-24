package com.ciptadana.bareksaapi.master.dto;

import lombok.Data;

@Data
public class GetSumbitGradeStock {
    private final String stockCode;
    private final String gradeStock;
    private final int maxCappingAmount;
    private final int maxCappingQty;
    private final String effectiveDate;
}
