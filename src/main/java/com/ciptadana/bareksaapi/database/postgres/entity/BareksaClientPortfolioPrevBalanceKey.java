package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Embeddable
public class BareksaClientPortfolioPrevBalanceKey implements Serializable {

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "nshare")
    private String nShare;

}
