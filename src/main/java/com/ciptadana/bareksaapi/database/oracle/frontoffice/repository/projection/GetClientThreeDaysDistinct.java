package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface GetClientThreeDaysDistinct {

    LocalDate getTransDueDate();
    LocalDate getTransDate();
    String getSubAccount();
    BigDecimal getAmount();
    BigDecimal getAmountIdr();
    String getName();
}
