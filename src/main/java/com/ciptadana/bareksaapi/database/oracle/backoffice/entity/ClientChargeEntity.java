package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

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
@Table(name = "CLIENT_CHARGES", schema = "DENPASAR", catalog = "")
public class ClientChargeEntity {

    @EmbeddedId
    private ClientCommissionEntityPK id;

    @Column(name = "INTEREST_POST_METHOD")
    private int interestPostMethod;

    @Column(name = "DANA_KURANG_RATE")
    private Integer danaKurangRate;

    @Column(name = "DANA_KURANG_PENALTY")
    private String danaKurangPenalty;

    @Column(name = "DANA_LEBIH_RATE")
    private Integer danaLebihRate;

    @Column(name = "DANA_LEBIH_BONUS")
    private String danaLebihBonus;
}
