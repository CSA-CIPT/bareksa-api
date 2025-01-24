package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientCommissionEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientCommissionEntityPK;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCommission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientCommissionJpaRepository extends JpaRepository<ClientCommissionEntity, ClientCommissionEntityPK> {


    @Query(value = "SELECT * " +
            "FROM ( " +
            "SELECT a.client_id AS CLIENTID, a.name, a.sid, a.effective, b.r_commission AS COMMISSIONBUY, b.minimum_commission as MINIMUMCOMMISSION, b.r_commission + 0.1 AS COMMISSIONSELL, ROWNUM rnum " +
            "FROM ( " +
            "SELECT client_id, name, MAX(effective) effective, sid " +
            "FROM client_commission a, client " +
            "WHERE client_id = code AND closured_by IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "GROUP BY client_id, name, sid " +
            "ORDER BY client_id, name ASC " +
            ") a " +
            "JOIN client_commission b ON a.client_id = b.client_id AND a.effective = b.effective " +
            "WHERE ROWNUM <= :end " +
            ") t " +
            "WHERE rnum > :start",
            nativeQuery = true)
    List<GetClientCommission> getClientCommission(@Param("start") int start, @Param("end") int end);

    @Query(value =  "SELECT COUNT(*) " +
            "FROM ( " +
            "SELECT a.client_id, a.name, a.sid, a.effective, b.r_commission AS commission_buy, b.minimum_commission, b.r_commission + 0.1 AS commission_sell, ROWNUM rnum " +
            "FROM (" +
            "SELECT client_id, name, MAX(effective) effective, sid " +
            "FROM client_commission a, client " +
            "WHERE client_id = code AND closured_by IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "GROUP BY client_id, name, sid " +
            "ORDER BY client_id, name ASC " +
            ") a " +
            "JOIN client_commission b ON a.client_id = b.client_id AND a.effective = b.effective " +
            ") t ", nativeQuery = true)
    long getClientCommissionCount();


    @Query(value = "SELECT * " +
            "FROM ( " +
            "         SELECT " +
            "             a.client_id AS CLIENTID, " +
            "             a.name, " +
            "             a.sid, " +
            "             a.effective, " +
            "             b.r_commission AS COMMISSIONBUY, " +
            "             b.minimum_commission as MINIMUMCOMMISSION, " +
            "             b.r_commission  + 0.1 as COMMISSIONSELL " +
            "         FROM ( " +
            "                  SELECT client_id, " +
            "                         name, " +
            "                         MAX(effective) effective, " +
            "                         sid " +
            "                  FROM client_commission a, client " +
            "                  WHERE client_id = code AND closured_by IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "                  GROUP BY client_id, name, sid " +
            "              ) a " +
            "                  JOIN client_commission b ON a.client_id = b.client_id AND a.effective = b.effective " +
            "     ) t ", nativeQuery = true)
    List<GetClientCommission> getClientCommission();
}
