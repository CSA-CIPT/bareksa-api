package com.ciptadana.bareksaapi.database.mysql.payment.repository.projection;

import java.util.Date;

public interface GetOutstandingWithdrawalList {
    int getWithdrawalId();
    String getClientCode();
    String getClientName();
    String getAmount();
    Date getPaymentDate();
}
