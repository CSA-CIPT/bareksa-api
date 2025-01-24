package com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection;

public interface GetClientArApByCode {

    String getId();
    String getTrans_No();
    String getTrans_Date();
    String getTrans_DueDate();
    String getNShare();
    String getAccount();
    String getSubAccount();
    String getDescription();
    String getAmountIdr();
}
