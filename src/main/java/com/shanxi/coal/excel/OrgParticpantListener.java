package com.shanxi.coal.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgParticipationMapper;
import com.shanxi.coal.domain.OrgBaseInfo;
import com.shanxi.coal.domain.OrgParticipation;
import liquibase.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrgParticpantListener extends AnalysisEventListener<OrgParticipation> {
    private static final int BATCH_COUNT = 5;
    OrgParticipationMapper orgParticipationMapper = null;
    List<OrgParticipation> list = new ArrayList<OrgParticipation>();

    public OrgParticpantListener(OrgParticipationMapper orgParticipationMapper) {
        this.orgParticipationMapper = orgParticipationMapper;
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(OrgParticipation orgParticipation, AnalysisContext analysisContext) {
        list.add(orgParticipation);
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
        for (OrgParticipation orgParticipation : list) {
            if (StringUtils.isEmpty(orgParticipation.getId())) {
                orgParticipation.setId(UUID.randomUUID().toString());
                orgParticipationMapper.insertSelective(orgParticipation);
            } else {
                orgParticipationMapper.updateByPrimaryKeySelective(orgParticipation);
            }
        }
    }
}
