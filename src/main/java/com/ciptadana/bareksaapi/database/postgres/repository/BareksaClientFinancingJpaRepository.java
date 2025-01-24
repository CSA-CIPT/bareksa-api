package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientFinancingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaClientFinancingJpaRepository extends JpaRepository<BareksaClientFinancingEntity, Long> {
}
