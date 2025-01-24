package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientAvgPriceList;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientAvgPriceListResponse {
    private long total;
    private List<ClientAvgPriceList> clientAvgPriceLists;
}
