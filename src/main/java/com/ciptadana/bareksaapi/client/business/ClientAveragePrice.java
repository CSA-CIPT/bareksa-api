package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAveragePrice {
    private final String clientCode;
    private final String nShare;

    @JsonProperty("average_price")
    private final String averagePrice;

    @JsonProperty("last_updated")
    private final String lastUpdated;

    @JsonProperty("rwn_to_remove")
    private final String rnum;
}
