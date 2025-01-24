package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqComplainEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqComplainKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReqComplainJpaRepository extends JpaRepository<ReqComplainEntity, ReqComplainKey> {



}
