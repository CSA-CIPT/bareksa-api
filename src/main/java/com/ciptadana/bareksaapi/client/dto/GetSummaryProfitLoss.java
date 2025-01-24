package com.ciptadana.bareksaapi.client.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class GetSummaryProfitLoss {

    @NotEmpty
    private final String startDate;

    @NotEmpty
    private final String endDate;

    @NotNull
    private final String clientCode;
}
