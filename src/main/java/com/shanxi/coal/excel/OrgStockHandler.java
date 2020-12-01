package com.shanxi.coal.excel;

import com.alibaba.excel.write.handler.SheetWriteHandler;
import com.alibaba.excel.write.metadata.holder.WriteSheetHolder;
import com.alibaba.excel.write.metadata.holder.WriteWorkbookHolder;
import org.apache.poi.ss.usermodel.DataValidation;
import org.apache.poi.ss.usermodel.DataValidationConstraint;
import org.apache.poi.ss.usermodel.DataValidationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.xssf.usermodel.XSSFDataValidation;

import java.util.HashMap;
import java.util.Map;

public class OrgStockHandler implements SheetWriteHandler {
    @Override
    public void beforeSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
    }

    @Override
    public void afterSheetCreate(WriteWorkbookHolder writeWorkbookHolder, WriteSheetHolder writeSheetHolder) {
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
        String [] p = new String[]{
                "阿拉伯联合酋长国（阿联酋）",
                "瓦利斯与富图纳（法）",
                "阿尔及利亚",
                "所罗门群岛",
                "马来西亚",
                "瓦努阿图",
                "圭亚那",
                "密克罗尼西亚",
                "委内瑞拉",
                "马绍尔群岛",
                "哥伦比亚",
                "帕劳",
                "摩洛哥",
                "瑙鲁",
                "埃塞俄比亚",
                "基里巴斯",
                "巴林",
                "图瓦卢",
                "沙特阿拉伯",
                "萨摩亚",
                "苏丹",
                "斐济群岛",
                "莱索托",
                "汤加",
                "南苏丹",
                "库克群岛（新）",
                "朝鲜",
                "关岛（美）",
                "巴拉圭",
                "新喀里多尼亚（法）",
                "蒙古",
                "法属波利尼西亚",
                "泰国",
                "皮特凯恩岛（英）",
                "缅甸",
                "希腊",
                "阿曼",
                "格林纳达",
                "柬埔寨",
                "海地",
                "也门",
                "美国",
                "格鲁吉亚",
                "加拿大",
                "乌拉圭",
                "墨西哥",
                "韩国",
                "危地马拉",
                "亚美尼亚",
                "伯利兹",
                "老挝",
                "萨尔瓦多",
                "阿塞拜疆",
                "洪都拉斯",
                "土耳其",
                "巴拿马",
                "塞浦路斯",
                "巴哈马",
                "日本",
                "古巴",
                "巴基斯坦",
                "牙买加",
                "秘鲁",
                "巴布亚新几内亚",
                "法属圭亚那",
                "多米尼加",
                "马达加斯加",
                "哥斯达黎加",
                "科摩罗",
                "圣基茨和尼维斯",
                "卡塔尔",
                "安提瓜和巴布达",
                "苏里南",
                "多米尼克",
                "厄瓜多尔",
                "圣卢西亚",
                "利比亚",
                "圣文森特和格林纳丁斯",
                "科威特",
                "巴巴多斯",
                "突尼斯",
                "澳大利亚",
                "玻利维亚",
                "新西兰",
                "巴西",
                "匈牙利",
                "埃及",
                "奥地利",
                "毛里求斯",
                "波兰",
                "越南",
                "阿尔巴尼亚",
                "智利",
                "特立尼达和多巴哥",
                "中国",
                "克罗地亚",
                "阿根廷",
                "斯洛文尼亚 ",
                "塔吉克斯坦",
                "塞尔维亚",
                "不丹",
                "乌克兰",
                "加纳",
                "斯洛伐克",
                "菲律宾",
                "俄罗斯",
                "科特迪瓦",
                "罗马尼亚",
                "利比里亚",
                "摩尔多瓦",
                "吉尔吉斯斯坦",
                "波兰",
                "赞比亚",
                "波黑",
                "塞拉利昂",
                "捷克",
                "多哥",
                "保加利亚",
                "佛得角",
                "黑山",
                "几内亚比绍",
                "白俄罗斯",
                "乌兹别克斯坦",
                "瑞典",
                "几内亚",
                "挪威",
                "安哥拉",
                "芬兰 ",
                "尼泊尔",
                "丹麦 ",
                "巴勒斯坦",
                "马其顿",
                "马尔代夫",
                "冰岛 ",
                "赤道几内亚",
                "马耳他",
                "加蓬",
                "保加利亚 ",
                "印度",
                "罗马尼亚",
                "喀麦隆",
                "摩纳哥",
                "刚果",
                "北马里亚纳（美）",
                "中非",
                "美属萨摩亚",
                "斯里兰卡",
                "捷克",
                "乍得",
                "纽埃（新）",
                "布基纳法索",
                "卢森堡",
                "尼日利亚",
                "比利时",
                "民主刚果",
                "荷兰",
                "尼日尔",
                "爱尔兰",
                "哈萨克斯坦",
                "托克劳（新）",
                "贝宁",
                "安道尔",
                "圣多美和普林西比",
                "葡萄牙",
                "孟加拉国",
                "西班牙",
                "纳米比亚",
                "意大利",
                "土库曼斯坦",
                "英国",
                "乌干达",
                "德国",
                "叙利亚",
                "法国",
                "约旦",
                "尼加拉瓜",
                "坦桑尼亚",
                "瑞士",
                "博茨瓦纳",
                "匈牙利",
                "肯尼亚",
                "列支敦士登",
                "文莱",
                "斯洛伐克",
                "卢旺达",
                "圣马力诺",
                "黎巴嫩",
                "梵蒂冈",
                "吉布提",
                "索马里",
                "以色列",
                "南非",
                "厄立特里亚",
                "斯威士兰",
                "毛里塔尼亚",
                "马里",
                "东帝汶",
                "印度尼西亚",
                "冈比亚",
                "阿富汗",
                "塞内加尔",
                "伊朗",
                "伊拉克",
                "津巴布韦",
                "马拉维",
                "莫桑比克",
                "塞舌尔",
                "布隆迪",
                "新加坡"
        };
        Map<Integer, String[]> mapDropDown = new HashMap<>();
        mapDropDown.put(2, j);
        mapDropDown.put(3, k);
        mapDropDown.put(5, p);
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
