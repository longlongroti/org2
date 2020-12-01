package com.shanxi.coal.dao;

import com.shanxi.coal.domain.OrgDict;

import java.util.List;

public interface HomeMapper {
    Integer countByStatus(String dicvalue);

    int countAllCompany();

    int countCompanyByType(String type);

    int countCompanyByBond(String type);

    int countCompanyByListed(String type);
}