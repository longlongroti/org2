package com.shanxi.coal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.dao.OrgPersonnelMapper;
import com.shanxi.coal.dao.OrgStockMapper;
import com.shanxi.coal.domain.OrgBaseInfo;
import com.shanxi.coal.domain.OrgDict;
import com.shanxi.coal.domain.OrgPersonnel;
import com.shanxi.coal.domain.OrgStock;
import com.shanxi.coal.utils.MyUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/personnel")
public class OrgPersonnelController {

    @Resource
    OrgPersonnelMapper orgPersonnelMapper;
    @Resource
    OrgBaseInfoMapper orgBaseInfoMapper;
    @Resource
    OrgDictMapper orgDictMapper;

    @GetMapping("/go")
    public String go(@RequestParam("id") String id, Model model) {

        OrgBaseInfo orgBaseInfo = orgBaseInfoMapper.selectByPrimaryKey(id);
        model.addAttribute("orgBaseInfo", orgBaseInfo);

        return "org/personnel/list";
    }


    @PostMapping("/list")
    @ResponseBody
    public String list(@RequestParam("pageNumber") Integer pageNumber,
                       @RequestParam("pageSize") Integer pageSize,
                       @RequestParam("orgId") String orgId
                       ) throws ParseException {
        PageHelper.startPage(pageNumber, pageSize);
        OrgPersonnel where = new OrgPersonnel();
        where.setOrgId(orgId);
        List<OrgPersonnel> personnels = orgPersonnelMapper.list(where);
        PageInfo<OrgBaseInfo> pageInfo = new PageInfo(personnels);

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
        return "org/personnel/add";
    }


    @GetMapping("/goedit")
    public String goEdit(@PathParam("id") String id,HttpServletRequest request, Model model) {

        List<OrgDict> gdgbDict = orgDictMapper.findByName("股东国别");
        model.addAttribute("gdgbDict", gdgbDict);

        List<OrgDict> gdxzDict = orgDictMapper.findByName("股东性质");
        model.addAttribute("gdxzDict", gdxzDict);

        List<OrgDict> gdzzxsDict = orgDictMapper.findByName("股东组织形式");
        model.addAttribute("gdzzxsDict", gdzzxsDict);

        OrgPersonnel orgPersonnel = orgPersonnelMapper.selectByPrimaryKey(id);
        model.addAttribute("orgPersonnel", orgPersonnel);

        String orgId =  orgPersonnel.getOrgId();
        model.addAttribute("orgId",orgId);

        return "org/personnel/add";
    }

    @PostMapping("/do")
    @Transactional
    public String add(HttpServletRequest request, OrgPersonnel orgPersonnel) {
        if (orgPersonnel != null) {
            orgPersonnel.setId(UUID.randomUUID().toString());

            orgPersonnelMapper.insertSelective(orgPersonnel);
        }

        return "redirect:/personnel/go?id="+orgPersonnel.getOrgId();
    }

    @PutMapping("/do")
    @Transactional
    public String update(OrgPersonnel orgPersonnel) {
        orgPersonnelMapper.updateByPrimaryKeySelective(orgPersonnel);
        return "redirect:/personnel/go?id="+orgPersonnel.getOrgId();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") String id) {

        orgPersonnelMapper.deleteByPrimaryKey(id);
        return "ok";
    }

}
