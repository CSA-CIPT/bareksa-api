package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RDNMPPE {
    private final String threeDays;
    private String withdraw;
    private final String recDate;
    private final String recTime;
    private final String balance;
    private final String clientCode;
    private final String norek;

    @JsonProperty("bank_name_investor")
    private final String bankNameInvestor;

    @JsonProperty("rwn_to_remove")
    private String rnum;
}
