package com.shanxi.coal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.dao.OrgStockMapper;
import com.shanxi.coal.domain.OrgBaseInfo;
import com.shanxi.coal.domain.OrgDict;
import com.shanxi.coal.domain.OrgStock;
import com.shanxi.coal.utils.MyUtils;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/stock")
public class OrgStockController {

    @Resource
    OrgStockMapper orgStockMapper;
    @Resource
    OrgBaseInfoMapper orgBaseInfoMapper;
    @Resource
    OrgDictMapper orgDictMapper;

    @GetMapping("/go")
    public String go(@RequestParam("id") String id, Model model) {

        OrgBaseInfo orgBaseInfo = orgBaseInfoMapper.selectByPrimaryKey(id);
        model.addAttribute("orgBaseInfo", orgBaseInfo);

        return "org/stock/list";
    }


    @PostMapping("/list")
    @ResponseBody
    public String list(@RequestParam("pageNumber") Integer pageNumber,
                       @RequestParam("pageSize") Integer pageSize,
                       @RequestParam("orgId") String orgId
                       ) throws ParseException {
        PageHelper.startPage(pageNumber, pageSize);
        OrgStock where = new OrgStock();
        where.setOrgId(orgId);
        List<OrgStock> orgStocks = orgStockMapper.list(where);
        PageInfo<OrgBaseInfo> pageInfo = new PageInfo(orgStocks);

        return MyUtils.pageInfoToJson(pageInfo);
    }

    @GetMapping("/goadd")
    public String goAdd(HttpServletRequest request,Model model) {

        List<OrgDict> gdgbDict = orgDictMapper.findByName("股东国别");
        model.addAttribute("gdgbDict", gdgbDict);

        List<OrgDict> gdxzDict = orgDictMapper.findByName("股东性质");
        model.addAttribute("gdxzDict", gdxzDict);

        List<OrgDict> gdzzxsDict = orgDictMapper.findByName("股东组织形式");
        model.addAttribute("gdzzxsDict", gdzzxsDict);

        String orgId =  request.getParameter("orgId");
        model.addAttribute("orgId",orgId);
        return "org/stock/add";
    }


    @GetMapping("/goedit")
    public String goEdit(@PathParam("id") String id,HttpServletRequest request, Model model) {

        List<OrgDict> gdgbDict = orgDictMapper.findByName("股东国别");
        model.addAttribute("gdgbDict", gdgbDict);

        List<OrgDict> gdxzDict = orgDictMapper.findByName("股东性质");
        model.addAttribute("gdxzDict", gdxzDict);

        List<OrgDict> gdzzxsDict = orgDictMapper.findByName("股东组织形式");
        model.addAttribute("gdzzxsDict", gdzzxsDict);

        OrgStock orgStock = orgStockMapper.selectByPrimaryKey(id);
        model.addAttribute("orgStock", orgStock);

        String orgId =  orgStock.getOrgId();
        model.addAttribute("orgId",orgId);

        return "org/stock/add";
    }

    @PostMapping("/do")
    @Transactional
    public String add(HttpServletRequest request, OrgStock orgStock) {
        if (orgStock != null) {
            orgStock.setId(UUID.randomUUID().toString());

            orgStockMapper.insertSelective(orgStock);
        }

        return "redirect:/stock/go?id="+orgStock.getOrgId();
    }

    @PutMapping("/do")
    @Transactional
    public String update(OrgStock orgStock) {
        orgStockMapper.updateByPrimaryKeySelective(orgStock);
        return "redirect:/stock/go?id="+orgStock.getOrgId();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") String id) {

        orgStockMapper.deleteByPrimaryKey(id);
        return "ok";
    }

}
