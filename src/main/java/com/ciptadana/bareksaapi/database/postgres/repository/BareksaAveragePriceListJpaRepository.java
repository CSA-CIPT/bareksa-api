package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.BareksaAveragePriceListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaAveragePriceListJpaRepository extends JpaRepository<BareksaAveragePriceListEntity, String> {
}
