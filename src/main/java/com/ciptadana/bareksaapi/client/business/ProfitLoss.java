package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
public class ProfitLoss {
    private final String nShare;

    @JsonProperty("trans_date")
    private final String transDate;
    private final String qBuy;
    private final String qSell;
    private final String credit;
    private final String debit;
    private final String price;
    private final String profitLoss;
}
