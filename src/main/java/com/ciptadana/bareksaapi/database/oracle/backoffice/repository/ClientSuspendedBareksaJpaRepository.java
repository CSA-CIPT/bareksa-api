package com.ciptadana.bareksaapi.database.oracle.backoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientControlKey;
import com.ciptadana.bareksaapi.database.oracle.backoffice.entity.ClientControlEntity;
import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientSuspendedBareksa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientSuspendedBareksaJpaRepository extends JpaRepository<ClientControlEntity, ClientControlKey> {

    @Query(value = "select a.client_id AS CLIENTID,a.name, a.effective, suspended " +
            "                    from (" +
            "                        select client_id, name, max(effective) effective" +
            "                        from client_control a, client b" +
            "                        where client_id = code and closured_by is null and (client_id LIKE '14519%' OR client_id LIKE '17519%')" +
            "                        group by client_id , name " +
            "                    ) a " +
            "                    join client_control b on a.client_id = b.client_id and a.effective = b.effective " +
            "                    where suspended = '3' " +
            "                    order by a.client_id, a.name asc",
            nativeQuery = true)
    List<GetClientSuspendedBareksa> getClientSuspendedBareksa();

    @Query(value = "WITH Subquery AS ( " +
            "  SELECT CLIENT_ID AS CLIENTID, NAME, TO_CHAR(MAX(EFFECTIVE), 'DD-Mon-YY') AS EFFECTIVE, SUSPENDED " +
            "  FROM CLIENT_CONTROL A, CLIENT B " +
            "  WHERE CLIENT_ID = CODE AND CLOSURED_BY IS NULL AND (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "  GROUP BY CLIENT_ID, NAME, SUSPENDED " +
            ") " +
            "SELECT A.CLIENTID, A.NAME, A.EFFECTIVE, A.SUSPENDED " +
            "FROM Subquery A " +
            "JOIN CLIENT_CONTROL B ON A.CLIENTID = B.CLIENT_ID AND A.EFFECTIVE = B.EFFECTIVE " +
            "ORDER BY A.CLIENTID, A.NAME ASC",
            nativeQuery = true)
    List<GetClientSuspendedBareksa> getClientUnsuspendedBareksa2();

    @Query(value = "select a.client_id AS CLIENTID ,a.name, a.effective, suspended " +
            "                   from (" +
            "                     select client_id, name, max(effective) effective " +
            "                     from client_control a, client b " +
            "                     where client_id = code and closured_by is null and (client_id LIKE '14519%' OR client_id LIKE '17519%') " +
            "                     group by client_id , name " +
            "                   ) a " +
            "                   join client_control b on a.client_id = b.client_id and a.effective = b.effective " +
            "                   order by a.client_id, a.name asc",
            nativeQuery = true)
    List<GetClientSuspendedBareksa> getClientUnsuspendedBareksa();
}
