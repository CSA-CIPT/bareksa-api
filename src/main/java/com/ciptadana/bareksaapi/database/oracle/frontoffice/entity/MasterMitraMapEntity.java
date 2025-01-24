package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "MASTER_MITRA_MAP", schema = "BAREKSA")
public class MasterMitraMapEntity {

    @EmbeddedId
    private MasterMitraMapKey id;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @Column(name = "UPDATED_ON")
    private String updatedOn;
}
