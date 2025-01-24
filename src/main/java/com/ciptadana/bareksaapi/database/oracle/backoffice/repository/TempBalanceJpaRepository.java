package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.TempBalanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TempBalanceJpaRepository extends JpaRepository<TempBalanceEntity, String> {
    @Procedure(name = "PortfolioClientPL_Summary")
    String callPortfolioClientPLSummary(
            @Param("start") String start,
            @Param("end") String end,
            @Param("empty") String empty,
            @Param("clientCode") String clientCode);


    @Query(value = "SELECT * FROM DENPASAR.TEMP_BALANCE", nativeQuery = true)
    List<TempBalanceEntity> getAllTempBalance();
}
