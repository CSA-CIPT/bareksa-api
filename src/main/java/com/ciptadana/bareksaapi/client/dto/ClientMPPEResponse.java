package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientMPPE;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientMPPEResponse {

    private final long total;
    private final List<ClientMPPE> clients;
}
