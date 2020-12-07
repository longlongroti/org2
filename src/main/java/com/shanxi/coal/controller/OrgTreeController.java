package com.shanxi.coal.controller;

import com.shanxi.coal.dao.*;

import com.shanxi.coal.domain.OrgBaseInfo;
import com.shanxi.coal.domain.OrgDict;
import com.shanxi.coal.domain.SysOrg;
import com.shanxi.coal.utils.MyUtils;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/orgtree")
public class OrgTreeController {

    @Resource
    OrgBaseInfoMapper orgBaseInfoMapper;

    @GetMapping("/managrgo")
    public String go() {
        return "org/managetree/list";
    }

    @GetMapping("/legalgo")
    public String go2() {
        return "org/legaltree/list";
    }

    @GetMapping("/findTree")
    @ResponseBody
    public String findTree(HttpServletRequest request) {
        String json = getTreeJson();
        return json;
    }

    @GetMapping("/findTree2")
    @ResponseBody
    public String findTree2(HttpServletRequest request) {
        String json = getTreeJson2();
        return json;
    }

    private String getTreeJson() {
        List<OrgBaseInfo> baseInfoList = orgBaseInfoMapper.findRoot();
        if (baseInfoList == null) {
            return null;
        }
        List<OrgBaseInfo> dl = new ArrayList<>();
        for(OrgBaseInfo o:baseInfoList){
            o.setText(o.getUnitname());
            o.setNodes(dl);
        }

        return MyUtils.listToJson(baseInfoList);
    }

    private String getTreeJson2() {
        List<OrgBaseInfo> baseInfoList = orgBaseInfoMapper.findRoot2();
        if (baseInfoList == null) {
            return null;
        }
        List<OrgBaseInfo> dl = new ArrayList<>();
        for(OrgBaseInfo o:baseInfoList){
            o.setText(o.getUnitname());
            o.setNodes(dl);
        }

        return MyUtils.listToJson(baseInfoList);
    }

    @PostMapping("/getByParent")
    @ResponseBody
    public String list(@RequestParam("parentId") String parentId, HttpServletRequest request, HttpSession session, Model model) {
        List<OrgBaseInfo> baseInfoList = orgBaseInfoMapper.listOrgByParent(parentId);
        for (OrgBaseInfo baseInfo : baseInfoList) {
            List<OrgBaseInfo> dl = new ArrayList<>();
            baseInfo.setText(baseInfo.getUnitname());
            baseInfo.setNodes(dl);
        }
        return MyUtils.listToJson(baseInfoList);
    }

    @PostMapping("/getByParent2")
    @ResponseBody
    public String list2(@RequestParam("parentId") String parentId, HttpServletRequest request, HttpSession session, Model model) {
        List<OrgBaseInfo> baseInfoList = orgBaseInfoMapper.listOrgByParent2(parentId);
        for (OrgBaseInfo baseInfo : baseInfoList) {
            List<OrgBaseInfo> dl = new ArrayList<>();
            baseInfo.setText(baseInfo.getUnitname());
            baseInfo.setNodes(dl);
        }
        return MyUtils.listToJson(baseInfoList);
    }
}
