package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientPropertyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientPropertyJpaRepository extends JpaRepository<ClientPropertyEntity, String> {

}
