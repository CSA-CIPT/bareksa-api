package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OutstandingWithdrawal {

    @JsonProperty("withdrawal_id")
    private final String withdrawalId;
    private final String clientCode;
    private final String clientName;
    private final String amount;

    @JsonProperty("payment_date")
    private final String paymentDate;
}
