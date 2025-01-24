package com.ciptadana.bareksaapi.database.postgres.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @Size(max = 20)
    @Column(name = "code", nullable = false, length = 20)
    private String code;

    @Size(max = 10)
    @NotNull
    @Column(name = "mitra_code", nullable = false, length = 10)
    private String mitraCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "mitra_name", nullable = false, length = 50)
    private String mitraName;

    @Size(max = 100)
    @NotNull
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Size(max = 1)
    @NotNull
    @Column(name = "foreigner", nullable = false, length = 1)
    private String foreigner;

    @Size(max = 15)
    @NotNull
    @Column(name = "sid", nullable = false, length = 15)
    private String sid;

    @Size(max = 15)
    @NotNull
    @Column(name = "ksei_sub_rek", nullable = false, length = 15)
    private String kseiSubRek;

    @Size(max = 50)
    @NotNull
    @Column(name = "contact_home", nullable = false, length = 50)
    private String contactHome;

    @Size(max = 50)
    @NotNull
    @Column(name = "contact_office", nullable = false, length = 50)
    private String contactOffice;

    @Size(max = 50)
    @NotNull
    @Column(name = "contact_fax", nullable = false, length = 50)
    private String contactFax;

    @Size(max = 50)
    @NotNull
    @Column(name = "contact_other", nullable = false, length = 50)
    private String contactOther;

    @Size(max = 255)
    @NotNull
    @Column(name = "contact_email", nullable = false)
    private String contactEmail;

    @Size(max = 50)
    @NotNull
    @Column(name = "bank_account_name", nullable = false, length = 50)
    private String bankAccountName;

    @Size(max = 50)
    @NotNull
    @Column(name = "bank_account_no", nullable = false, length = 50)
    private String bankAccountNo;

    @Size(max = 50)
    @NotNull
    @Column(name = "bank_name", nullable = false, length = 50)
    private String bankName;

    @Size(max = 50)
    @NotNull
    @Column(name = "bank_branch", nullable = false, length = 50)
    private String bankBranch;

    @Size(max = 100)
    @NotNull
    @Column(name = "bank_acc_no_investor", nullable = false, length = 100)
    private String bankAccNoInvestor;

    @Size(max = 2)
    @NotNull
    @Column(name = "client_rating", nullable = false, length = 2)
    private String clientRating;

    @NotNull
    @Column(name = "trading_limit", nullable = false, precision = 17, scale = 2)
    private BigDecimal tradingLimit;

    @Size(max = 8)
    @NotNull
    @Column(name = "member_since", nullable = false, length = 8)
    private String memberSince;

    @Size(max = 17)
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