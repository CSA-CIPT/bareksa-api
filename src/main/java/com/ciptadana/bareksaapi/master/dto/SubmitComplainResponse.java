package com.ciptadana.bareksaapi.master.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubmitComplainResponse {

    private final String clientCode;
    private final String name;
    private final String email;
    private final String complain;
    private final String status;
    private final String category;

}
