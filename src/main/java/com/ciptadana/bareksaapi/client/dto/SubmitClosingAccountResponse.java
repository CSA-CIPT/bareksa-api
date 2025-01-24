package com.ciptadana.bareksaapi.client.dto;

import lombok.Data;

@Data
public class SubmitClosingAccountResponse {

    private final String clientCode;
    private final String sid;
    private final String sre;
    private final String rdn;

}
