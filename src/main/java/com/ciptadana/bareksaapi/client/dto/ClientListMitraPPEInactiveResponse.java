package com.ciptadana.bareksaapi.client.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientListMitraPPEInactiveResponse {

    private long totalRecord;
    private List<ClientListMitraPPEInactive> clientListMitraPPEInactiveList;

}
