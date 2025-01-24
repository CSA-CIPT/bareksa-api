package com.ciptadana.bareksaapi.database.postgres.repository;


import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaClientChargeJpaRepository extends JpaRepository<BareksaClientChargeEntity, String> {
}
