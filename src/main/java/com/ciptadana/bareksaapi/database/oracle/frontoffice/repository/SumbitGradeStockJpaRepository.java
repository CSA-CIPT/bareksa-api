package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqGradeStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SumbitGradeStockJpaRepository extends JpaRepository<ReqGradeStockEntity, String> {

}
