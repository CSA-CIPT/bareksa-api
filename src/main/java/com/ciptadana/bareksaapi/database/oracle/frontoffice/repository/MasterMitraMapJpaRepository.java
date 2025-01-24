package com.ciptadana.bareksaapi.database.oracle.frontoffice.repository;

import com.ciptadana.bareksaapi.database.oracle.backoffice.repository.projection.GetClientCharge;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapEntity;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.entity.MasterMitraMapKey;
import com.ciptadana.bareksaapi.database.oracle.frontoffice.repository.projection.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MasterMitraMapJpaRepository extends JpaRepository<MasterMitraMapEntity, MasterMitraMapKey> {
    @Query(value = "SELECT M.MITRA_CODE AS MITRACODE, M.MITRA_NAME AS MITRANAME, MM.UPDATED_BY AS UPDATEDBY, MM.UPDATED_ON AS UPDATEDON " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN SALESMAN@BOS S ON S.ID = MM.SALESMAN_ID " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE",
            nativeQuery = true)
    List<GetMasterMitraPPE> getMasterMitraPPE();

    @Query(value = "SELECT DISTINCT R.BANK_ACC_NO_INVESTOR FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL AND " +
            "R.BANK_ACC_NO_INVESTOR IS NOT NULL AND " +
            "SUBSTR(C.CODE, 3, 3) = '519'",
            nativeQuery = true)
    List<String> getBankAccNoInvestor();

    @Query(value = "SELECT DISTINCT R.BANK_ACC_NO_INVESTOR FROM CLIENT@BOS C " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL AND " +
            "R.BANK_ACC_NO_INVESTOR IS NOT NULL AND " +
            "SUBSTR(C.CODE, 3, 3) = '519'",
            nativeQuery = true)
    List<String> getBankAccNoInvestorUpdate();

    @Query(value = "SELECT DISTINCT R.BANK_ACC_NO_INVESTOR FROM CLIENT@BOS C " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL AND " +
            "R.BANK_ACC_NO_INVESTOR IS NOT NULL AND " +
            "SUBSTR(C.CODE, 3, 3) = '518' AND C.CODE = :code",
            nativeQuery = true)
    List<String> getBankAccNoInvestorBluechip(@Param("code") String code);

    @Query(value = "SELECT DISTINCT C.CODE, C.NAME " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "WHERE C.CLOSURED_BY IS NULL " +
            "AND C.CODE IS NOT NULL " +
            "AND C.CODE = :code",

            countQuery = "SELECT DISTINCT COUNT(*) " +
                    "FROM BAREKSA.MASTER_MITRA_MAP MM " +
                    "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
                    "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
                    "WHERE C.CLOSURED_BY IS NULL " +
                    "AND C.CODE IS NOT NULL " +
                    "AND C.CODE = :code",
            nativeQuery = true)
    List<GetMasterMitra> getMasterMitraByClientCode(@Param("code") String code);

    @Query(value = "SELECT DISTINCT C.CODE, C.NAME " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "WHERE C.CLOSURED_BY IS NULL " +
            "AND C.CODE IS NOT NULL ",

            countQuery = "SELECT DISTINCT COUNT(*) " +
                    "FROM BAREKSA.MASTER_MITRA_MAP MM " +
                    "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
                    "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
                    "WHERE C.CLOSURED_BY IS NULL " +
                    "AND C.CODE IS NOT NULL ",
            nativeQuery = true)
    List<GetMasterMitra> getMasterMitra();


    @Query(value = "SELECT DISTINCT " +
            "M.MITRA_CODE AS MITRACODE, " +
            "M.MITRA_NAME AS MITRANAME, " +
            "C.CODE AS CODE, " +
            "C.NAME AS NAME, " +
            "C.FOREIGNER AS FOREIGNER, " +
            "C.SID AS SID, " +
            "C.KSEI_SUB_REK AS KSEISUBREK, " +
            "C.CONTACT_HOME AS CONTACTHOME, " +
            "C.CONTACT_OFFICE AS CONTACTOFFICE, " +
            "C.CONTACT_FAX AS CONTACTFAX, " +
            "C.CONTACT_OTHER AS CONTACTOTHER, " +
            "C.CONTACT_EMAIL AS CONTACTEMAIL, " +
            "C.BANK_ACCOUNT_NAME AS BANKACCOUNTNAME, " +
            "C.BANK_ACCOUNT_NO AS BANKACCOUNTNO, " +
            "C.BANK_NAME AS BANKNAME, " +
            "C.BANK_BRANCH AS BANKBRANCH, " +
            "R.BANK_ACC_NAME_INVESTOR AS BANKACCNOINVESTOR, " +
            "CC.CLIENT_RATING AS CLIENTRATING, " +
            "CC.TRADING_LIMIT AS TRADINGLIMIT, " +
            "TO_CHAR(C.MEMBER_SINCE, 'yyyymmdd') AS MEMBERSINCE, " +
            "TO_CHAR(C.MODIFIED_DATE, 'yyyymmdd-hh24:mi:ss') AS LASTMODIFIED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN SALESMAN@BOS S ON MM.SALESMAN_ID = S.ID " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "LEFT JOIN CLIENT_CONTROL@BOS CC ON C.CODE = CC.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL " +
            "AND C.CODE IS NOT NULL " +
            "AND C.SID IS NOT NULL " ,
            //"AND C.KSEI_SUB_REK IS NOT NULL ",

            countQuery = "SELECT DISTINCT COUNT(*) " +
                    "FROM BAREKSA.MASTER_MITRA_MAP MM " +
                    "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
                    "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
                    "WHERE C.CLOSURED_BY IS NULL " +
                    "AND C.CODE IS NOT NULL " +
                    "AND C.SID IS NOT NULL ",
                    //"AND C.KSEI_SUB_REK IS NOT NULL ",
            nativeQuery = true)
    Page<GetClientListMPPE> getClientListMPPE(Pageable pageable);

    @Query(value = "SELECT DISTINCT " +
            "M.MITRA_CODE AS MITRACODE, " +
            "M.MITRA_NAME AS MITRANAME, " +
            "C.CODE AS CODE, " +
            "C.NAME AS NAME, " +
            "C.FOREIGNER AS FOREIGNER, " +
            "C.SID AS SID, " +
            "C.KSEI_SUB_REK AS KSEISUBREK, " +
            "C.CONTACT_HOME AS CONTACTHOME, " +
            "C.CONTACT_OFFICE AS CONTACTOFFICE, " +
            "C.CONTACT_FAX AS CONTACTFAX, " +
            "C.CONTACT_OTHER AS CONTACTOTHER, " +
            "C.CONTACT_EMAIL AS CONTACTEMAIL, " +
            "C.BANK_ACCOUNT_NAME AS BANKACCOUNTNAME, " +
            "C.BANK_ACCOUNT_NO AS BANKACCOUNTNO, " +
            "C.BANK_NAME AS BANKNAME, " +
            "C.BANK_BRANCH AS BANKBRANCH, " +
            "R.BANK_ACC_NAME_INVESTOR AS BANKACCNOINVESTOR, " +
            "CC.CLIENT_RATING AS CLIENTRATING, " +
            "CC.TRADING_LIMIT AS TRADINGLIMIT, " +
            "TO_CHAR(C.MEMBER_SINCE, 'yyyymmdd') AS MEMBERSINCE, " +
            "TO_CHAR(C.MODIFIED_DATE, 'yyyymmdd-hh24:mi:ss') AS LASTMODIFIED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN SALESMAN@BOS S ON MM.SALESMAN_ID = S.ID " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "LEFT JOIN CLIENT_CONTROL@BOS CC ON C.CODE = CC.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL " +
            "AND C.CODE IS NOT NULL " +
            "AND C.SID IS NOT NULL ",
            //"AND C.KSEI_SUB_REK IS NOT NULL ",
            nativeQuery = true)
    List<GetClientListMPPE> getAllClientMppe();


    @Query(value = "SELECT DISTINCT " +
            "M.MITRA_CODE AS MITRACODE, " +
            "M.MITRA_NAME AS MITRANAME, " +
            "C.CODE AS CODE, " +
            "C.NAME AS NAME, " +
            "C.FOREIGNER AS FOREIGNER, " +
            "C.SID AS SID, " +
            "C.KSEI_SUB_REK AS KSEISUBREK, " +
            "C.CONTACT_HOME AS CONTACTHOME, " +
            "C.CONTACT_OFFICE AS CONTACTOFFICE, " +
            "C.CONTACT_FAX AS CONTACTFAX, " +
            "C.CONTACT_OTHER AS CONTACTOTHER, " +
            "C.CONTACT_EMAIL AS CONTACTEMAIL, " +
            "C.BANK_ACCOUNT_NAME AS BANKACCOUNTNAME, " +
            "C.BANK_ACCOUNT_NO AS BANKACCOUNTNO, " +
            "C.BANK_NAME AS BANKNAME, " +
            "C.BANK_BRANCH AS BANKBRANCH, " +
            "R.BANK_ACC_NAME_INVESTOR AS BANKACCNOINVESTOR, " +
            "CC.CLIENT_RATING AS CLIENTRATING, " +
            "CC.TRADING_LIMIT AS TRADINGLIMIT, " +
            "TO_CHAR(C.MEMBER_SINCE, 'yyyymmdd') AS MEMBERSINCE, " +
            "TO_CHAR(C.MODIFIED_DATE, 'yyyymmdd-hh24:mi:ss') AS LASTMODIFIED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN BAREKSA.MASTER_MITRA M ON M.MITRA_CODE = MM.MITRA_CODE " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN SALESMAN@BOS S ON MM.SALESMAN_ID = S.ID " +
            "LEFT JOIN CLIENT_PROPERTY@BOS R ON C.CODE = R.CLIENT_ID " +
            "LEFT JOIN CLIENT_CONTROL@BOS CC ON C.CODE = CC.CLIENT_ID " +
            "WHERE C.CLOSURED_BY IS NULL " +
            "AND C.CODE IS NOT NULL " +
            "AND C.SID IS NOT NULL " +
            //"AND C.KSEI_SUB_REK IS NOT NULL " +
            "AND (" +
            "    TO_CHAR(C.MEMBER_SINCE, 'YYYYMMDD') = TO_CHAR(SYSDATE, 'YYYYMMDD') " +
            "    OR TO_CHAR(C.MODIFIED_DATE, 'YYYYMMDD') = TO_CHAR(SYSDATE, 'YYYYMMDD') " +
            ")", nativeQuery = true)
    List<GetClientListMPPE> getTodayUpdatedClientMppe();


    @Query(value = "SELECT DISTINCT " +
            "R.CLIENTCODE, " +
            "R.NSHARE AS NSHARE, " +
            "R.AVG_PRICE AS AVERAGEPRICE, " +
            "R.LAST_UPDATED AS LASTUPDATED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN TEMP_CLIENTAVG_MPPE R ON R.CLIENTCODE = C.CODE " +
            "WHERE AVG_PRICE IS NOT NULL",

            countQuery = "SELECT DISTINCT COUNT(*) " +
                    "FROM BAREKSA.MASTER_MITRA_MAP MM " +
                    "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
                    "LEFT JOIN TEMP_CLIENTAVG_MPPE R ON R.CLIENTCODE = C.CODE " +
                    "WHERE AVG_PRICE IS NOT NULL",
            nativeQuery = true)
    Page<GetClientAveragePrice> getClientAveragePrice(Pageable pageable);

    @Query(value = "SELECT DISTINCT " +
            "R.CLIENTCODE, " +
            "R.NSHARE AS NSHARE, " +
            "R.AVG_PRICE AS AVERAGEPRICE, " +
            "R.LAST_UPDATED AS LASTUPDATED " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "LEFT JOIN TEMP_CLIENTAVG_MPPE R ON R.CLIENTCODE = C.CODE " +
            "WHERE AVG_PRICE IS NOT NULL",
            nativeQuery = true)
    List<GetClientAveragePrice> getClientAveragePrice();

    @Query(value = "SELECT DISTINCT MM.MITRA_CODE AS MITRACODE " +
            ",C.CODE AS CODE " +
            ",C.NAME AS NAME " +
            ",C.CONTACT_HOME AS CONTACTHOME " +
            ",C.CONTACT_OFFICE AS CONTACTOFFICE " +
            ",C.CONTACT_FAX AS CONTACTFAX " +
            ",C.CONTACT_OTHER AS CONTACTOTHER " +
            ",C.CONTACT_EMAIL AS CONTACTEMAIL " +
            ",C.BANK_ACCOUNT_NAME AS BANKACCOUNTNAME " +
            ",C.BANK_ACCOUNT_NO AS BANKACCOUNTNO " +
            ",C.BANK_NAME AS BANKNAME " +
            ",C.BANK_BRANCH AS BANKBRANCH " +
            "FROM BAREKSA.MASTER_MITRA_MAP MM " +
            "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
            "WHERE C.CLOSURED_BY IS NOT NULL ",

            countQuery = "SELECT DISTINCT COUNT(*) " +
                    "FROM BAREKSA.MASTER_MITRA_MAP MM " +
                    "LEFT JOIN CLIENT@BOS C ON MM.SALESMAN_ID = C.SALESMAN " +
                    "WHERE C.CLOSURED_BY IS NOT NULL "
            ,nativeQuery = true)
    Page<GetClientListMitraPPEInactive> getInactiveClients(Pageable pageable);



}
