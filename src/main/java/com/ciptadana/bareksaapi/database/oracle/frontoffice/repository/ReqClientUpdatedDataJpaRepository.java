package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientUpdatedDataEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.ReqClientUpdatedDataKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetUpdateClientProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReqClientUpdatedDataJpaRepository extends JpaRepository<ReqClientUpdatedDataEntity, ReqClientUpdatedDataKey> {
    @Query(value = "SELECT MM.CODE, " +
            "MM.EMAIL, " +
            "MM.ID_CARD_NO AS IDCARDNO, " +
            "MM.MODIFIED_DATE AS MODIFIEDDATE, " +
            "MM.STATUS, " +
            "MM.REJECTREASON " +
            "FROM BAREKSA.REQ_CLIENT_UPDATED_DATA MM " +
            "WHERE SUBSTR(MODIFIED_DATE,0,10) > TO_CHAR(SYSDATE-30, 'YYYY-MM-DD') " +
            "ORDER BY MM.MODIFIED_DATE ", nativeQuery = true)
    List<GetUpdateClientProperty> getClientUpdateLastThirtyDays();


}
