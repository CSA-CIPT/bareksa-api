package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.BareksaClientRDNEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BareksaClientRDNJpaRepository extends JpaRepository<BareksaClientRDNEntity, String> {
}
