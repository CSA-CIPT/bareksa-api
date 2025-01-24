package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

public interface GetClientTransaction {
    String getNDeal();
    String getQuantity();
    String getPrice();
    String getClientCode();
    String getStockCode();
    String getDealDate();
    String getSettleDate();
    String getAmountNet();
}
