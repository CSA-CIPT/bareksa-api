package com.ciptadana.bareksaapi.master.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetMasterStockResponse {

    @JsonProperty("stock_id")
    private final int stockId;

    @JsonProperty("stock_code")
    private final String stockCode;

    @JsonProperty("stock_name")
    private final String stockName;

    @JsonProperty("subsector_id")
    private final int subSectorId;
    private final String status;
    private final String board;
    private final String colorHex;
    private final String securityType;
    private final String preOpeningFlag;
    private final String markingPercent;

    @JsonProperty("is_margin")
    private final String isMargin;

}
