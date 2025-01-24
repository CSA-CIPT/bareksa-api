package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.domain.Persistable;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "prev_bal_mppe")
public class BareksaClientPortfolioPrevBalanceEntity implements Persistable<BareksaClientPortfolioPrevBalanceKey> {

    @EmbeddedId
    private BareksaClientPortfolioPrevBalanceKey id;

    @Column(name = "prevbal")
    private BigInteger prevbal;

    @Transient
    private boolean isNew;

    @Override
    public BareksaClientPortfolioPrevBalanceKey getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}
