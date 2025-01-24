package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientThreeDaysEntity;
import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientThreeDaysKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaClientThreeDaysJpaRepository extends JpaRepository<BareksaClientThreeDaysEntity, BareksaClientThreeDaysKey> {
}
