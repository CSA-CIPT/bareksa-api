package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.TempHPokokEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TempHPokokJpaRepository extends JpaRepository<TempHPokokEntity, Long> {

    @Query(value = "SELECT * FROM TEMP_HPOKOK ORDER BY NSHARE ASC, TRANS_DATE ASC",  nativeQuery = true)
    List<TempHPokokEntity> findAllByOrderByNshareAscTransDateAsc();
}
