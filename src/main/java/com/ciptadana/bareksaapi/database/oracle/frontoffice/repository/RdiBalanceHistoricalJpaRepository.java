package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.RdiBalanceHistoricalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RdiBalanceHistoricalJpaRepository extends JpaRepository<RdiBalanceHistoricalEntity, String> {
    @Query(value = "SELECT r FROM RdiBalanceHistoricalEntity r " +
            "WHERE r.clientCode LIKE '14519%'")
    List<RdiBalanceHistoricalEntity> getBareksa();
}
