package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TempBalanceEntityKey implements Serializable {

    @Column(name = "SUBACCOUNT")
    private String subaccount;

    @Column(name = "DEAL_DATE")
    private LocalDate dealDate;
}
