package com.ciptadana.bareksaapi.database.mysql.payment.repository.projection;

public interface ViewBCAIASRMutasi {
    String getBankCode();
    String getRecDate();
    String getRecTime();
    String getAccountId();
    String getClientName();
    String getTimeStamp();
    String getBeginBalance();
    String getMutasiType();
    String getCurrentValue();
    String getClosingBalance();
    String getRemark();
}
