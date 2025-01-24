package com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection;


import java.time.LocalDate;

public interface GetClientCommission {
    String getName();
    String getSid();
    String getClientId();
    double getCommissionBuy();
    double getMinimumCommission();
    double getCommissionSell();
    LocalDate getEffective();
}
