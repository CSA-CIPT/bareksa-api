package com.ciptadana.bareksaapi.client.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SummaryProfitLoss {
    private final String account;
    private final String subAccount;
    private final String name;
    private final String debit;
    private final String credit;
    private final String profitLoss;
    private final String period;
}
