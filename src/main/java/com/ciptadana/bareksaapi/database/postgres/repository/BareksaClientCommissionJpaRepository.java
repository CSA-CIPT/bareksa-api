package com.ciptadana.bareksaapi.database.postgres.repository;


import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaClientCommissionJpaRepository extends JpaRepository<BareksaClientCommissionEntity, String> {
}
