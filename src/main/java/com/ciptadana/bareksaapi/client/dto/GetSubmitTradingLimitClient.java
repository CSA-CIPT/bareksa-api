package com.ciptadana.bareksaapi.client.dto;

import lombok.Data;

@Data
public class GetSubmitTradingLimitClient {
    private String code;
    private int xCash;
    private int xStock;
    private int xRdpu;
    private float feeBuy;
    private float feeSell;
    private String effectiveDate;
    private String submitDate;
    private int credit;
}
