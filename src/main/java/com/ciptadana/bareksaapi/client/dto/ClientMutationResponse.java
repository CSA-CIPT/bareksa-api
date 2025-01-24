package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientMutation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientMutationResponse {
    private final long total;
    private final List<ClientMutation> clientMutations;
}
