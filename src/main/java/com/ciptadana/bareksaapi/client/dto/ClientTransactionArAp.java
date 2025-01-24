package com.ciptadana.bareksaapi.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientTransactionArAp {
    private String nClient;
    private String transDate;
    private String outStanding;
}
