package com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection;

import java.math.BigDecimal;
import java.util.Date;

public interface GetClientLatePayment {
    String getId();

    String getSubAccount();

    String getTransNo();

    String getTransDate();

    String getTransDueDate();

    BigDecimal getAmount();

    String getDescription();

}
