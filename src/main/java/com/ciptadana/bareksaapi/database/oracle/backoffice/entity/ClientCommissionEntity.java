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
@Table(name = "CLIENT_COMMISSION", schema = "DENPASAR", catalog = "")
public class ClientCommissionEntity {

    @EmbeddedId
    private ClientCommissionEntityPK id;

    @Column(name = "NETTING_TYPE")
    private int nettingType;

    @Column(name = "MINIMUM_COMMISSION")
    private Integer minimumCommission;

    @Column(name = "R_COMMISSION")
    private Integer rCommission;

    @Column(name = "NR_COMMISSION_BUY")
    private Integer nrCommissionBuy;

    @Column(name = "NR_COMMISSION_SELL")
    private Integer nrCommissionSell;

}
