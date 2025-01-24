package com.ciptadana.bareksaapi.master.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterMitraPPEResponse {

    @JsonProperty("mitra_code")
    private final String mitraCode;

    @JsonProperty("mitra_name")
    private final String mitraName;

    @JsonProperty("updated_by")
    private final String updatedBy;

    @JsonProperty("updated_on")
    private final String updatedOn;
}
