package com.ciptadana.bareksaapi.database.mysql.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "dummy")
public class PaymentViewEntity {
    @Id
    private String id;
}
