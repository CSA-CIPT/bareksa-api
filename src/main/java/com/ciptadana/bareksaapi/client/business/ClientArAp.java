package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientArAp {

    private String id;

    @JsonProperty("trans_no")
    private String transNo;

    @JsonProperty("trans_date")
    private String transDate;

    @JsonProperty("trans_due_date")
    private String transDueDate;
    private String nShare;
    private String account;
    private String subAccount;
    private String description;
    private String amountIdr;
}
