package com.ciptadana.bareksaapi.database.mysql.payment.repository;

import com.ciptadana.bareksaapi.database.mysql.payment.entity.PaymentViewEntity;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.projection.ViewBCAIASRMutasi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentViewJpaRepository extends JpaRepository<PaymentViewEntity, String> {

    @Query(value = "SELECT BANK_CODE as BANKCODE, " +
            "RECDATE as RECDATE, " +
            "RECTIME as RECTIME, " +
            "ACCOUNT_ID as ACCOUNTID, " +
            "CLIENT_NAME as CLIENTNAME, " +
            "TIME_STAMP as TIMESTAMP, " +
            "BEGIN_BALANCE as BEGINBALANCE, " +
            "MUTASI_TYPE as MUTASITYPE, " +
            "CURRENT_VALUE as CURRENTVALUE, " +
            "CLOSING_BALANCE as CLOSINGBALANCE, " +
            "REMARK as REMARK " +
            "FROM gwbank.view_bcaiasr_mutasi " +
            "WHERE RECDATE >= REPLACE(DATE_ADD(CURDATE(), INTERVAL -10 DAY),'-','') AND " +
            "ACCOUNT_ID IN :ids", nativeQuery = true)
    List<ViewBCAIASRMutasi> getBCAIASRMutasi(@Param("ids") List<String> ids);

    @Query(value = "SELECT BANK_CODE as BANKCODE, " +
            "RECDATE as RECDATE, " +
            "RECTIME as RECTIME, " +
            "ACCOUNT_ID as ACCOUNTID, " +
            "CLIENT_NAME as CLIENTNAME, " +
            "TIME_STAMP as TIMESTAMP, " +
            "BEGIN_BALANCE as BEGINBALANCE, " +
            "MUTASI_TYPE as MUTASITYPE, " +
            "CURRENT_VALUE as CURRENTVALUE, " +
            "CLOSING_BALANCE as CLOSINGBALANCE, " +
            "REMARK as REMARK " +
            "FROM gwbank.view_bcaiasr_mutasi " +
            "WHERE RECDATE = :date AND " +
            "ACCOUNT_ID IN :ids", nativeQuery = true)
    List<ViewBCAIASRMutasi> getBCAIASRMutasiByDate(@Param("ids") List<String> ids, @Param("date") String date);

    @Query(value = "SELECT BANK_CODE as BANKCODE, " +
            "RECDATE as RECDATE, " +
            "RECTIME as RECTIME, " +
            "ACCOUNT_ID as ACCOUNTID, " +
            "CLIENT_NAME as CLIENTNAME, " +
            "TIME_STAMP as TIMESTAMP, " +
            "BEGIN_BALANCE as BEGINBALANCE, " +
            "MUTASI_TYPE as MUTASITYPE, " +
            "CURRENT_VALUE as CURRENTVALUE, " +
            "CLOSING_BALANCE as CLOSINGBALANCE, " +
            "REMARK as REMARK " +
            "FROM gwbank.view_bcaiasr_mutasi " +
            "WHERE RECDATE BETWEEN :startDate AND :endDate AND " +
            "ACCOUNT_ID IN :ids", nativeQuery = true)
    List<ViewBCAIASRMutasi> getBCAIASRMutasiByRangeDate(@Param("ids") List<String> ids, @Param("startDate") String startDate, @Param("endDate") String endDate);
}
