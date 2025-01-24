package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REQ_COMPLAIN", schema = "BAREKSA")

public class ReqComplainEntity {

    @EmbeddedId
    private ReqComplainKey id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "COMPLAIN")
    private String complain;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;

}
