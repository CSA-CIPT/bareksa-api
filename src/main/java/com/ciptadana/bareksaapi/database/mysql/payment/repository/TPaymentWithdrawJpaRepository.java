package com.ciptadana.bareksaapi.database.mysql.payment.repository;

import com.ciptadana.bareksaapi.database.mysql.payment.entity.TPaymentWithdrawEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TPaymentWithdrawJpaRepository extends JpaRepository<TPaymentWithdrawEntity, String> {

    @Query("SELECT SUM(p.paymentSaldo) FROM TPaymentWithdrawEntity p WHERE p.nClient = :clientCode")
    Long getSumPaymentSaldoByClientCode(@Param("clientCode") String clientCode);
}
