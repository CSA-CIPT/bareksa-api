package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientCharge {

    @JsonProperty("code")
    private final String clientId;
    private final String name;

    @JsonProperty("effective_date")
    private final String effective;

    @JsonProperty("less_Fund_Rate")
    private final String lessFundRate;

    private final String rnum;
}
