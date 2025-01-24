package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientThreeDays {

    @JsonProperty("trans_duedate")
    private final String transDueDate;
    private final String subAccount;
    private final String amount;
    private final String amountIDR;
    private final String name;
    private final String dueDate;

    @JsonProperty("rwn_to_remove")
    private final String rnum;
}
