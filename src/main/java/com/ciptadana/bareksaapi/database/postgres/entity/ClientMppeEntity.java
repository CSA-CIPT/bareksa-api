package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import lombok.*;
import org.springframework.data.domain.Persistable;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "client_mppe", schema = "public")
public class ClientMppeEntity implements Persistable<String> {
    @Id

    @Column(name = "code", nullable = false, length = 20)
    private String code;


    @NotNull
    @Column(name = "mitra_code", nullable = false, length = 10)
    private String mitraCode;


    @NotNull
    @Column(name = "mitra_name", nullable = false, length = 50)
    private String mitraName;


    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;


    @NotNull
    @Column(name = "foreigner", nullable = false, length = 1)
    private String foreigner;


    @NotNull
    @Column(name = "sid", nullable = false, length = 15)
    private String sid;


    @NotNull
    @Column(name = "ksei_sub_rek", nullable = false, length = 15)
    private String kseiSubRek;


    @NotNull
    @Column(name = "contact_home", nullable = false, length = 50)
    private String contactHome;


    @NotNull
    @Column(name = "contact_office", nullable = false, length = 50)
    private String contactOffice;


    @NotNull
    @Column(name = "contact_fax", nullable = false, length = 50)
    private String contactFax;


    @NotNull
    @Column(name = "contact_other", nullable = false, length = 50)
    private String contactOther;


    @NotNull
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;


    @NotNull
    @Column(name = "bank_account_name", nullable = false, length = 50)
    private String bankAccountName;


    @NotNull
    @Column(name = "bank_account_no", nullable = false, length = 50)
    private String bankAccountNo;


    @NotNull
    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;


    @NotNull
    @Column(name = "bank_branch", nullable = false, length = 50)
    private String bankBranch;


    @NotNull
    @Column(name = "bank_acc_no_investor", nullable = false, length = 100)
    private String bankAccNoInvestor;


    @NotNull
    @Column(name = "client_rating", nullable = false, length = 2)
    private String clientRating;

    @NotNull
    @Column(name = "trading_limit", nullable = false, precision = 17, scale = 2)
    private BigDecimal tradingLimit;


    @NotNull
    @Column(name = "member_since", nullable = false, length = 8)
    private String memberSince;


    @NotNull
    @Column(name = "last_modified", nullable = false, length = 17)
    private String lastModified;

    @Transient
    private boolean isNew;

    @Override
    public String getId() {
        return code;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }
}