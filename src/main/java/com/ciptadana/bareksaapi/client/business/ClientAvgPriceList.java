package com.ciptadana.bareksaapi.client.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientAvgPriceList {
    private final String clientCode;
    private final String nShare;
    private final int avgPrice;
    private final String lastUpdated;
}
