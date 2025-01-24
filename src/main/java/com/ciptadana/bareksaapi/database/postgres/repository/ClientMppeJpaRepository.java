package com.ciptadana.bareksaapi.database.postgres.repository;

import com.ciptadana.bareksaapi.database.postgres.entity.ClientMppeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientMppeJpaRepository extends JpaRepository<ClientMppeEntity, String> {

    @Query(value = "SELECT MAX(CAST(c.code AS BIGINT)) FROM client_mppe c", nativeQuery = true)
    Long getMaxCode();
}
