package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientCommission;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientCommissionResponse {
    private long total;
    private List<ClientCommission> clientCommissions;
}
