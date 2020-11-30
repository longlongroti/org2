package com.shanxi.coal.controller;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;

import java.util.HashMap;
import java.util.Map;

public class BsicInfoHandler implements SheetWriteHandler {

    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
        String[] yesOrNo = new String[]{"是", "否"};//
        String[] a = new String[]{"境内", "境外"};//境内外
        String[] b = new String[]{"法人单位", "非法人单位"};//单位类型
        String[] c = new String[]{"其他",//企业类型
                "事业单位",
                "国有独资企业",
                "国有参股企业",
                "国有实际控制企业",
                "国有控股企业",
                "国有全资企业"};
        String[] d = new String[]{//币种
                "人民币",
                "港币",
                "美元",
                "加元",
                "日元",
                "欧元",
               };
        String[] e = new String[]{//新增类型
                "从国资委监管的其他国企处置而获得控股权",
                "从其他国有企业处置而获得控股权",
                "新设合并新设",
                "从其他国有企业产权置换而获得控股权",
                "解散分立新设",
                "从国资委监管的其他国企产权置换而获得控股权",
                "存续分立新设",
                "从其他国有企业无偿划入而获得控股权",
                "其他经济行为新设",
                "其他",
                "因收购或投资入股新设",
                "从国资委监管的其他国企无偿划入而获得控股权"
        };
        String[] f = new String[]{//注销类型
                "新设合并注销",
                "因被收购或股权转让注销",
                "无偿划出给国资委监管的其他国企而取消控股权",
                "无偿划出给其他国有企业而取消控股权",
                "产权置换给国资委监管的其他国企而取消控股权",
                "产权置换给其他国有企业而取消控股权",
                "处置给国资委监管的其他国企而取消控股权",
                "处置给其他国有企业而取消控股权",
                "吸收合并注销",
                "解散分立注销",
                "其他经济行为注销",
                "子改分",
                "破产清算",
                "工商注销",
                "其他",
                "误登注销"
        };
        String[] g = new String[]{//空壳公司类别
                "特殊目的公司",
                "历史遗留问题公司",
                "非空壳公司"
        };
        String[] h = new String[]{//经营状态
                "迁往市外",
                "迁入",
                "在业",
                "清算",
                "停业",
                "存续（在营、开业、在册）",
                "吊销企业",
                "吊销并注销",
                "吊销，已注销",
                "存续",
                "吊销，未注销",
                "在营（开业）企业",
                "吊销",
                "开业",
                "注销",
                "注销企业",
                "其他",
                "迁出"
        };
        String[] i = new String[]{//经营规模
                "微型",
                "小型",
                "中型",
                "大型"
        };
        String[] j = new String[]{//股东性质
                "本企业内其他企业",
                "本企业",
                "其他国有企业",
                "中方非国有企业",
                "外资企业",
                "外国政府",
                "国家行政机关",
                "境内自然人",
                "国资委"
        };
        String[] k = new String[]{//股东组织形式
                "本企业员工",
                "其他自然人",
                "社会团体",
                "事业单位",
                "外商",
                "民营",
                "集体",
                "国有实际控制",
                "国有控股",
                "国有独资",
                "政府及政府部门"
        };
        Map<Integer, String[]> mapDropDown = new HashMap<>();
        mapDropDown.put(2, a);
        mapDropDown.put(3, b);
        mapDropDown.put(4, e);
        mapDropDown.put(10, d);
        mapDropDown.put(12, yesOrNo);
        mapDropDown.put(13, g);
        mapDropDown.put(14, c);
        mapDropDown.put(22, i);
        mapDropDown.put(23, h);
        mapDropDown.put(24, yesOrNo);
        mapDropDown.put(25, yesOrNo);
        mapDropDown.put(28, f);
        Sheet sheet = writeSheetHolder.getSheet();
        ///开始设置下拉框
        DataValidationHelper helper = sheet.getDataValidationHelper();//设置下拉框
        for (Map.Entry<Integer, String[]> entry : mapDropDown.entrySet()) {
            /***起始行、终止行、起始列、终止列**/
            CellRangeAddressList addressList = new CellRangeAddressList(1, 1000, entry.getKey(), entry.getKey());
            /***设置下拉框数据**/
            DataValidationConstraint constraint = helper.createExplicitListConstraint(entry.getValue());
            DataValidation dataValidation = helper.createValidation(constraint, addressList);
            /***处理Excel兼容性问题**/
            if (dataValidation instanceof XSSFDataValidation) {
                dataValidation.setSuppressDropDownArrow(true);
                dataValidation.setShowErrorBox(true);
            } else {
                dataValidation.setSuppressDropDownArrow(false);
            }
            sheet.addValidationData(dataValidation);
        }
        //下面定时样式的
    }

}
