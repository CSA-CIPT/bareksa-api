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
@ToString
@Table(name = "client_financing")
public class BareksaClientFinancingEntity implements Persistable<Long> {

    @Id
    @Column(name = "trans_seq")
    private long transSeq;

    @Column(name = "trans_no")
    private String transNo;

    @Column(name = "trans_period")
    private long transPeriod;

    @Column(name = "trans_date")
    private long transDate;

    @Column(name = "trans_due")
    private long transDue;

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "side")
    private String side;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "price")
    private long price;

    @Column(name = "amount")
    private long amount;

    @Column(name = "description")
    private String description;

    @Column(name = "last_update")
    private String lastUpdate;

    @Transient
    public boolean isNew;

    @Override
    public Long getId() {
        return transSeq;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
