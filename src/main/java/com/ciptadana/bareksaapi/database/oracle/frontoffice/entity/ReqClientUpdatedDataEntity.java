package com.ciptadana.bareksaapi.database.oracle.frontoffice.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "REQ_CLIENT_UPDATED_DATA", schema = "BAREKSA")
public class ReqClientUpdatedDataEntity {

    @EmbeddedId
    private ReqClientUpdatedDataKey id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "CITY")
    private String city;

    @Column(name = "HANDPHONE")
    private String handPhone;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "RELIGION")
    private String religion;

    @Column(name = "INCOME")
    private String income;

    @Column(name = "SOURCE_INCOME")
    private String sourceIncome;

    @Column(name = "ACCOUNT_NO")
    private String accountNo;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "OCCUPATION")
    private String occupation;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "REJECTREASON")
    private String rejectReason;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ID_CARD_NO")
    private String idCardNo;

    @Column(name = "ID_CARD")
    private String idCard;

}
