package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.PfPrevBalEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.PfPrevBalKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientPortfolioPrevBalJpaRepository extends JpaRepository<PfPrevBalEntity, PfPrevBalKey> {
//    @Query(value = "SELECT NCLIENT, NSHARE, PREVBAL " +
//            "FROM BOGOR.PF_PREVBAL T " +
//            "WHERE SUBSTR(NCLIENT, 3, 3) = '518' " +
//            "ORDER BY NCLIENT",
//    nativeQuery = true)
    @Query(value = "SELECT NCLIENT, NSHARE, PREVBAL, UPDTIME " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "JOIN BOGOR.PF_PREVBAL T ON C.CODE = T.NCLIENT " +
            "WHERE NCLIENT IS NOT NULL " +
            "ORDER BY NCLIENT ",
            nativeQuery = true)
    List<PfPrevBalEntity> getAllPreviousBalance();
}
