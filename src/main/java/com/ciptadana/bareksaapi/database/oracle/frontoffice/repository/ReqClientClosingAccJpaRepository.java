package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientClosingAccEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ReqClientClosingAccJpaRepository extends JpaRepository<ReqClientClosingAccEntity, String> {



}
