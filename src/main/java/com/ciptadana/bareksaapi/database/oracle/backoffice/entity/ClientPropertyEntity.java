package com.ciptadana.bareksaapi.database.oracle.backoffice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CLIENT_PROPERTY", schema = "DENPASAR")
public class ClientPropertyEntity {

    @Id
    @Column(name = "CLIENT_ID")
    private String clientId;

    @Column(name = "INTEREST_AGRREMENT")
    private Boolean interestAgrrement;

    @Column(name = "STANDING_INSTRUCTION")
    private Boolean standingInstruction;

    @Column(name = "EXPIRE_PASSPORT")
    private Date expirePassport;

    @Column(name = "EXPIRE_KITAS")
    private Date expireKitas;

    @Column(name = "KITAS")
    private String kitas;

    @Column(name = "BANK_CUSTODY")
    private String bankCustody;

    @Column(name = "BANK_ACC_NAME_INVESTOR")
    private String bankAccNameInvestor;

    @Column(name = "BANK_ACC_NO_INVESTOR")
    private String bankAccNoInvestor;

    @Column(name = "BANK_NAME_INVESTOR")
    private String bankNameInvestor;

    @Column(name = "BANK_BRANCH_INVESTOR")
    private String bankBranchInvestor;

    @Column(name = "MODIFIED_DATE")
    private Date modifiedDate;

    @Column(name = "MODIFIED_BY")
    private String modifiedBy;

    @Column(name = "REFF_CODE")
    private String reffCode;

    @Column(name = "FUND_SOURCE")
    private String fundSource;

    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;

    @Column(name = "HEIR_RELATION")
    private String heirRelation;

    @Column(name = "HEIR_NAME")
    private String heirName;

    @Column(name = "SPOUSE_NAME")
    private String spouseName;

    @Column(name = "INCOME_PER_NUM")
    private String incomePerNum;

    @Column(name = "INVESTMENT_OBJECTIVE")
    private String investmentObjective;

    @Column(name = "NATURE_OF_BUSSINES")
    private String natureOfBussines;

    @Column(name = "CONFIRMATION_MODEL")
    private String confirmationModel;

    @Column(name = "INVESTOR_CATEGORY")
    private Boolean investorCategory;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "REGDATE_NPWP")
    private Date regdateNpwp;

    @Column(name = "COUNTRY_2")
    private Integer country2;

    @Column(name = "CONTACT_PHONE_2")
    private String contactPhone2;

    @Column(name = "CONTACT_EMAIL_2")
    private String contactEmail2;

    @Column(name = "CONTACT_FAX_2")
    private String contactFax2;

    @Column(name = "EDUCATIONAL_BACKGROUND")
    private Boolean educationalBackground;

    @Column(name = "OCCUPATION")
    private Boolean occupation;

    @Column(name = "OCCUPATION_TEXT")
    private String occupationText;

    @Column(name = "BIC_CODE")
    private String bicCode;

    @Column(name = "BANK_CURRENCY")
    private String bankCurrency;

    @Column(name = "BANK_CURRENCY_2")
    private String bankCurrency2;

    @Column(name = "BIC_CODE_2")
    private String bicCode2;

    @Column(name = "BIC_CODE_3")
    private String bicCode3;

    @Column(name = "BANK_NAME_3")
    private String bankName3;

    @Column(name = "BANK_ACCOUNT_NAME_3")
    private String bankAccountName3;

    @Column(name = "BANK_ACCOUNT_NO_3")
    private String bankAccountNo3;

    @Column(name = "BANK_CURRENCY_3")
    private String bankCurrency3;

    @Column(name = "MOTHER_NAME")
    private String motherName;

    @Column(name = "OPT_RDN")
    private Boolean optRdn;

    @Column(name = "COMPANY_CHARACTERISTIC")
    private Boolean companyCharacteristic;

    @Column(name = "COMPANY_SIUP")
    private String companySiup;

    @Column(name = "COMPANY_EXPIRE_SIUP")
    private Date companyExpireSiup;

    @Column(name = "ARTICLE_OF_ASSOCIATION")
    private String articleOfAssociation;

    @Column(name = "BUSINESS_CERT_NO")
    private String businessCertNo;

    @Column(name = "AUTH_POSITION_1")
    private String authPosition1;

    @Column(name = "FIRST_NAME_2")
    private String firstName2;

    @Column(name = "MIDDLE_NAME_2")
    private String middleName2;

    @Column(name = "LAST_NAME_2")
    private String lastName2;

    @Column(name = "AUTH_POSITION_2")
    private String authPosition2;

    @Column(name = "CARD_ID_2")
    private String cardId2;

    @Column(name = "EXP_CARD_ID_2")
    private Date expCardId2;

    @Column(name = "NPWP_2")
    private String npwp2;

    @Column(name = "REGDATE_NPWP_2")
    private Date regdateNpwp2;

    @Column(name = "PASSPORT_ID_2")
    private String passportId2;

    @Column(name = "EXPIRE_PASSPORT_2")
    private Date expirePassport2;

    @Column(name = "KITAS_2")
    private String kitas2;

    @Column(name = "EXPIRE_KITAS_2")
    private Date expireKitas2;

    @Column(name = "FIRST_NAME_3")
    private String firstName3;

    @Column(name = "MIDDLE_NAME_3")
    private String middleName3;

    @Column(name = "LAST_NAME_3")
    private String lastName3;

    @Column(name = "AUTH_POSITION_3")
    private String authPosition3;

    @Column(name = "CARD_ID_3")
    private String cardId3;

    @Column(name = "EXP_CARD_ID_3")
    private Date expCardId3;

    @Column(name = "NPWP_3")
    private String npwp3;

    @Column(name = "REGDATE_NPWP_3")
    private Date regdateNpwp3;

    @Column(name = "PASSPORT_ID_3")
    private String passportId3;

    @Column(name = "EXPIRE_PASSPORT_3")
    private Date expirePassport3;

    @Column(name = "KITAS_3")
    private String kitas3;

    @Column(name = "EXPIRE_KITAS_3")
    private Date expireKitas3;

    @Column(name = "FIRST_NAME_4")
    private String firstName4;

    @Column(name = "MIDDLE_NAME_4")
    private String middleName4;

    @Column(name = "LAST_NAME_4")
    private String lastName4;

    @Column(name = "AUTH_POSITION_4")
    private String authPosition4;

    @Column(name = "CARD_ID_4")
    private String cardId4;

    @Column(name = "EXP_CARD_ID_4")
    private Date expCardId4;

    @Column(name = "NPWP_4")
    private String npwp4;

    @Column(name = "REGDATE_NPWP_4")
    private Date regdateNpwp4;

    @Column(name = "PASSPORT_ID_4")
    private String passportId4;

    @Column(name = "EXPIRE_PASSPORT_4")
    private Date expirePassport4;

    @Column(name = "KITAS_4")
    private String kitas4;

    @Column(name = "EXPIRE_KITAS_4")
    private Date expireKitas4;

    @Column(name = "LATEST_YEAR_ASSETS")
    private Boolean latestYearAssets;

    @Column(name = "LAST_2_YEAR_ASSETS")
    private Boolean last2YearAssets;

    @Column(name = "LAST_3_YEAR_ASSETS")
    private Boolean last3YearAssets;

    @Column(name = "LATEST_YEAR_PROFIT")
    private Boolean latestYearProfit;

    @Column(name = "LAST_2_YEAR_PROFIT")
    private Boolean last2YearProfit;

    @Column(name = "LAST_3_YEAR_PROFIT")
    private Boolean last3YearProfit;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "RELIGION")
    private String religion;

    @Column(name = "ASSETOWNER")
    private Boolean assetowner;

    @Column(name = "RECEIPT_NPWP")
    private Date receiptNpwp;

    @Column(name = "INSTITUTION_FLAG")
    private Boolean institutionFlag;

    @Column(name = "NETASSETVAL")
    private Long netassetval;

    @Column(name = "DIRECTSID")
    private Boolean directsid;

    @Column(name = "FUND_SOURCE_TEXT")
    private String fundSourceText;

    @Column(name = "CLIENT_DOC_EXPIRE")
    private Date clientDocExpire;

    @Column(name = "SINVEST_FLAG")
    private Boolean sinvestFlag;

    @Column(name = "AVGPRICE_FLAG")
    private Boolean avgpriceFlag;

    @Column(name = "OCCUPATIONOJK")
    private Long occupationojk;

    @Column(name = "OCCUPATIONOJK_TEXT")
    private String occupationojkText;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Boolean getInterestAgrrement() {
        return interestAgrrement;
    }

    public void setInterestAgrrement(Boolean interestAgrrement) {
        this.interestAgrrement = interestAgrrement;
    }

    public Boolean getStandingInstruction() {
        return standingInstruction;
    }

    public void setStandingInstruction(Boolean standingInstruction) {
        this.standingInstruction = standingInstruction;
    }

    public Date getExpirePassport() {
        return expirePassport;
    }

    public void setExpirePassport(Date expirePassport) {
        this.expirePassport = expirePassport;
    }

    public Date getExpireKitas() {
        return expireKitas;
    }

    public void setExpireKitas(Date expireKitas) {
        this.expireKitas = expireKitas;
    }

    public String getKitas() {
        return kitas;
    }

    public void setKitas(String kitas) {
        this.kitas = kitas;
    }

    public String getBankCustody() {
        return bankCustody;
    }

    public void setBankCustody(String bankCustody) {
        this.bankCustody = bankCustody;
    }

    public String getBankAccNameInvestor() {
        return bankAccNameInvestor;
    }

    public void setBankAccNameInvestor(String bankAccNameInvestor) {
        this.bankAccNameInvestor = bankAccNameInvestor;
    }

    public String getBankAccNoInvestor() {
        return bankAccNoInvestor;
    }

    public void setBankAccNoInvestor(String bankAccNoInvestor) {
        this.bankAccNoInvestor = bankAccNoInvestor;
    }

    public String getBankNameInvestor() {
        return bankNameInvestor;
    }

    public void setBankNameInvestor(String bankNameInvestor) {
        this.bankNameInvestor = bankNameInvestor;
    }

    public String getBankBranchInvestor() {
        return bankBranchInvestor;
    }

    public void setBankBranchInvestor(String bankBranchInvestor) {
        this.bankBranchInvestor = bankBranchInvestor;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getReffCode() {
        return reffCode;
    }

    public void setReffCode(String reffCode) {
        this.reffCode = reffCode;
    }

    public String getFundSource() {
        return fundSource;
    }

    public void setFundSource(String fundSource) {
        this.fundSource = fundSource;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getHeirRelation() {
        return heirRelation;
    }

    public void setHeirRelation(String heirRelation) {
        this.heirRelation = heirRelation;
    }

    public String getHeirName() {
        return heirName;
    }

    public void setHeirName(String heirName) {
        this.heirName = heirName;
    }

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getIncomePerNum() {
        return incomePerNum;
    }

    public void setIncomePerNum(String incomePerNum) {
        this.incomePerNum = incomePerNum;
    }

    public String getInvestmentObjective() {
        return investmentObjective;
    }

    public void setInvestmentObjective(String investmentObjective) {
        this.investmentObjective = investmentObjective;
    }

    public String getNatureOfBussines() {
        return natureOfBussines;
    }

    public void setNatureOfBussines(String natureOfBussines) {
        this.natureOfBussines = natureOfBussines;
    }

    public String getConfirmationModel() {
        return confirmationModel;
    }

    public void setConfirmationModel(String confirmationModel) {
        this.confirmationModel = confirmationModel;
    }

    public Boolean getInvestorCategory() {
        return investorCategory;
    }

    public void setInvestorCategory(Boolean investorCategory) {
        this.investorCategory = investorCategory;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getRegdateNpwp() {
        return regdateNpwp;
    }

    public void setRegdateNpwp(Date regdateNpwp) {
        this.regdateNpwp = regdateNpwp;
    }

    public Integer getCountry2() {
        return country2;
    }

    public void setCountry2(Integer country2) {
        this.country2 = country2;
    }

    public String getContactPhone2() {
        return contactPhone2;
    }

    public void setContactPhone2(String contactPhone2) {
        this.contactPhone2 = contactPhone2;
    }

    public String getContactEmail2() {
        return contactEmail2;
    }

    public void setContactEmail2(String contactEmail2) {
        this.contactEmail2 = contactEmail2;
    }

    public String getContactFax2() {
        return contactFax2;
    }

    public void setContactFax2(String contactFax2) {
        this.contactFax2 = contactFax2;
    }

    public Boolean getEducationalBackground() {
        return educationalBackground;
    }

    public void setEducationalBackground(Boolean educationalBackground) {
        this.educationalBackground = educationalBackground;
    }

    public Boolean getOccupation() {
        return occupation;
    }

    public void setOccupation(Boolean occupation) {
        this.occupation = occupation;
    }

    public String getOccupationText() {
        return occupationText;
    }

    public void setOccupationText(String occupationText) {
        this.occupationText = occupationText;
    }

    public String getBicCode() {
        return bicCode;
    }

    public void setBicCode(String bicCode) {
        this.bicCode = bicCode;
    }

    public String getBankCurrency() {
        return bankCurrency;
    }

    public void setBankCurrency(String bankCurrency) {
        this.bankCurrency = bankCurrency;
    }

    public String getBankCurrency2() {
        return bankCurrency2;
    }

    public void setBankCurrency2(String bankCurrency2) {
        this.bankCurrency2 = bankCurrency2;
    }

    public String getBicCode2() {
        return bicCode2;
    }

    public void setBicCode2(String bicCode2) {
        this.bicCode2 = bicCode2;
    }

    public String getBicCode3() {
        return bicCode3;
    }

    public void setBicCode3(String bicCode3) {
        this.bicCode3 = bicCode3;
    }

    public String getBankName3() {
        return bankName3;
    }

    public void setBankName3(String bankName3) {
        this.bankName3 = bankName3;
    }

    public String getBankAccountName3() {
        return bankAccountName3;
    }

    public void setBankAccountName3(String bankAccountName3) {
        this.bankAccountName3 = bankAccountName3;
    }

    public String getBankAccountNo3() {
        return bankAccountNo3;
    }

    public void setBankAccountNo3(String bankAccountNo3) {
        this.bankAccountNo3 = bankAccountNo3;
    }

    public String getBankCurrency3() {
        return bankCurrency3;
    }

    public void setBankCurrency3(String bankCurrency3) {
        this.bankCurrency3 = bankCurrency3;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public Boolean getOptRdn() {
        return optRdn;
    }

    public void setOptRdn(Boolean optRdn) {
        this.optRdn = optRdn;
    }

    public Boolean getCompanyCharacteristic() {
        return companyCharacteristic;
    }

    public void setCompanyCharacteristic(Boolean companyCharacteristic) {
        this.companyCharacteristic = companyCharacteristic;
    }

    public String getCompanySiup() {
        return companySiup;
    }

    public void setCompanySiup(String companySiup) {
        this.companySiup = companySiup;
    }

    public Date getCompanyExpireSiup() {
        return companyExpireSiup;
    }

    public void setCompanyExpireSiup(Date companyExpireSiup) {
        this.companyExpireSiup = companyExpireSiup;
    }

    public String getArticleOfAssociation() {
        return articleOfAssociation;
    }

    public void setArticleOfAssociation(String articleOfAssociation) {
        this.articleOfAssociation = articleOfAssociation;
    }

    public String getBusinessCertNo() {
        return businessCertNo;
    }

    public void setBusinessCertNo(String businessCertNo) {
        this.businessCertNo = businessCertNo;
    }

    public String getAuthPosition1() {
        return authPosition1;
    }

    public void setAuthPosition1(String authPosition1) {
        this.authPosition1 = authPosition1;
    }

    public String getFirstName2() {
        return firstName2;
    }

    public void setFirstName2(String firstName2) {
        this.firstName2 = firstName2;
    }

    public String getMiddleName2() {
        return middleName2;
    }

    public void setMiddleName2(String middleName2) {
        this.middleName2 = middleName2;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getAuthPosition2() {
        return authPosition2;
    }

    public void setAuthPosition2(String authPosition2) {
        this.authPosition2 = authPosition2;
    }

    public String getCardId2() {
        return cardId2;
    }

    public void setCardId2(String cardId2) {
        this.cardId2 = cardId2;
    }

    public Date getExpCardId2() {
        return expCardId2;
    }

    public void setExpCardId2(Date expCardId2) {
        this.expCardId2 = expCardId2;
    }

    public String getNpwp2() {
        return npwp2;
    }

    public void setNpwp2(String npwp2) {
        this.npwp2 = npwp2;
    }

    public Date getRegdateNpwp2() {
        return regdateNpwp2;
    }

    public void setRegdateNpwp2(Date regdateNpwp2) {
        this.regdateNpwp2 = regdateNpwp2;
    }

    public String getPassportId2() {
        return passportId2;
    }

    public void setPassportId2(String passportId2) {
        this.passportId2 = passportId2;
    }

    public Date getExpirePassport2() {
        return expirePassport2;
    }

    public void setExpirePassport2(Date expirePassport2) {
        this.expirePassport2 = expirePassport2;
    }

    public String getKitas2() {
        return kitas2;
    }

    public void setKitas2(String kitas2) {
        this.kitas2 = kitas2;
    }

    public Date getExpireKitas2() {
        return expireKitas2;
    }

    public void setExpireKitas2(Date expireKitas2) {
        this.expireKitas2 = expireKitas2;
    }

    public String getFirstName3() {
        return firstName3;
    }

    public void setFirstName3(String firstName3) {
        this.firstName3 = firstName3;
    }

    public String getMiddleName3() {
        return middleName3;
    }

    public void setMiddleName3(String middleName3) {
        this.middleName3 = middleName3;
    }

    public String getLastName3() {
        return lastName3;
    }

    public void setLastName3(String lastName3) {
        this.lastName3 = lastName3;
    }

    public String getAuthPosition3() {
        return authPosition3;
    }

    public void setAuthPosition3(String authPosition3) {
        this.authPosition3 = authPosition3;
    }

    public String getCardId3() {
        return cardId3;
    }

    public void setCardId3(String cardId3) {
        this.cardId3 = cardId3;
    }

    public Date getExpCardId3() {
        return expCardId3;
    }

    public void setExpCardId3(Date expCardId3) {
        this.expCardId3 = expCardId3;
    }

    public String getNpwp3() {
        return npwp3;
    }

    public void setNpwp3(String npwp3) {
        this.npwp3 = npwp3;
    }

    public Date getRegdateNpwp3() {
        return regdateNpwp3;
    }

    public void setRegdateNpwp3(Date regdateNpwp3) {
        this.regdateNpwp3 = regdateNpwp3;
    }

    public String getPassportId3() {
        return passportId3;
    }

    public void setPassportId3(String passportId3) {
        this.passportId3 = passportId3;
    }

    public Date getExpirePassport3() {
        return expirePassport3;
    }

    public void setExpirePassport3(Date expirePassport3) {
        this.expirePassport3 = expirePassport3;
    }

    public String getKitas3() {
        return kitas3;
    }

    public void setKitas3(String kitas3) {
        this.kitas3 = kitas3;
    }

    public Date getExpireKitas3() {
        return expireKitas3;
    }

    public void setExpireKitas3(Date expireKitas3) {
        this.expireKitas3 = expireKitas3;
    }

    public String getFirstName4() {
        return firstName4;
    }

    public void setFirstName4(String firstName4) {
        this.firstName4 = firstName4;
    }

    public String getMiddleName4() {
        return middleName4;
    }

    public void setMiddleName4(String middleName4) {
        this.middleName4 = middleName4;
    }

    public String getLastName4() {
        return lastName4;
    }

    public void setLastName4(String lastName4) {
        this.lastName4 = lastName4;
    }

    public String getAuthPosition4() {
        return authPosition4;
    }

    public void setAuthPosition4(String authPosition4) {
        this.authPosition4 = authPosition4;
    }

    public String getCardId4() {
        return cardId4;
    }

    public void setCardId4(String cardId4) {
        this.cardId4 = cardId4;
    }

    public Date getExpCardId4() {
        return expCardId4;
    }

    public void setExpCardId4(Date expCardId4) {
        this.expCardId4 = expCardId4;
    }

    public String getNpwp4() {
        return npwp4;
    }

    public void setNpwp4(String npwp4) {
        this.npwp4 = npwp4;
    }

    public Date getRegdateNpwp4() {
        return regdateNpwp4;
    }

    public void setRegdateNpwp4(Date regdateNpwp4) {
        this.regdateNpwp4 = regdateNpwp4;
    }

    public String getPassportId4() {
        return passportId4;
    }

    public void setPassportId4(String passportId4) {
        this.passportId4 = passportId4;
    }

    public Date getExpirePassport4() {
        return expirePassport4;
    }

    public void setExpirePassport4(Date expirePassport4) {
        this.expirePassport4 = expirePassport4;
    }

    public String getKitas4() {
        return kitas4;
    }

    public void setKitas4(String kitas4) {
        this.kitas4 = kitas4;
    }

    public Date getExpireKitas4() {
        return expireKitas4;
    }

    public void setExpireKitas4(Date expireKitas4) {
        this.expireKitas4 = expireKitas4;
    }

    public Boolean getLatestYearAssets() {
        return latestYearAssets;
    }

    public void setLatestYearAssets(Boolean latestYearAssets) {
        this.latestYearAssets = latestYearAssets;
    }

    public Boolean getLast2YearAssets() {
        return last2YearAssets;
    }

    public void setLast2YearAssets(Boolean last2YearAssets) {
        this.last2YearAssets = last2YearAssets;
    }

    public Boolean getLast3YearAssets() {
        return last3YearAssets;
    }

    public void setLast3YearAssets(Boolean last3YearAssets) {
        this.last3YearAssets = last3YearAssets;
    }

    public Boolean getLatestYearProfit() {
        return latestYearProfit;
    }

    public void setLatestYearProfit(Boolean latestYearProfit) {
        this.latestYearProfit = latestYearProfit;
    }

    public Boolean getLast2YearProfit() {
        return last2YearProfit;
    }

    public void setLast2YearProfit(Boolean last2YearProfit) {
        this.last2YearProfit = last2YearProfit;
    }

    public Boolean getLast3YearProfit() {
        return last3YearProfit;
    }

    public void setLast3YearProfit(Boolean last3YearProfit) {
        this.last3YearProfit = last3YearProfit;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Boolean getAssetowner() {
        return assetowner;
    }

    public void setAssetowner(Boolean assetowner) {
        this.assetowner = assetowner;
    }

    public Date getReceiptNpwp() {
        return receiptNpwp;
    }

    public void setReceiptNpwp(Date receiptNpwp) {
        this.receiptNpwp = receiptNpwp;
    }

    public Boolean getInstitutionFlag() {
        return institutionFlag;
    }

    public void setInstitutionFlag(Boolean institutionFlag) {
        this.institutionFlag = institutionFlag;
    }

    public Long getNetassetval() {
        return netassetval;
    }

    public void setNetassetval(Long netassetval) {
        this.netassetval = netassetval;
    }

    public Boolean getDirectsid() {
        return directsid;
    }

    public void setDirectsid(Boolean directsid) {
        this.directsid = directsid;
    }

    public String getFundSourceText() {
        return fundSourceText;
    }

    public void setFundSourceText(String fundSourceText) {
        this.fundSourceText = fundSourceText;
    }

    public Date getClientDocExpire() {
        return clientDocExpire;
    }

    public void setClientDocExpire(Date clientDocExpire) {
        this.clientDocExpire = clientDocExpire;
    }

    public Boolean getSinvestFlag() {
        return sinvestFlag;
    }

    public void setSinvestFlag(Boolean sinvestFlag) {
        this.sinvestFlag = sinvestFlag;
    }

    public Boolean getAvgpriceFlag() {
        return avgpriceFlag;
    }

    public void setAvgpriceFlag(Boolean avgpriceFlag) {
        this.avgpriceFlag = avgpriceFlag;
    }

    public Long getOccupationojk() {
        return occupationojk;
    }

    public void setOccupationojk(Long occupationojk) {
        this.occupationojk = occupationojk;
    }

    public String getOccupationojkText() {
        return occupationojkText;
    }

    public void setOccupationojkText(String occupationojkText) {
        this.occupationojkText = occupationojkText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientPropertyEntity that = (ClientPropertyEntity) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(interestAgrrement, that.interestAgrrement) && Objects.equals(standingInstruction, that.standingInstruction) && Objects.equals(expirePassport, that.expirePassport) && Objects.equals(expireKitas, that.expireKitas) && Objects.equals(kitas, that.kitas) && Objects.equals(bankCustody, that.bankCustody) && Objects.equals(bankAccNameInvestor, that.bankAccNameInvestor) && Objects.equals(bankAccNoInvestor, that.bankAccNoInvestor) && Objects.equals(bankNameInvestor, that.bankNameInvestor) && Objects.equals(bankBranchInvestor, that.bankBranchInvestor) && Objects.equals(modifiedDate, that.modifiedDate) && Objects.equals(modifiedBy, that.modifiedBy) && Objects.equals(reffCode, that.reffCode) && Objects.equals(fundSource, that.fundSource) && Objects.equals(maritalStatus, that.maritalStatus) && Objects.equals(heirRelation, that.heirRelation) && Objects.equals(heirName, that.heirName) && Objects.equals(spouseName, that.spouseName) && Objects.equals(incomePerNum, that.incomePerNum) && Objects.equals(investmentObjective, that.investmentObjective) && Objects.equals(natureOfBussines, that.natureOfBussines) && Objects.equals(confirmationModel, that.confirmationModel) && Objects.equals(investorCategory, that.investorCategory) && Objects.equals(middleName, that.middleName) && Objects.equals(lastName, that.lastName) && Objects.equals(regdateNpwp, that.regdateNpwp) && Objects.equals(country2, that.country2) && Objects.equals(contactPhone2, that.contactPhone2) && Objects.equals(contactEmail2, that.contactEmail2) && Objects.equals(contactFax2, that.contactFax2) && Objects.equals(educationalBackground, that.educationalBackground) && Objects.equals(occupation, that.occupation) && Objects.equals(occupationText, that.occupationText) && Objects.equals(bicCode, that.bicCode) && Objects.equals(bankCurrency, that.bankCurrency) && Objects.equals(bankCurrency2, that.bankCurrency2) && Objects.equals(bicCode2, that.bicCode2) && Objects.equals(bicCode3, that.bicCode3) && Objects.equals(bankName3, that.bankName3) && Objects.equals(bankAccountName3, that.bankAccountName3) && Objects.equals(bankAccountNo3, that.bankAccountNo3) && Objects.equals(bankCurrency3, that.bankCurrency3) && Objects.equals(motherName, that.motherName) && Objects.equals(optRdn, that.optRdn) && Objects.equals(companyCharacteristic, that.companyCharacteristic) && Objects.equals(companySiup, that.companySiup) && Objects.equals(companyExpireSiup, that.companyExpireSiup) && Objects.equals(articleOfAssociation, that.articleOfAssociation) && Objects.equals(businessCertNo, that.businessCertNo) && Objects.equals(authPosition1, that.authPosition1) && Objects.equals(firstName2, that.firstName2) && Objects.equals(middleName2, that.middleName2) && Objects.equals(lastName2, that.lastName2) && Objects.equals(authPosition2, that.authPosition2) && Objects.equals(cardId2, that.cardId2) && Objects.equals(expCardId2, that.expCardId2) && Objects.equals(npwp2, that.npwp2) && Objects.equals(regdateNpwp2, that.regdateNpwp2) && Objects.equals(passportId2, that.passportId2) && Objects.equals(expirePassport2, that.expirePassport2) && Objects.equals(kitas2, that.kitas2) && Objects.equals(expireKitas2, that.expireKitas2) && Objects.equals(firstName3, that.firstName3) && Objects.equals(middleName3, that.middleName3) && Objects.equals(lastName3, that.lastName3) && Objects.equals(authPosition3, that.authPosition3) && Objects.equals(cardId3, that.cardId3) && Objects.equals(expCardId3, that.expCardId3) && Objects.equals(npwp3, that.npwp3) && Objects.equals(regdateNpwp3, that.regdateNpwp3) && Objects.equals(passportId3, that.passportId3) && Objects.equals(expirePassport3, that.expirePassport3) && Objects.equals(kitas3, that.kitas3) && Objects.equals(expireKitas3, that.expireKitas3) && Objects.equals(firstName4, that.firstName4) && Objects.equals(middleName4, that.middleName4) && Objects.equals(lastName4, that.lastName4) && Objects.equals(authPosition4, that.authPosition4) && Objects.equals(cardId4, that.cardId4) && Objects.equals(expCardId4, that.expCardId4) && Objects.equals(npwp4, that.npwp4) && Objects.equals(regdateNpwp4, that.regdateNpwp4) && Objects.equals(passportId4, that.passportId4) && Objects.equals(expirePassport4, that.expirePassport4) && Objects.equals(kitas4, that.kitas4) && Objects.equals(expireKitas4, that.expireKitas4) && Objects.equals(latestYearAssets, that.latestYearAssets) && Objects.equals(last2YearAssets, that.last2YearAssets) && Objects.equals(last3YearAssets, that.last3YearAssets) && Objects.equals(latestYearProfit, that.latestYearProfit) && Objects.equals(last2YearProfit, that.last2YearProfit) && Objects.equals(last3YearProfit, that.last3YearProfit) && Objects.equals(notes, that.notes) && Objects.equals(religion, that.religion) && Objects.equals(assetowner, that.assetowner) && Objects.equals(receiptNpwp, that.receiptNpwp) && Objects.equals(institutionFlag, that.institutionFlag) && Objects.equals(netassetval, that.netassetval) && Objects.equals(directsid, that.directsid) && Objects.equals(fundSourceText, that.fundSourceText) && Objects.equals(clientDocExpire, that.clientDocExpire) && Objects.equals(sinvestFlag, that.sinvestFlag) && Objects.equals(avgpriceFlag, that.avgpriceFlag) && Objects.equals(occupationojk, that.occupationojk) && Objects.equals(occupationojkText, that.occupationojkText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, interestAgrrement, standingInstruction, expirePassport, expireKitas, kitas, bankCustody, bankAccNameInvestor, bankAccNoInvestor, bankNameInvestor, bankBranchInvestor, modifiedDate, modifiedBy, reffCode, fundSource, maritalStatus, heirRelation, heirName, spouseName, incomePerNum, investmentObjective, natureOfBussines, confirmationModel, investorCategory, middleName, lastName, regdateNpwp, country2, contactPhone2, contactEmail2, contactFax2, educationalBackground, occupation, occupationText, bicCode, bankCurrency, bankCurrency2, bicCode2, bicCode3, bankName3, bankAccountName3, bankAccountNo3, bankCurrency3, motherName, optRdn, companyCharacteristic, companySiup, companyExpireSiup, articleOfAssociation, businessCertNo, authPosition1, firstName2, middleName2, lastName2, authPosition2, cardId2, expCardId2, npwp2, regdateNpwp2, passportId2, expirePassport2, kitas2, expireKitas2, firstName3, middleName3, lastName3, authPosition3, cardId3, expCardId3, npwp3, regdateNpwp3, passportId3, expirePassport3, kitas3, expireKitas3, firstName4, middleName4, lastName4, authPosition4, cardId4, expCardId4, npwp4, regdateNpwp4, passportId4, expirePassport4, kitas4, expireKitas4, latestYearAssets, last2YearAssets, last3YearAssets, latestYearProfit, last2YearProfit, last3YearProfit, notes, religion, assetowner, receiptNpwp, institutionFlag, netassetval, directsid, fundSourceText, clientDocExpire, sinvestFlag, avgpriceFlag, occupationojk, occupationojkText);
    }
}
