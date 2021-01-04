package com.shanxi.coal.domain;

import com.alibaba.excel.annotation.ExcelIgnore;

import javax.xml.bind.annotation.XmlElement;

public class MyXMLAdd {
    @ExcelIgnore
    private String remark;
    @ExcelIgnore
    private String source;
    @ExcelIgnore
    private String operType;

    public String getRemark() {
        return remark;
    }
    @XmlElement(name = "remark")
    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSource() {
        return source;
    }
    @XmlElement(name = "source")
    public void setSource(String source) {
        this.source = source;
    }

    public String getOperType() {
        return operType;
    }
    @XmlElement(name = "oper_type")
    public void setOperType(String operType) {
        this.operType = operType;
    }
}
