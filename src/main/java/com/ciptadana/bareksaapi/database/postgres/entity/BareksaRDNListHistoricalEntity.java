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
@ToString
@Table(name = "rdn_list_historical_mppe")
public class BareksaRDNListHistoricalEntity implements Persistable<String> {

    @Id
    @Column(name = "client_id")
    private String clientId;

    @Column(name = "rec_date")
    private long recDate;

    @Column(name = "rec_time")
    private long recTime;

    @Column(name = "no_rek")
    private String noRek;

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "contra_bal")
    private BigDecimal contraBal;

    @Column(name = "contra_date")
    private long contraDate;

    @Override
    public String getId() {
        return clientId;
    }

    @Transient
    private boolean isNew;

    @Override
    public boolean isNew() {
        return isNew;
    }
}
