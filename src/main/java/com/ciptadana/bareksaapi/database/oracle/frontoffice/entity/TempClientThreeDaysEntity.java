package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "TEMP_CLIENT_THREEDAYS", schema = "CORE")
public class TempClientThreeDaysEntity {

    @Id
    @Column(name = "SUBACCOUNT")
    private String subAccount;

    @Column(name = "TRANS_DATE")
    private LocalDate transDate;

    @Column(name = "TRANS_DUEDATE")
    private LocalDate transDueDate;

    @Column(name = "AMOUNT")
    private Long amount;

    @Column(name = "AMOUNTIDR")
    private Long amountIdr;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LAST_UPDATED")
    private String lastUpdated;
}
