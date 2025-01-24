package com.ciptadana.bareksaapi.client.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientMPPE {

    @JsonProperty("mitra_code")
    private final String mitraCode;

    @JsonProperty("mitra_name")
    private final String mitraName;
    private final String code;
    private final String name;
    private final String foreigner;
    private final String sid;

    @JsonProperty("ksei_sub_rek")
    private final String kseiSubRek;

    @JsonProperty("contact_home")
    private final String contactHome;

    @JsonProperty("contact_fax")
    private final String contactFax;

    @JsonProperty("contact_office")
    private final String contactOffice;

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

    @JsonProperty("bank_acc_no_investor")
    private final String bankAccNoInvestor;

    @JsonProperty("client_rating")
    private final String clientRating;

    @JsonProperty("trading_limit")
    private final String tradingLimit;

    @JsonProperty("member_since")
    private final String memberSince;

    @JsonProperty("last_modified")
    private final String lastModified;
}
