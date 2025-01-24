package com.ciptadana.bareksaapi.client.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetRDNBalanceDTO {
    private final String recDate;
    private final String recTime;
    private final String clientCode;
    private final String noRek;
    private final String balance;
    private final String contraBal;
    private final String bankNameInvestor;
}
