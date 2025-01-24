package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.ClientTransaction;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientTransactionResponse {
    private final long total;
    private final List<ClientTransaction> transactions;
}
