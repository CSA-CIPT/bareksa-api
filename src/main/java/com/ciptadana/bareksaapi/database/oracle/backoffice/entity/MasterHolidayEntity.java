package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "HOLIDAYS", schema = "DENPASAR")
public class MasterHolidayEntity {

    @Id
    @Column(name = "HOLIDAY")
    private LocalDate holiday;

    @Column(name = "MODIFIED_DATE")
    private LocalDate modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

}
