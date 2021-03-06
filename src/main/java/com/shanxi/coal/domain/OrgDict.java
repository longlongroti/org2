package com.shanxi.coal.domain;

import java.io.Serializable;
import java.util.List;

public class OrgDict implements Serializable {
    private String id;

    private String dicname;

    private String dicvalue;

    private String pId;

    private String text;

    private List<OrgDict> nodes;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<OrgDict> getNodes() {
        return nodes;
    }

    public void setNodes(List<OrgDict> nodes) {
        this.nodes = nodes;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDicname() {
        return dicname;
    }

    public void setDicname(String dicname) {
        this.dicname = dicname == null ? null : dicname.trim();
    }

    public String getDicvalue() {
        return dicvalue;
    }

    public void setDicvalue(String dicvalue) {
        this.dicvalue = dicvalue == null ? null : dicvalue.trim();
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId == null ? null : pId.trim();
    }
}