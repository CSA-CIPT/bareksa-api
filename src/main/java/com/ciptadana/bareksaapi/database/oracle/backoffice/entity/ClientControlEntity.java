package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENT_CONTROL", schema = "DENPASAR")
public class ClientControlEntity {

    @EmbeddedId
    private ClientControlKey id;

    @Column(name = "CLIENT_RATING")
    private String clientRating;

    @Column(name = "SUSPENDED")
    private int suspended;

    @Column(name = "TRADING_LIMIT")
    private int tradingLimit;

    @Column(name = "MARGIN_RATIO")
    private int marginRatio;

    @Column(name = "MARGIN_CALL")
    private int marginCall;

    @Column(name = "MARGIN_FORCE_SELL")
    private int marginForceCell;
}
