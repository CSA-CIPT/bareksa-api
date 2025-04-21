package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class BareksaClientThreeDaysKey implements Serializable {

    @Column(name = "client_id")
    private String clientId;

    @Column(name = "trans_due_date")
    private String transDueDate;

    @Column(name = "due_date")
    private String dueDate;
}
