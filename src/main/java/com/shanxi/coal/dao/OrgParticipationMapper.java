package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgParticipation;

import java.util.List;

public interface OrgParticipationMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgParticipation record);

    int insertSelective(OrgParticipation record);

    OrgParticipation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgParticipation record);

    int updateByPrimaryKey(OrgParticipation record);

    List<OrgParticipation> list(OrgParticipation record);
}