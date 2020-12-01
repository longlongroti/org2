package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgStockMapper {
    int deleteByPrimaryKey(String id);

    int insert(OrgStock record);

    int insertSelective(OrgStock record);

    OrgStock selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(OrgStock record);

    int updateByPrimaryKey(OrgStock record);

    List<OrgStock> list(String orgId);

    List<OrgStock> listAll();

}