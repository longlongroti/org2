package com.shanxi.coal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.dao.OrgParticipationMapper;
import com.shanxi.coal.dao.OrgStockMapper;
import com.shanxi.coal.domain.OrgBaseInfo;
import com.shanxi.coal.domain.OrgDict;
import com.shanxi.coal.domain.OrgParticipation;
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
@RequestMapping("/particip")
public class OrgParticiController {

    @Resource
    OrgParticipationMapper orgParticipationMapper;
    @Resource
    OrgBaseInfoMapper orgBaseInfoMapper;
    @Resource
    OrgDictMapper orgDictMapper;

    @GetMapping("/go")
    public String go(@RequestParam("id") String id, Model model) {

        OrgBaseInfo orgBaseInfo = orgBaseInfoMapper.selectByPrimaryKey(id);
        model.addAttribute("orgBaseInfo", orgBaseInfo);

        return "org/particip/list";
    }


    @PostMapping("/list")
    @ResponseBody
    public String list(@RequestParam("pageNumber") Integer pageNumber,
                       @RequestParam("pageSize") Integer pageSize,
                       @RequestParam("orgId") String orgId
                       ) throws ParseException {
        PageHelper.startPage(pageNumber, pageSize);
        OrgParticipation where = new OrgParticipation();
        where.setOrgId(orgId);
        List<OrgParticipation> orgParticipations = orgParticipationMapper.list(where);
        PageInfo<OrgParticipation> pageInfo = new PageInfo(orgParticipations);

        return MyUtils.pageInfoToJson(pageInfo);
    }

    @GetMapping("/goadd")
    public String goAdd(HttpServletRequest request,Model model) {

        String orgId =  request.getParameter("orgId");
        model.addAttribute("orgId",orgId);
        return "org/particip/add";
    }


    @GetMapping("/goedit")
    public String goEdit(@PathParam("id") String id,HttpServletRequest request, Model model) {


        OrgParticipation orgParticipation = orgParticipationMapper.selectByPrimaryKey(id);
        model.addAttribute("orgParticipation", orgParticipation);

        String orgId =  orgParticipation.getOrgId();
        model.addAttribute("orgId",orgId);

        return "org/particip/add";
    }

    @PostMapping("/do")
    @Transactional
    public String add(HttpServletRequest request, OrgParticipation orgParticipation) {
        if (orgParticipation != null) {
            orgParticipation.setId(UUID.randomUUID().toString());

            orgParticipationMapper.insertSelective(orgParticipation);
        }

        return "redirect:/particip/go?id="+orgParticipation.getOrgId();
    }

    @PutMapping("/do")
    @Transactional
    public String update(OrgParticipation orgParticipation) {
        orgParticipationMapper.updateByPrimaryKeySelective(orgParticipation);
        return "redirect:/particip/go?id="+orgParticipation.getOrgId();
    }

    @PostMapping("/delete")
    @ResponseBody
    public String delete(@RequestParam("id") String id) {

        orgParticipationMapper.deleteByPrimaryKey(id);
        return "ok";
    }

}
