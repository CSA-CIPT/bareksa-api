package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientMutation {

    @JsonProperty("bank_code")
    private final String bankCode;
    private final String recDate;
    private final String recTime;

    @JsonProperty("account_id")
    private final String accountId;

    @JsonProperty("client_name")
    private final String clientName;

    @JsonProperty("time_stamp")
    private final String timestamp;

    @JsonProperty("begin_balance")
    private final String beginBalance;

    @JsonProperty("mutasi_type")
    private final String mutasiType;

    @JsonProperty("current_value")
    private final String currentValue;

    @JsonProperty("closing_balance")
    private final String closingBalance;
    private final String remark;
}
