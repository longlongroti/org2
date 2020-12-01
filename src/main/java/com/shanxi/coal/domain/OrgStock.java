package com.shanxi.coal.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.io.Serializable;
import java.math.BigDecimal;

public class OrgStock implements Serializable {
    private static final long serialVersionUID = 1L;
    @ColumnWidth(40)
    @ExcelProperty(value = {"id"}, index = 6)
    private String id;
    @ColumnWidth(20)
    @ExcelProperty(value = {"股东名称"}, index = 1)
    private String shareholdername;
    @ColumnWidth(20)
    @ExcelProperty(value = {"股东国别"}, index = 5)
    private String nationality;
    @ColumnWidth(20)
    @ExcelProperty(value = {"股东性质"}, index = 2)
    private String nature;
    @ColumnWidth(10)
    @ExcelProperty(value = {"组织形式"}, index = 3)
    private String organization;
    @ColumnWidth(20)
    @ExcelProperty(value = {"股东持股比例%"}, index = 4)
    private BigDecimal proportion;
    @ColumnWidth(40)
    @ExcelProperty(value = {"企业唯一标识"}, index = 0)
    private String orgId;

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