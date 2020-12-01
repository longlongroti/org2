package com.shanxi.coal.controller;

import com.shanxi.coal.dao.HomeMapper;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.domain.OrgDict;
import com.shanxi.coal.utils.MyUtils;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    OrgDictMapper orgDictMapper;
    @Resource
    HomeMapper homeMapper;

    @PostMapping("/count")
    @ResponseBody
    public String countMemoryUsage() {
        List<OrgDict> jyztDict = orgDictMapper.findByName("经营状态");
        Map<String, Object> map = new HashMap<String, Object>();
        List<String> legend = new ArrayList<>();
        List<Object> seriesData = new ArrayList<>();
        Map<String, Boolean> selected = new HashMap<>();
        for (OrgDict orgDict : jyztDict) {
            Map<String, Object> seriesData2 = new HashMap<>();
            legend.add(orgDict.getDicvalue());
            Integer a = homeMapper.countByStatus(orgDict.getDicvalue());
            seriesData2.put("name", orgDict.getDicvalue());
            seriesData2.put("value", a);
            seriesData.add(seriesData2);
            selected.put(orgDict.getDicvalue(), a > 0);

        }
        map.put("legendData", legend);
        map.put("seriesData", seriesData);
        map.put("selected", selected);
        return MyUtils.objectToJson(map);
    }

    @PostMapping("/counttotal")
    @ResponseBody
    public String countTotal() {
        int a = homeMapper.countAllCompany();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("ab", a);
        int ba = homeMapper.countCompanyByType("法人单位");
        int bb = homeMapper.countCompanyByType("非法人单位");
        map.put("ba", ba);
        map.put("bb", bb);
        int da = homeMapper.countCompanyByBond("境内");
        int dd = homeMapper.countCompanyByBond("境外");
        map.put("da", da);
        map.put("db", dd);
        int ca = homeMapper.countCompanyByListed("是");
        int cb = homeMapper.countCompanyByListed("否");
        map.put("ca", ca);
        map.put("cb", cb);
        return MyUtils.objectToJson(map);
    }

}
