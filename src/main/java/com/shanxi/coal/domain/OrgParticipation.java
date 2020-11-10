package com.shanxi.coal.domain;

import java.io.Serializable;

public class OrgParticipation implements Serializable {
    private String id;

    private String enterprisename;

    private String enterprisetype;

    private String region;

    private Float shareholding;

    private String orgId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEnterprisename() {
        return enterprisename;
    }

    public void setEnterprisename(String enterprisename) {
        this.enterprisename = enterprisename == null ? null : enterprisename.trim();
    }

    public String getEnterprisetype() {
        return enterprisetype;
    }

    public void setEnterprisetype(String enterprisetype) {
        this.enterprisetype = enterprisetype == null ? null : enterprisetype.trim();
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public Float getShareholding() {
        return shareholding;
    }

    public void setShareholding(Float shareholding) {
        this.shareholding = shareholding;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
    }
}