package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.BareksaRDNListHistoricalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaRDNListHistoricalJpaRepository extends JpaRepository<BareksaRDNListHistoricalEntity, String> {
}
