package com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection;

import java.time.LocalDate;

public interface GetClientCharge {
    String getClientId();
    String getName();
    LocalDate getEffective();
    String getLessFundRate();
}
