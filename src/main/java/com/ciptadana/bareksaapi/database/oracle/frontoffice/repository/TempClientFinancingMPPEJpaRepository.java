package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TempClientFinancingMPPEEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TempClientFinancingMPPEKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TempClientFinancingMPPEJpaRepository extends JpaRepository<TempClientFinancingMPPEEntity, TempClientFinancingMPPEKey> {

    @Query(value = "SELECT DISTINCT TRANS_SEQ," +
            "TRANS_NO " +
            ",TRANS_PERIOD " +
            ",TRANS_DATE " +
            ",TRANS_DUE " +
            ",CLIENTCODE " +
            ",SIDE " +
            ",NVL(QUANTITY,0)QUANTITY " +
            ",NVL(PRICE,0) PRICE " +
            ",AMOUNT " +
            ",DESCRIPTION " +
            ",LAST_UPDATED " +
            "FROM TEMP_CLIENT_FINANCING_MPPE CF " +
            "WHERE TRANS_PERIOD = :period " +
            "AND LOWER(DESCRIPTION) NOT LIKE '%deviden%' "
            ,nativeQuery = true)
    List<TempClientFinancingMPPEEntity> getByPeriod(@Param("period")int period);


    @Query(value = "SELECT DISTINCT " +
            "    TRANS_SEQ, " +
            "    TRANS_NO, " +
            "    TRANS_PERIOD, " +
            "    TRANS_DATE, " +
            "    TRANS_DUE, " +
            "    CLIENTCODE, " +
            "    SIDE, " +
            "    NVL(QUANTITY, 0) AS QUANTITY, " +
            "    NVL(PRICE, 0) AS PRICE, " +
            "    AMOUNT, " +
            "    DESCRIPTION, " +
            "    LAST_UPDATED " +
            "FROM TEMP_CLIENT_FINANCING_MPPE CF " +
            "WHERE TRANS_PERIOD = ( " +
            "    SELECT MAX(TRANS_PERIOD) " +
            "    FROM TEMP_CLIENT_FINANCING_MPPE " +
            ") " +
            "  AND LOWER(DESCRIPTION) NOT LIKE '%deviden%' ", nativeQuery = true)
    List<TempClientFinancingMPPEEntity> getCurrentPeriod();
}
