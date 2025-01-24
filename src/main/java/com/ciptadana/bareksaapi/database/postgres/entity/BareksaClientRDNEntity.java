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
@Table(name = "rdn_list_mppe")
public class BareksaClientRDNEntity implements Persistable<String> {
    @Id
    @Column(name = "client_id")
    private String clientId;;

    @Column(name = "rec_date")
    private int recDate;

    @Column(name = "rec_time")
    private int recTime;

    @Column(name = "contrabal")
    private BigInteger contrabal;

    @Column(name = "balance")
    private BigInteger balance;

    @Column(name = "norek")
    private String norek;

    @Column(name = "bank_name_investor")
    private String bankNameInvestor;

    @Column(name = "sum_amount_three_days")
    private BigInteger sumAmountThreeDays;

    @Column(name = "sum_withdraw")
    private BigInteger sumWithdraw;

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
