package com.ciptadana.bareksaapi.client.dto;

import lombok.Data;

@Data
public class GetProfitLoss {
    private final String startDate;
    private final String endDate;
    private final String clientCode;
}