package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ViewMasterStockEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetViewMasterStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ViewMasterStockJpaRepository extends JpaRepository<ViewMasterStockEntity, String> {

    @Query(value = "SELECT MS.STOCK_ID AS STOCKID, MS.STOCKCODE , MS.STOCKNAME , MS.SUBSECTOR_ID AS SUBSECTORID, " +
            "MS.STATUS , MS.BOARD , MS.COLORHEX , MS.SECURITYTYPE , MS.PREOPENINGFLAG,  " +
            "CASE WHEN CLIENT_TYPE_ID = 33 THEN 'Y' ELSE 'N' END AS ISMARGIN, " +
            "S.MARKING_PERCENT AS MARKINGPERCENT " +
            "FROM CIPTAMI.V_MASTER_STOCK MS " +
            "LEFT JOIN DENPASAR.SHARES@BOS S ON MS.STOCKCODE = S.CODE " +
            "ORDER BY MS.STOCKCODE",
            nativeQuery = true)
    List<GetViewMasterStock> getViewMasterStock();

}


