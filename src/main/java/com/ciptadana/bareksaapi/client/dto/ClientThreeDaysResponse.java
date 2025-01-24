package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientThreeDays;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientThreeDaysResponse {
    private long total;
    private List<ClientThreeDays> clients;
}
