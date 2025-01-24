package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientTransactionRepository extends JpaRepository<MasterMitraMapEntity, MasterMitraMapKey> {

    @Query(value = "SELECT DISTINCT R.NDEAL AS NDEAL, R.QUANTITY, R.PRICE, CL_CODE AS CLIENTCODE, NSHARE AS STOCKCODE, TO_CHAR(DEAL_DATE, 'YYYYMMDD') AS DEALDATE, TO_CHAR(CL_FINANCEDUE, 'YYYYMMDD') AS SETTLEDATE, CL_TOTAL AS AMOUNTNET " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN REGULAR@BOS R ON C.CODE = R.CL_CODE " +
            "WHERE TO_CHAR(DEAL_DATE, 'YYYYMMDD') = :date " +
            "AND CL_CODE = :clientCode "
            ,nativeQuery = true)
    List<GetClientTransaction> getClientTransactionByClientCodeAndDate(@Param("clientCode")String clientCode, @Param("date")String date);


}
