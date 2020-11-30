package com.shanxi.coal.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrgBaseInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    private String id;
    @ExcelProperty(value = {"境内/境外"},index = 2)
    private String domain;
    @ExcelProperty(value = {"单位类型"},index = 3)
    private String unittype;
    @ExcelProperty(value = {"新增类型"},index = 4)
    private String newtype;
    @ExcelProperty(value = {"统一社会信用代码"},index = 1)
    private String creditcode;
    @ExcelProperty(value = {"单位名称"},index = 0)
    private String unitname;
    @ExcelIgnore
    private String unitcode;
    @ExcelProperty(value = {"单位简称"},index = 5)
    private String unitabbreviation;
    @ExcelProperty(value = {"英文全称"},index = 6)
    private String englishname;
    @ExcelProperty(value = {"英文简称"},index = 7)
    private String englishabbreviation;
    @ExcelIgnore
    private String organizationalbig;
    @ExcelIgnore
    private String organizationalmid;
    @ExcelIgnore
    private String organizationalbigsmal;
    @ExcelProperty(value = {"公司人数"},index = 8)
    private Integer numberpeople;
    @ExcelProperty(value = {"成立日期"},index = 9)
    private String establishmentdate;
    @ExcelProperty(value = {"币种"},index = 10)
    private String currency;
    @ExcelProperty(value = {"注册资本(单位：万)"},index = 11)
    private String capital;
    @ExcelProperty(value = {"是否上市"},index = 12)
    private String listed;
    @ExcelProperty(value = {"空壳公司类别"},index = 13)
    private String shelltype;
    @ExcelProperty(value = {"企业类型"},index = 14)
    private String enterprisetype;
    @ExcelProperty(value = {"法定代表人"},index = 15)
    private String legal;
    @ExcelProperty(value = {"官网"},index = 16)
    private String website;
    @ExcelProperty(value = {"联系电话"},index = 17)
    private String phone;
    @ExcelIgnore
    private String continent;
    @ExcelIgnore
    private String country;
    @ExcelIgnore
    private String province;
    @ExcelIgnore
    private String city;
    @ExcelIgnore
    private String county;
    @ExcelProperty(value = {"注册地址"},index = 18)
    private String address;
    @ExcelIgnore
    private String superiorholdingunit;
    @ExcelIgnore
    private Integer legallevel;
    //法人本层级，为上级法人-1，上级法人层级为空，则1级
    @ExcelIgnore
    private Integer llevel;
    @ExcelProperty(value = {"上级控股比例%"},index = 19)
    private Integer holdingratio;
    @ExcelIgnore
    private String superiormanagementunit;
    @ExcelIgnore
    private Integer managelevel;
    //管理本层级，为上管理人-1，上级管理人层级为空，则1级
    @ExcelIgnore
    private Integer mlevel;
    @ExcelProperty(value = {"所属行业"},index = 20)
    private String industry;
    @ExcelProperty(value = {"经营范围"},index = 21)
    private String businessscope;
    @ExcelProperty(value = {"经营规模"},index = 22)
    private String businessscale;
    @ExcelProperty(value = {"经营状态"},index = 23)
    private String businessstatus;
    @ExcelProperty(value = {"是否平台公司"},index = 24)
    private String isplatform;
    @ExcelProperty(value = {"是否纳入决算"},index = 25)
    private String finalaccounts;
    @ExcelProperty(value = {"经营期限自"},index = 26)
    private String operationstartdate;
    @ExcelProperty(value = {"经营期限至"},index = 27)
    private String operationenddate;
    @ExcelIgnore
    private String creationdate;
    @ExcelIgnore
    private String updatedate;
    @ExcelProperty(value = {"注销类型"},index = 28)
    private String cancellationtype;

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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency == null ? null : currency.trim();
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
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

    public String getCancellationtype() {
        return cancellationtype;
    }

    public void setCancellationtype(String cancellationtype) {
        this.cancellationtype = cancellationtype == null ? null : cancellationtype.trim();
    }

    public String getEstablishmentdate() {
        return establishmentdate;
    }

    public void setEstablishmentdate(String establishmentdate) {
        this.establishmentdate = establishmentdate;
    }

    public String getOperationstartdate() {
        return operationstartdate;
    }

    public void setOperationstartdate(String operationstartdate) {
        this.operationstartdate = operationstartdate;
    }

    public String getOperationenddate() {
        return operationenddate;
    }

    public void setOperationenddate(String operationenddate) {
        this.operationenddate = operationenddate;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getLlevel() {
        return llevel;
    }

    public void setLlevel(Integer llevel) {
        this.llevel = llevel;
    }

    public Integer getMlevel() {
        return mlevel;
    }

    public void setMlevel(Integer mlevel) {
        this.mlevel = mlevel;
    }
}