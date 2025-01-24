package com.ciptadana.bareksaapi.database.mysql.payment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tpayment_withdraw", schema = "payment", catalog = "")
public class TPaymentWithdrawEntity {

    @Id
    @Column(name = "nclient")
    private long nClient;

    @Column(name = "clientname")
    private String clientName;

    @Column(name = "bankaccountname")
    private String bankAccountName;

    @Column(name = "paymentdate")
    private LocalDate paymentDate;

    @Column(name = "bankname")
    private String bankName;

    @Column(name = "bankbranch")
    private String bankBranch;

    @Column(name = "bankaccountno")
    private String bankAccountNo;

    @Column(name = "saldoclient")
    private Double saldoClient;

    @Column(name = "adjustment")
    private Double adjustment;

    @Column(name = "paymentsaldo")
    private Double paymentSaldo;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "status")
    private String status;

    @Column(name = "modifydate")
    private Timestamp modifyDate;

    @Column(name = "clientagingdate")
    private LocalDate clientAgingDate;

    @Column(name = "modifyby")
    private String modifyBy;

    @Column(name = "bankaccnameinvestor")
    private String bankAccNameInvestor;

    @Column(name = "bankaccnoinvestor")
    private String bankAccNoInvestor;

    @Column(name = "banknameinvestor")
    private String bankNameInvestor;

    @Column(name = "email")
    private String email;

    @Column(name = "note")
    private String note;
}
