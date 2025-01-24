package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.LedgerEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientArApByCode;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientLatePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LedgerJpaRepository extends JpaRepository<LedgerEntity, Long> {


    @Query(value = "SELECT * FROM ( " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_PERIOD = :period " +
            "                  AND LEDGER.TRANS_CURRENT = 0 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE = 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_PERIOD = :period " +
            "                  AND LEDGER.TRANS_CURRENT = 0 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.SUBACCOUNT LIKE LEDGER.SUBACCOUNT || '%' " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE > 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.ACCOUNT NOT IN (:accountType) " +
            "                  AND ACCOUNT.ACCOUNT_TYPE <> 109 " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE = 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.SUBACCOUNT LIKE LEDGER.SUBACCOUNT || '%' " +
            "                  AND LEDGER.ACCOUNT NOT IN (:accountType) " +
            "                  AND ACCOUNT.ACCOUNT_TYPE <> 109 " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE > 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_MODULE) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, SUBACCOUNT, TO_CHAR('DAILY SUMMARY TRANSACTIONS') DESCRIPTION, SUM(AMOUNTIDR) AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.ACCOUNT IN (:accountType) " +
            "                  AND LEDGER.TRANS_MODULE IN (20, 21, 22) " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE = 0 " +
            "                  GROUP BY TRANS_MODULE, TRANS_DATE, NSHARE, ACCOUNT, SUBACCOUNT, LEDGER.BRANCH, LEDGER.CURRENCY, ID " +
            "                  HAVING SUM(AMOUNT) <> 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.ACCOUNT IN (:accountType) " +
            "                  AND LEDGER.TRANS_MODULE NOT IN (20, 21, 22) " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE = 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_MODULE) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, SUBACCOUNT, TO_CHAR('DAILY SUMMARY TRANSACTIONS') DESCRIPTION, SUM(AMOUNTIDR) AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.SUBACCOUNT LIKE LEDGER.SUBACCOUNT || '%' " +
            "                  AND LEDGER.ACCOUNT IN (:accountType) " +
            "                  AND LEDGER.TRANS_MODULE IN (20, 21, 22) " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE > 0 " +
            "                  GROUP BY TRANS_MODULE, TRANS_DATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT_TYPE, LEDGER.SUBACCOUNT, LEDGER.BRANCH, LEDGER.CURRENCY, ID " +
            "                  HAVING SUM(AMOUNT) <> 0 " +
            "        UNION ALL " +
            "        SELECT ID, TO_CHAR(TRANS_NO) TRANS_NO, TO_CHAR(TRANS_DATE,'YYYYMMDD') TRANS_DATE, TO_CHAR(TRANS_DUEDATE,'YYYYMMDD') TRANS_DUEDATE, NSHARE, ACCOUNT, LEDGER.SUBACCOUNT, TO_CHAR(DESCRIPTION) DESCRIPTION, AMOUNTIDR " +
            "                  FROM DENPASAR.LEDGER, DENPASAR.ACCOUNT " +
            "                  WHERE LEDGER.ACCOUNT = ACCOUNT.CODE " +
            "                  AND LEDGER.TRANS_DATE BETWEEN TO_DATE(:startDate, 'yyyy-mm-dd') AND TO_DATE(:endDate, 'yyyy-mm-dd') " +
            "                  AND LEDGER.TRANS_CURRENT = 1 " +
            "                  AND LEDGER.ACCOUNT LIKE DECODE(:account, NULL, LEDGER.ACCOUNT, :account || '%') " +
            "                  AND LEDGER.ACCOUNT IN (:accountType) " +
            "                  AND LEDGER.TRANS_MODULE NOT IN (20, 21, 22) " +
            "                  AND ACCOUNT.SUBACCOUNT_TYPE > 0 " +
            "        ) T WHERE SUBACCOUNT = :clientCode " +
            "        ORDER BY SUBACCOUNT, TRANS_DATE, ID ASC",nativeQuery = true)
    List<GetClientArApByCode> getClientArAp(@Param("clientCode") String clientCode, @Param("account") String account, @Param("accountType") String accountType, @Param("period") String period, @Param("startDate") String startDate, @Param("endDate") String endDate);


    @Query(value = "SELECT ID , " +
            "SUBACCOUNT , " +
            "TRANS_NO AS TRANSNO, " +
            "TO_CHAR(TRANS_DATE, 'DD-Mon-YY') AS TRANSDATE, " +
            "TO_CHAR(TRANS_DUEDATE, 'DD-Mon-YY') AS TRANSDUEDATE, " +
            "AMOUNT, " +
            "DESCRIPTION " +
            "FROM LEDGER " +
            "WHERE SUBSTR(SUBACCOUNT,3,3) = '519' " +
            "AND DESCRIPTION = 'DENDA TELAT BAYAR'" +
            "AND TRANS_CURRENT = 0 " +
            "AND TRANS_PERIOD = :period " +
            "ORDER BY ID",
            nativeQuery = true)
    List<GetClientLatePayment> getClientLatePayment(@Param("period") String period);
}
