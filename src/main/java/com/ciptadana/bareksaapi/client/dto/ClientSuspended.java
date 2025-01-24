package com.ciptadana.bareksaapi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientSuspended {

    @JsonProperty("client_id")
    private final String clientId;
    private final String name;
    private final String effective;
    private final String suspended;
}
