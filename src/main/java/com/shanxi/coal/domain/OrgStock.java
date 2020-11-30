package com.shanxi.coal.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrgStock implements Serializable {
    @ExcelIgnore
    private String id;
    @ExcelProperty(value = {"股东名称"},index = 0)
    private String shareholdername;
    @ExcelProperty(value = {"股东国别"},index = 1)
    private String nationality;
    @ExcelProperty(value = {"股东性质"},index = 2)
    private String nature;
    @ExcelProperty(value = {"股东持股比例%"},index = 3)
    private String organization;
    @ExcelProperty(value = {"联系人姓名"},index = 4)
    private BigDecimal proportion;
    @ExcelIgnore
    private String orgId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getShareholdername() {
        return shareholdername;
    }

    public void setShareholdername(String shareholdername) {
        this.shareholdername = shareholdername == null ? null : shareholdername.trim();
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature == null ? null : nature.trim();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization == null ? null : organization.trim();
    }

    public BigDecimal getProportion() {
        return proportion;
    }

    public void setProportion(BigDecimal proportion) {
        this.proportion = proportion;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}