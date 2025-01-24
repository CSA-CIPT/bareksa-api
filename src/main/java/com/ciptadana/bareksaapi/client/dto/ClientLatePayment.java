package com.ciptadana.bareksaapi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ClientLatePayment {

    @JsonProperty("trans_seq")
    private String transSeq;
    private String clientCode;

    @JsonProperty("trans_no")
    private String transNo;

    @JsonProperty("trans_date")
    private String transDate;

    @JsonProperty("trans_duedate")
    private String transDueDate;
    private BigDecimal amount;
    private String description;
}
