package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqComplainKey implements Serializable {

    @Column(name = "CODE")
    private String code;

    @Column(name = "CREATED_DATE")
    private String createdDate;

}
