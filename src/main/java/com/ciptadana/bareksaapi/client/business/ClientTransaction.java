package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientTransaction {
    private final String nDeal;
    private final String quantity;
    private final String price;
    private final String clientCode;
    private final String stockCode;
    private final String dealDate;

    @JsonProperty("settle_date")
    private final String settleDate;

    @JsonProperty("amount_nett")
    private final String amountNett;
}
