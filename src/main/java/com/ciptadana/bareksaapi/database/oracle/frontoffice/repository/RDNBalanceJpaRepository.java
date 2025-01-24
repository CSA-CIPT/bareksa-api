package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.RDIBalanceEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.RDIBalanceKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetRDNBareksa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.GetRDNBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RDNBalanceJpaRepository extends JpaRepository<RDIBalanceEntity, RDIBalanceKey> {

    @Query(value = "SELECT DISTINCT R.RECDATE, R.RECTIME, R.CLIENTCODE, R.NOREK, R.BALANCE, R.CONTRABAL, CP.BANK_NAME_INVESTOR AS BANKNAMEINVESTOR " +
    "FROM RDI_BALANCE R " +
    "LEFT JOIN CLIENT_PROPERTY@BOS CP ON R.CLIENTCODE = CP.CLIENT_ID " +
    "LEFT JOIN CLIENT@BOS C ON R.CLIENTCODE = C.CODE " +
    "WHERE R.CLIENTCODE = :clientCode " +
    "AND C.CLOSURED_BY IS NULL ", nativeQuery = true)
    List<GetRDNBalance> getRDIBalanceByClientCode(@Param("clientCode") String clientCode);


    @Query(value = "SELECT " +
            "RECDATE, " +
            "RECTIME, " +
            "BALANCE, " +
            "CONTRABAL, " +
            "CLIENTCODE, " +
            "NOREK, " +
            "BANK_NAME_INVESTOR AS BANKNAMEINVESTOR " +
            "FROM CORE.V_RDN_BAREKSA",
            countQuery = "SELECT DISTINCT COUNT(*) FROM CORE.RDI_BALANCE R " +
                         "LEFT JOIN CLIENT_PROPERTY@BOS CP ON R.CLIENTCODE = CP.CLIENT_ID " +
                         "WHERE SUBSTR(R.CLIENTCODE,3,3) = '519'",
            nativeQuery = true)
    Page<GetRDNBareksa> getAllBareksaRDN(Pageable pageable);


    @Query(value = "SELECT SUM(AMOUNT) AMOUNT " +
            "FROM RDI_BALANCE RDI, TEMP_CLIENT_THREEDAYS TD " +
            "WHERE RDI.CLIENTCODE = TD.SUBACCOUNT " +
            "AND RDI.CLIENTCODE = :clientCode ",
            nativeQuery = true)
    Long getBalanceSumThreeDaysByClientCode(@Param("clientCode") String clientCode);


    @Query(value = "SELECT " +
            "RECDATE, " +
            "RECTIME, " +
            "BALANCE, " +
            "CONTRABAL, " +
            "CLIENTCODE, " +
            "NOREK, " +
            "BANK_NAME_INVESTOR AS BANKNAMEINVESTOR " +
            "FROM CORE.V_RDN_BAREKSA",
            nativeQuery = true)
    List<GetRDNBareksa> getAllBareksaRDN();
}
