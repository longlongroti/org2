package com.shanxi.coal.controller;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.CellExtra;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.domain.OrgBaseInfo;
import liquibase.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class BasicInfoListener extends AnalysisEventListener<OrgBaseInfo> {
    private static final int BATCH_COUNT = 5;
    OrgBaseInfoMapper orgBaseInfoMapper = null;
    List<OrgBaseInfo> list = new ArrayList<OrgBaseInfo>();

    public BasicInfoListener(OrgBaseInfoMapper orgBaseInfoMapper) {
        this.orgBaseInfoMapper = orgBaseInfoMapper;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(OrgBaseInfo orgBaseInfo, AnalysisContext analysisContext) {
        list.add(orgBaseInfo);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        for (OrgBaseInfo orgBaseInfo : list) {
            if (StringUtils.isEmpty(orgBaseInfo.getId())) {
                orgBaseInfo.setId(UUID.randomUUID().toString());
                orgBaseInfoMapper.insertSelective(orgBaseInfo);
            } else {
                orgBaseInfoMapper.updateByPrimaryKeySelective(orgBaseInfo);
            }
        }
    }
}
