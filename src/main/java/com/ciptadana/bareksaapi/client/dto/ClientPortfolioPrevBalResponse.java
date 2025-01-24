package com.ciptadana.bareksaapi.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPortfolioPrevBalResponse {
    private String nclient;
    private String nshare;
    private String prevbal;
}
