package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client_charge")
public class BareksaClientChargeEntity implements Persistable<String> {

    @Id
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "name")
    private String name;

    @Column(name = "effective")
    private String effective;

    @Column(name = "less_fund_rate")
    private double lessFundRate;

    @Transient
    public boolean isNew;

    @Override
    public String getId() {
        return clientId;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
