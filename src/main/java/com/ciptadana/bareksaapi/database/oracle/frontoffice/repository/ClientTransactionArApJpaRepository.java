package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TransactionArApEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TransactionArApKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetTransactionArAp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientTransactionArApJpaRepository extends JpaRepository <TransactionArApEntity, TransactionArApKey> {
    @Query(value =
            "SELECT TO_CHAR(TRANS_DATE, 'yyyy-mm-dd') AS TRANSDATE, NCLIENT, OUTSTANDING " +
            "FROM BAREKSA.TRANSACTION_AR_AP X " +
            "WHERE TO_CHAR(TRANS_DATE, 'yyyy-mm-dd') = :date " +
            "ORDER BY TRANSDATE, NCLIENT",
    nativeQuery = true)
    List<GetTransactionArAp> getClientTransactionArAPByDate(@Param("date") String date);

    @Query(value =
            "SELECT TO_CHAR(TRANS_DATE, 'yyyy-mm-dd') AS TRANSDATE, NCLIENT, OUTSTANDING " +
            "FROM BAREKSA.TRANSACTION_AR_AP X " +
            "ORDER BY TRANSDATE, NCLIENT",
            nativeQuery = true)
    List<GetTransactionArAp> getClientTransactionArAP();
}
