package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

import java.math.BigDecimal;

public interface GetClientListMPPE {
    String getMitraCode();
    String getMitraName();
    String getCode();
    String getName();
    String getForeigner();
    String getSid();
    String getKseiSubRek();
    String getContactHome();
    String getContactFax();
    String getContactOffice();
    String getContactOther();
    String getContactEmail();
    String getBankAccountName();
    String getBankAccountNo();
    String getBankName();
    String getBankBranch();
    String getBankAccNoInvestor();
    String getClientRating();
    BigDecimal getTradingLimit();
    String getMemberSince();
    String getLastModified();

}
