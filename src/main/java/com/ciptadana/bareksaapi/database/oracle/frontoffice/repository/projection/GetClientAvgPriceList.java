package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

public interface GetClientAvgPriceList {
    String getClientCode();
    String getNShare();
    int getAvgPrice();
    String getLastUpdated();
}
