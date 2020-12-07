package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgBaseInfo;

import java.util.List;

public interface OrgBaseInfoMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgBaseInfo record);

    int insertSelective(OrgBaseInfo record);

    OrgBaseInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgBaseInfo record);

    int updateByPrimaryKey(OrgBaseInfo record);

    List<OrgBaseInfo> list(OrgBaseInfo where);

    List<OrgBaseInfo> findRoot();

    List<OrgBaseInfo> listOrgByParent(String pid);
}