package com.ciptadana.bareksaapi.client.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientListMitraPPEInactive {

    @JsonProperty("mitra_code")
    private final String mitraCode;
    private final String code;
    private final String name;

    @JsonProperty("contact_home")
    private final String contactHome;

    @JsonProperty("contact_office")
    private final String contactOffice;

    @JsonProperty("contact_fax")
    private final String contactFax;

    @JsonProperty("contact_other")
    private final String contactOther;

    @JsonProperty("contact_email")
    private final String contactEmail;

    @JsonProperty("bank_account_name")
    private final String bankAccountName;

    @JsonProperty("bank_account_no")
    private final String bankAccountNo;

    @JsonProperty("bank_name")
    private final String bankName;

    @JsonProperty("bank_branch")
    private final String bankBranch;

}
