package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.Column;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClientControlKey implements Serializable {
    @Column(name = "EFFECTIVE")
    private String effective;

    @Column(name = "CLIENT_ID")
    private String clientId;
}
