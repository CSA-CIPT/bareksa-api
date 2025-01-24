package com.ciptadana.bareksaapi.client.dto;

import lombok.Data;

@Data
public class GetUpdatedClientData {
    private final String clientCode;
    private final String address;
    private final String city;
    private final String handphone;
    private final String maritalStatus;
    private final String religion;
    private final String income;
    private final String sourceIncome;
    private final String accountNo;
    private final String accountName;
    private final String bankName;
    private final String occupation;
    private final String email;
    private final String idCardNo;
    private final String idCard;
}
