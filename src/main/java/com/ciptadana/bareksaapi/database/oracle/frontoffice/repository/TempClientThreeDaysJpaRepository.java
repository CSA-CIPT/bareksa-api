package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TempClientThreeDaysEntity;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientThreeDaysDistinct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface TempClientThreeDaysJpaRepository extends JpaRepository<TempClientThreeDaysEntity, String> {

    @Query(value = "SELECT " +
            "TRANS_DUEDATE AS TRANSDUEDATE, " +
            "TRANS_DATE AS TRANSDATE, " +
            "SUBACCOUNT, " +
            "AMOUNT, " +
            "AMOUNTIDR, " +
            "NAME " +
            "FROM TEMP_CLIENT_THREEDAYS " +
            "ORDER BY TRANSDUEDATE ", nativeQuery = true)
    Page<GetClientThreeDaysDistinct> getClientThreeDays(Pageable pageable);

    @Query(value = "SELECT " +
            "TRANS_DUEDATE AS TRANSDUEDATE, " +
            "SUBACCOUNT, " +
            "SUM(AMOUNT) AS AMOUNT, " +
            "SUM(AMOUNTIDR) AS AMOUNTIDR, " +
            "NAME " +
            "FROM TEMP_CLIENT_THREEDAYS_MPPE " +
            "GROUP BY TRANS_DUEDATE, SUBACCOUNT, NAME " +
            "ORDER BY TRANS_DUEDATE ", nativeQuery = true)
    List<GetClientThreeDaysDistinct> getClientThreeDays();


}
