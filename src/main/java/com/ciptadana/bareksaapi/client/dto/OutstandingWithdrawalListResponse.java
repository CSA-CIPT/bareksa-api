package com.ciptadana.bareksaapi.client.dto;

import com.ciptadana.bareksaapi.client.business.OutstandingWithdrawal;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OutstandingWithdrawalListResponse {
    private long total;
    private List<OutstandingWithdrawal> outstandingWithdrawalLists;
}
