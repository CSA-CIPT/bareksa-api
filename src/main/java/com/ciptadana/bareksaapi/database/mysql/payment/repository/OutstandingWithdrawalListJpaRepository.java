package com.ciptadana.bareksaapi.database.mysql.payment.repository;

import com.ciptadana.bareksaapi.database.mysql.payment.entity.DrawSumOtDevEntity;
import com.ciptadana.bareksaapi.database.mysql.payment.repository.projection.GetOutstandingWithdrawalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OutstandingWithdrawalListJpaRepository extends JpaRepository<DrawSumOtDevEntity, Integer> {
   @Query(value = "SELECT DRAW_ID AS WITHDRAWALID, CLIENT_CODE AS CLIENTCODE, CLIENT_NAME AS CLIENTNAME, AMOUNT, WD_DATE AS PAYMENTDATE " +
           "FROM withdraw.draw_sum_ot " +
           "WHERE WD_DATE = :date AND SUBSTR(CLIENT_CODE,3,3) = '519'",
   nativeQuery = true)
   List<GetOutstandingWithdrawalList> getOutstandingWithdrawalList(@Param("date") String date);
}
