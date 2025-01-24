package com.ciptadana.bareksaapi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateClientPropertyResponse {

    private final String code;

    private final int status;

    private final String email;

    @JsonProperty("id_card_no")
    private final String idCardNo;

    @JsonProperty("modified_date")
    private final String modifiedDate;

    private final String rejectReason;

}
