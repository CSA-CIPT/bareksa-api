package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.MasterHolidayEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MasterHolidayJpaRepository extends JpaRepository<MasterHolidayEntity, LocalDate> {
    List<MasterHolidayEntity> findByHolidayGreaterThanEqualOrderByHoliday(LocalDate date);
}