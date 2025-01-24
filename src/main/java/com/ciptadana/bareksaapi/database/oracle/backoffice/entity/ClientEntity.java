package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CLIENT", schema = "DENPASAR", catalog = "")
public class ClientEntity {

    @Id
    @Column(name = "CODE")
    private String code;

    @Column(name = "OLD_CODE")
    private String oldCode;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TAX_ID")
    private String taxId;

    @Column(name = "NPWP")
    private String npwp;

    @Column(name = "FOREIGNER")
    private String foreigner;

    @Column(name = "AFFILIATED")
    private String affiliated;

    @Column(name = "CLIENT_PPH")
    private Short clientPph;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH_PLACE")
    private String birthPlace;

    @Column(name = "BIRTH_DATE")
    private Date birthDate;

    @Column(name = "MEMBER_SINCE")
    private Date memberSince;

    @Column(name = "PHYSICAL_ADDRESS1")
    private String physicalAddress1;

    @Column(name = "PHYSICAL_ADDRESS2")
    private String physicalAddress2;

    @Column(name = "PHYSICAL_ADDRESS3")
    private String physicalAddress3;

    @Column(name = "PHYSICAL_CITY")
    private String physicalCity;

    @Column(name = "PHYSICAL_STATE")
    private String physicalState;

    @Column(name = "PHYSICAL_ZIPCODE")
    private String physicalZipcode;

    @Column(name = "MAILING_NAME")
    private String mailingName;

    @Column(name = "MAILING_ADDRESS1")
    private String mailingAddress1;

    @Column(name = "MAILING_ADDRESS2")
    private String mailingAddress2;

    @Column(name = "MAILING_ADDRESS3")
    private String mailingAddress3;

    @Column(name = "MAILING_CITY")
    private String mailingCity;

    @Column(name = "MAILING_STATE")
    private String mailingState;

    @Column(name = "MAILING_ZIPCODE")
    private String mailingZipcode;

    @Column(name = "CONTACT_HOME")
    private String contactHome;

    @Column(name = "CONTACT_OFFICE")
    private String contactOffice;

    @Column(name = "CONTACT_FAX")
    private String contactFax;

    @Column(name = "CONTACT_OTHER")
    private String contactOther;

    @Column(name = "CONTACT_EMAIL")
    private String contactEmail;

    @Column(name = "BANK_ACCOUNT_NAME")
    private String bankAccountName;

    @Column(name = "BANK_ACCOUNT_NO")
    private String bankAccountNo;

    @Column(name = "BANK_NAME")
    private String bankName;

    @Column(name = "BANK_BRANCH")
    private String bankBranch;

    @Column(name = "SALESMAN")
    private int salesman;

    @Column(name = "BRANCH")
    private String branch;

    @Column(name = "CLIENT_TYPE")
    private String clientType;

    @Column(name = "CLIENT_GROUP")
    private String clientGroup;

    @Column(name = "CITIZEN")
    private Integer citizen;

    @Column(name = "DOMISILI")
    private Integer domisili;

    @Column(name = "INVESTOR_TYPE")
    private Integer investorType;

    @Column(name = "CONFIRMATION")
    private Short confirmation;

    @Column(name = "CLOSURED_BY")
    private String closuredBy;

    @Column(name = "CLOSURED_DATE")
    private Date closuredDate;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "REPORT")
    private Short report;

    @Column(name = "CARD_ID")
    private String cardId;

    @Column(name = "EXP_CARD_ID")
    private Date expCardId;

    @Column(name = "PASPORT_ID")
    private String pasportId;

    @Column(name = "KSEI_SUB_REK")
    private String kseiSubRek;

    @Column(name = "SID")
    private String sid;

    @Column(name = "CLIENT_DOC")
    private String clientDoc;

    @Column(name = "INDUSTRY_TYPE")
    private String industryType;

    @Column(name = "TAX_STATUS")
    private Integer taxStatus;
}