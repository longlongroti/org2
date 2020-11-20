package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgPersonnel;

import java.util.List;

public interface OrgPersonnelMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgPersonnel record);

    int insertSelective(OrgPersonnel record);

    OrgPersonnel selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgPersonnel record);

    int updateByPrimaryKey(OrgPersonnel record);

    List<OrgPersonnel> list(OrgPersonnel record);
}