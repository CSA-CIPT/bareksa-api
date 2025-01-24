package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

public interface GetViewMasterStock {
    int getStockId();
    String getStockCode();
    String getStockName();
    int getSubsectorId();
    String getStatus();
    String getBoard();
    String getColorhex();
    String getSecurityType();
    String getPreopeningflag();
    String getMarkingpercent();

    String getIsMargin();

}
