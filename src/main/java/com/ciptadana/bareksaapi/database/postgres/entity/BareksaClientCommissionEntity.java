package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "list_client_commission")
public class BareksaClientCommissionEntity implements Persistable<String> {

    @Id
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "sid")
    private String sid;

    @Column(name = "effective")
    private String effective;

    @Column(name = "commission_buy")
    private double commissionBuy;

    @Column(name = "commission_sell")
    private double commissionSell;

    @Column(name = "minimum_commission")
    private double minimumCommission;


    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return clientId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
