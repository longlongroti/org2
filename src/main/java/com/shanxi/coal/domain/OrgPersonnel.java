package com.shanxi.coal.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

import java.io.Serializable;

public class OrgPersonnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    private String id;
    @ColumnWidth(20)
    @ExcelProperty(value = {"联系人姓名"}, index = 1)
    private String contactsname;
    @ColumnWidth(20)
    @ExcelProperty(value = {"企业联系人电话"}, index = 2)
    private String contactsphone;
    @ColumnWidth(20)
    @ExcelProperty(value = {"邮箱"}, index = 3)
    private String email;
    @ColumnWidth(10)
    @ExcelProperty(value = {"是否法人代表"}, index = 4)
    private String islegal;
    @ColumnWidth(40)
    @ExcelProperty(value = {"企业唯一标识"}, index = 0)
    private String orgId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContactsname() {
        return contactsname;
    }

    public void setContactsname(String contactsname) {
        this.contactsname = contactsname == null ? null : contactsname.trim();
    }

    public String getContactsphone() {
        return contactsphone;
    }

    public void setContactsphone(String contactsphone) {
        this.contactsphone = contactsphone == null ? null : contactsphone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getIslegal() {
        return islegal;
    }

    public void setIslegal(String islegal) {
        this.islegal = islegal == null ? null : islegal.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}