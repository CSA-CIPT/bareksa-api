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
@Table(name = "avg_price_list_mppe")
public class BareksaAveragePriceListEntity implements Persistable<BareksaAveragePriceListKey> {

    @EmbeddedId
    private BareksaAveragePriceListKey id;

    @Column(name = "average_price")
    private BigDecimal averagePrice;

    @Column(name = "last_updated")
    private String lastUpdated;

    @Transient
    public boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
