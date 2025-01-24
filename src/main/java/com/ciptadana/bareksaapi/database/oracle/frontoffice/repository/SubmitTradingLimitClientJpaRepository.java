package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqTradingLimitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmitTradingLimitClientJpaRepository extends JpaRepository<ReqTradingLimitEntity, String> {

}
