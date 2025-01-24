package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

import java.math.BigInteger;

public interface GetRDNBareksa {
    int getRecDate();
    int getRecTime();
    BigInteger getBalance();
    BigInteger getContraBal();
    String getClientCode();
    String getNoRek();
    String getBankNameInvestor();
}
