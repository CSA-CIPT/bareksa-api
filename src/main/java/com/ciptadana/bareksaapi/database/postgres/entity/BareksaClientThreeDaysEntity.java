package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "client_three_days_mppe")
public class BareksaClientThreeDaysEntity implements Persistable<BareksaClientThreeDaysKey> {

    @EmbeddedId
    private BareksaClientThreeDaysKey id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "amount_idr")
    private BigDecimal amountIdr;

    @Column(name = "name")
    private String name;

    @Column(name = "due_date")
    private String dueDate;



    @Transient
    private boolean isNew;
    @Override
    public BareksaClientThreeDaysKey getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
