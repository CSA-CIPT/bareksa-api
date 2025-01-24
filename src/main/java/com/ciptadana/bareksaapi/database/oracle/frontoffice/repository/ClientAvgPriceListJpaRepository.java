package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetClientAvgPriceList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientAvgPriceListJpaRepository extends JpaRepository<MasterMitraMapEntity, MasterMitraMapKey> {
    @Query(value = "SELECT DISTINCT R.CLIENTCODE, R.NSHARE, R.AVG_PRICE AS AVGPRICE, R.LAST_UPDATED AS LASTUPDATED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN TEMP_CLIENTAVG_MPPE R ON R.CLIENTCODE = C.CODE " +
            "WHERE R.AVG_PRICE IS NOT NULL ",
    nativeQuery = true)
    Page<GetClientAvgPriceList> getClientAvgPriceList(Pageable page);
}
