package com.ciptadana.bareksaapi.client.business;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientMutationBlueChip {
    private final String bankCode;
    private final String recDate;
    private final String recTime;
    private final String accountId;
    private final String clientName;
    private final String timestamp;
    private final String beginBalance;
    private final String mutationType;
    private final String currentValue;
    private final String closingBalance;
    private final String remark;

}
