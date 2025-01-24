package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.TrOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrOrderJpaRepositoy extends JpaRepository<TrOrderEntity, String> {
}
