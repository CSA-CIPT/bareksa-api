package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientChargeEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientChargeEntityPK;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientChargeJpaRepository extends JpaRepository<ClientChargeEntity, ClientChargeEntityPK> {

    @Query(value = "SELECT * " +
            "FROM (" +
            "SELECT a.client_id as CLIENTID, a.name, a.sid, a.effective, b.dana_kurang_rate AS LESSFUNDRATE, ROWNUM rnum " +
            "FROM ( " +
            "SELECT client_id, name, MAX(effective) effective, sid " +
            "FROM client_charges a, client b " +
            "WHERE client_id = code AND closured_by IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%')  " +
            "AND (:date IS NULL OR TO_CHAR(EFFECTIVE, 'YYYYMMDD') = :date) " +
            "GROUP BY client_id, name, sid " +
            "ORDER BY client_id, name ASC " +
            ") a " +
            "JOIN client_charges b ON a.client_id = b.client_id AND a.effective = b.effective " +
            ") ",
            nativeQuery = true)
    List<GetClientCharge> getClientChargesByDate(@Param("date") String date);

    @Query(value = "SELECT * " +
            "FROM (" +
            "SELECT a.client_id as CLIENTID, a.name, a.sid, a.effective, b.dana_kurang_rate AS LESSFUNDRATE, ROWNUM rnum " +
            "FROM ( " +
            "SELECT client_id, name, MAX(effective) effective, sid " +
            "FROM client_charges a, client b " +
            "WHERE client_id = code AND closured_by IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "GROUP BY client_id, name, sid " +
            "ORDER BY client_id, name ASC " +
            ") a " +
            "JOIN client_charges b ON a.client_id = b.client_id AND a.effective = b.effective " +
            ") ",
            nativeQuery = true)
    List<GetClientCharge> getAllClientCharges();
}
