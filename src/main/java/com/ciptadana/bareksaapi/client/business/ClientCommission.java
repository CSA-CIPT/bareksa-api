package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class ClientCommission {

    @JsonProperty("code")
    private final String clientId;
    private final String name;
    private final String sid;
    private final String effective;

    @JsonProperty("commission_buy")
    private final String commissionBuy;

    @JsonProperty("commission_Sell")
    private final String commissionSell;

    @JsonProperty("minimum_commission")
    private final String minimumCommission;
    private final String rnum;
}
