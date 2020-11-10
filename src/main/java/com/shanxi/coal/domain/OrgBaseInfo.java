package com.shanxi.coal.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrgBaseInfo implements Serializable {
    private String id;

    private String domain;

    private String unittype;

    private String newtype;

    private String creditcode;

    private String unitname;

    private String unitcode;

    private String unitabbreviation;

    private String englishname;

    private String englishabbreviation;

    private String organizationalbig;

    private String organizationalmid;

    private String organizationalbigsmal;

    private Integer numberpeople;

    private Date establishmentdate;

    private String currency;

    private BigDecimal capital;

    private String listed;

    private String shelltype;

    private String enterprisetype;

    private String legal;

    private String website;

    private String phone;

    private String continent;

    private String country;

    private String province;

    private String city;

    private String county;

    private String address;

    private String superiorholdingunit;

    private Integer legallevel;

    private Integer holdingratio;

    private String superiormanagementunit;

    private Integer managelevel;

    private String industry;

    private String businessscope;

    private String businessscale;

    private String businessstatus;

    private String isplatform;

    private String finalaccounts;

    private Date operationstartdate;

    private Date operationenddate;

    private Date creationdate;

    private Date updatedate;

    private String cancellationtype;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public String getUnittype() {
        return unittype;
    }

    public void setUnittype(String unittype) {
        this.unittype = unittype == null ? null : unittype.trim();
    }

    public String getNewtype() {
        return newtype;
    }

    public void setNewtype(String newtype) {
        this.newtype = newtype == null ? null : newtype.trim();
    }

    public String getCreditcode() {
        return creditcode;
    }

    public void setCreditcode(String creditcode) {
        this.creditcode = creditcode == null ? null : creditcode.trim();
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname == null ? null : unitname.trim();
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode == null ? null : unitcode.trim();
    }

    public String getUnitabbreviation() {
        return unitabbreviation;
    }

    public void setUnitabbreviation(String unitabbreviation) {
        this.unitabbreviation = unitabbreviation == null ? null : unitabbreviation.trim();
    }

    public String getEnglishname() {
        return englishname;
    }

    public void setEnglishname(String englishname) {
        this.englishname = englishname == null ? null : englishname.trim();
    }

    public String getEnglishabbreviation() {
        return englishabbreviation;
    }

    public void setEnglishabbreviation(String englishabbreviation) {
        this.englishabbreviation = englishabbreviation == null ? null : englishabbreviation.trim();
    }

    public String getOrganizationalbig() {
        return organizationalbig;
    }

    public void setOrganizationalbig(String organizationalbig) {
        this.organizationalbig = organizationalbig == null ? null : organizationalbig.trim();
    }

    public String getOrganizationalmid() {
        return organizationalmid;
    }

    public void setOrganizationalmid(String organizationalmid) {
        this.organizationalmid = organizationalmid == null ? null : organizationalmid.trim();
    }

    public String getOrganizationalbigsmal() {
        return organizationalbigsmal;
    }

    public void setOrganizationalbigsmal(String organizationalbigsmal) {
        this.organizationalbigsmal = organizationalbigsmal == null ? null : organizationalbigsmal.trim();
    }

    public Integer getNumberpeople() {
        return numberpeople;
    }

    public void setNumberpeople(Integer numberpeople) {
        this.numberpeople = numberpeople;
    }

    public Date getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(Date establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public String getListed() {
        return listed;
    }

    public void setListed(String listed) {
        this.listed = listed == null ? null : listed.trim();
    }

    public String getShelltype() {
        return shelltype;
    }

    public void setShelltype(String shelltype) {
        this.shelltype = shelltype == null ? null : shelltype.trim();
    }

    public String getEnterprisetype() {
        return enterprisetype;
    }

    public void setEnterprisetype(String enterprisetype) {
        this.enterprisetype = enterprisetype == null ? null : enterprisetype.trim();
    }

    public String getLegal() {
        return legal;
    }

    public void setLegal(String legal) {
        this.legal = legal == null ? null : legal.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent == null ? null : continent.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSuperiorholdingunit() {
        return superiorholdingunit;
    }

    public void setSuperiorholdingunit(String superiorholdingunit) {
        this.superiorholdingunit = superiorholdingunit == null ? null : superiorholdingunit.trim();
    }

    public Integer getLegallevel() {
        return legallevel;
    }

    public void setLegallevel(Integer legallevel) {
        this.legallevel = legallevel;
    }

    public Integer getHoldingratio() {
        return holdingratio;
    }

    public void setHoldingratio(Integer holdingratio) {
        this.holdingratio = holdingratio;
    }

    public String getSuperiormanagementunit() {
        return superiormanagementunit;
    }

    public void setSuperiormanagementunit(String superiormanagementunit) {
        this.superiormanagementunit = superiormanagementunit == null ? null : superiormanagementunit.trim();
    }

    public Integer getManagelevel() {
        return managelevel;
    }

    public void setManagelevel(Integer managelevel) {
        this.managelevel = managelevel;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry == null ? null : industry.trim();
    }

    public String getBusinessscope() {
        return businessscope;
    }

    public void setBusinessscope(String businessscope) {
        this.businessscope = businessscope == null ? null : businessscope.trim();
    }

    public String getBusinessscale() {
        return businessscale;
    }

    public void setBusinessscale(String businessscale) {
        this.businessscale = businessscale == null ? null : businessscale.trim();
    }

    public String getBusinessstatus() {
        return businessstatus;
    }

    public void setBusinessstatus(String businessstatus) {
        this.businessstatus = businessstatus == null ? null : businessstatus.trim();
    }

    public String getIsplatform() {
        return isplatform;
    }

    public void setIsplatform(String isplatform) {
        this.isplatform = isplatform == null ? null : isplatform.trim();
    }

    public String getFinalaccounts() {
        return finalaccounts;
    }

    public void setFinalaccounts(String finalaccounts) {
        this.finalaccounts = finalaccounts == null ? null : finalaccounts.trim();
    }

    public Date getOperationstartdate() {
        return operationstartdate;
    }

    public void setOperationstartdate(Date operationstartdate) {
        this.operationstartdate = operationstartdate;
    }

    public Date getOperationenddate() {
        return operationenddate;
    }

    public void setOperationenddate(Date operationenddate) {
        this.operationenddate = operationenddate;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public String getCancellationtype() {
        return cancellationtype;
    }

    public void setCancellationtype(String cancellationtype) {
        this.cancellationtype = cancellationtype == null ? null : cancellationtype.trim();
    }
}