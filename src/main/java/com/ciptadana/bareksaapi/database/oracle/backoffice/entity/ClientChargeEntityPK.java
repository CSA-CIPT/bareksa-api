package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ClientChargeEntityPK implements Serializable {

    @Column(name = "CLIENT_ID")
    private String clientId;

    @Id
    @Column(name = "EFFECTIVE")
    private LocalDate effective;
}
