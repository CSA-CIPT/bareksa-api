package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "REQ_CLIENT_CLOSING_ACC", schema = "BAREKSA")
public class ReqClientClosingAccEntity {

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "SID")
    private String sid;

    @Column(name = "SRE")
    private String sre;

    @Column(name = "RDN")
    private String rdn;

    @Column(name = "MODIFIED_DATE")
    private String modifiedDate;

}
