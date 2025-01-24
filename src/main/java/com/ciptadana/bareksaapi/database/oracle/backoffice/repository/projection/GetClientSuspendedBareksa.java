package com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection;

import java.time.LocalDate;

public interface GetClientSuspendedBareksa {
    String getClientId();
    String getName();
    LocalDate getEffective();
    int getSuspended();
}
