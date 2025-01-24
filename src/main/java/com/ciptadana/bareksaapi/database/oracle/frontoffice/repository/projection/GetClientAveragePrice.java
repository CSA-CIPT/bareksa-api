package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

public interface GetClientAveragePrice {
    String getClientCode();
    String getNShare();
    double getAveragePrice();
    String getLastUpdated();
}
