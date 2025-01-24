package com.ciptadana.bareksaapi.client.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ClientFinancing {

    @JsonProperty("trans_seq")
    private final String transSeq;
    private final String clientCode;

    @JsonProperty("trans_no")
    private final String transNo;

    @JsonProperty("trans_period")
    private final String transPeriod;

    @JsonProperty("trans_date")
    private final String transDate;

    @JsonProperty("trans_due")
    private final String transDue;
    private final String side;
    private final String quantity;
    private final String price;
    private final String amount;
    private final String description;

    @JsonProperty("last_updated")
    private final String lastUpdated;

}
