package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReqClientUpdatedDataKey implements Serializable {

    @Column(name = "CODE")
    private String code;

    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;

}
