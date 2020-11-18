package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgDict;

import java.util.List;

public interface OrgDictMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgDict record);

    int insertSelective(OrgDict record);

    OrgDict selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgDict record);

    int updateByPrimaryKey(OrgDict record);

    List<OrgDict> findByName(String name);

    List<OrgDict> findByPid(String pid);

    OrgDict findRoot();

    List<OrgDict> findByValue(OrgDict record);
}