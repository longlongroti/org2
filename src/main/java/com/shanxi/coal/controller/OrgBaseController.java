package com.shanxi.coal.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.dao.SysLogMapper;
import com.shanxi.coal.domain.*;
import com.shanxi.coal.enums.AuditRoleEnum;
import com.shanxi.coal.utils.MyUtils;
import liquibase.util.MD5Util;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/orgbase")
public class OrgBaseController {

    @Resource
    OrgBaseInfoMapper orgBaseInfoMapper;

    @Resource
    OrgDictMapper orgDictMapper;

    @GetMapping("/go")
    public String go() {
        return "org/base/list";
    }

    @PostMapping("/list")
    @ResponseBody
    public String list(@RequestParam("pageNumber") Integer pageNumber,
                       @RequestParam("pageSize") Integer pageSize) throws ParseException {
        PageHelper.startPage(pageNumber, pageSize);
        OrgBaseInfo where = new OrgBaseInfo();
//      where.setUserName(StringUtils.isNotEmpty(name)?name:null);
        List<OrgBaseInfo> baseInfos =  orgBaseInfoMapper.list(where);

        PageInfo<OrgBaseInfo> pageInfo = new PageInfo(baseInfos);

        return MyUtils.pageInfoToJson(pageInfo);
    }

    @GetMapping("/goadd")
    public String goAdd( Model model) {

        List<OrgDict> jnwDict = orgDictMapper.findByName("境内外");
        model.addAttribute("jnwDict", jnwDict);

        List<OrgDict> dwlxDict = orgDictMapper.findByName("单位类型");
        model.addAttribute("dwlxDict", dwlxDict);

        List<OrgDict> xzlxDict = orgDictMapper.findByName("新增类型");
        model.addAttribute("xzlxDict", xzlxDict);

        List<OrgDict> zzxsDict = orgDictMapper.findByName("组织形式");
        model.addAttribute("zzxsDict", zzxsDict);

        List<OrgDict> bzDict = orgDictMapper.findByName("币种");
        model.addAttribute("bzDict", bzDict);

        List<OrgDict> sfssDict = orgDictMapper.findByName("是否上市");
        model.addAttribute("sfssDict", sfssDict);

        List<OrgDict> kkgslbDict = orgDictMapper.findByName("空壳公司类别");
        model.addAttribute("kkgslbDict", kkgslbDict);

        List<OrgDict> qylxDict = orgDictMapper.findByName("企业类型");
        model.addAttribute("qylxDict", qylxDict);

        List<OrgDict> ssdzDict = orgDictMapper.findByName("所属大洲");
        model.addAttribute("ssdzDict", ssdzDict);

        List<OrgDict> ssgjDict = orgDictMapper.findByName("所属国家");
        model.addAttribute("ssgjDict", ssgjDict);

        List<OrgDict> jwcsDict = orgDictMapper.findByName("境外城市");
        model.addAttribute("jwcsDict", jwcsDict);

        List<OrgDict> sshyDict = orgDictMapper.findByName("所属行业");
        model.addAttribute("sshyDict", sshyDict);

        List<OrgDict> jygmDict = orgDictMapper.findByName("经营规模");
        model.addAttribute("jygmDict", jygmDict);

        List<OrgDict> jyztDict = orgDictMapper.findByName("经营状态");
        model.addAttribute("jyztDict", jyztDict);

        List<OrgDict> sfptgsDict = orgDictMapper.findByName("是否平台公司");
        model.addAttribute("sfptgsDict", sfptgsDict);

        List<OrgDict> sfnrjsDict = orgDictMapper.findByName("是否纳入结算");
        model.addAttribute("sfnrjsDict", sfnrjsDict);

        List<OrgDict> zxlxDict = orgDictMapper.findByName("注销类型");
        model.addAttribute("zxlxDict", zxlxDict);

//        List<OrgDict> gdgbDict = orgDictMapper.findByName("股东国别");
//        model.addAttribute("gdgbDict", gdgbDict);

//        List<OrgDict> gdxzDict = orgDictMapper.findByName("股东性质");
//        model.addAttribute("gdxzDict", gdxzDict);
//
//        List<OrgDict> gdzzxsDict = orgDictMapper.findByName("股东组织形式");
//        model.addAttribute("gdzzxsDict", gdzzxsDict);
//
//        List<OrgDict> sffrdbDict = orgDictMapper.findByName("是否法定代表人");
//        model.addAttribute("sffrdbDict", sffrdbDict);

        return "org/base/add";
    }


    @GetMapping("/goedit")
    public String goEdit(@PathParam("id") String id, Model model) {

        List<OrgDict> jnwDict = orgDictMapper.findByName("境内外");
        model.addAttribute("jnwDict", jnwDict);

        List<OrgDict> dwlxDict = orgDictMapper.findByName("单位类型");
        model.addAttribute("dwlxDict", dwlxDict);

        List<OrgDict> xzlxDict = orgDictMapper.findByName("新增类型");
        model.addAttribute("xzlxDict", xzlxDict);

        List<OrgDict> zzxsDict = orgDictMapper.findByName("组织形式");
        model.addAttribute("zzxsDict", zzxsDict);

        List<OrgDict> bzDict = orgDictMapper.findByName("币种");
        model.addAttribute("bzDict", bzDict);

        List<OrgDict> sfssDict = orgDictMapper.findByName("是否上市");
        model.addAttribute("sfssDict", sfssDict);

        List<OrgDict> kkgslbDict = orgDictMapper.findByName("空壳公司类别");
        model.addAttribute("kkgslbDict", kkgslbDict);

        List<OrgDict> qylxDict = orgDictMapper.findByName("企业类型");
        model.addAttribute("qylxDict", qylxDict);

        List<OrgDict> ssdzDict = orgDictMapper.findByName("所属大洲");
        model.addAttribute("ssdzDict", ssdzDict);

        List<OrgDict> sshyDict = orgDictMapper.findByName("所属行业");
        model.addAttribute("sshyDict", sshyDict);

        List<OrgDict> jygmDict = orgDictMapper.findByName("经营规模");
        model.addAttribute("jygmDict", jygmDict);

        List<OrgDict> jyztDict = orgDictMapper.findByName("经营状态");
        model.addAttribute("jyztDict", jyztDict);

        List<OrgDict> sfptgsDict = orgDictMapper.findByName("是否平台公司");
        model.addAttribute("sfptgsDict", sfptgsDict);

        List<OrgDict> sfnrjsDict = orgDictMapper.findByName("是否纳入结算");
        model.addAttribute("sfnrjsDict", sfnrjsDict);

        List<OrgDict> zxlxDict = orgDictMapper.findByName("注销类型");
        model.addAttribute("zxlxDict", zxlxDict);

        OrgBaseInfo orgBaseInfo = orgBaseInfoMapper.selectByPrimaryKey(id);
        model.addAttribute("orgBaseInfo", orgBaseInfo);

        return "system/user/add";
    }

    @PostMapping("/do")
    @Transactional
    public String add(HttpServletRequest request, OrgBaseInfo orgBaseInfo) {


        if (orgBaseInfo != null) {
            orgBaseInfo.setId(UUID.randomUUID().toString());

            orgBaseInfoMapper.insertSelective(orgBaseInfo);

        }


        return "redirect:/orgbase/go";
    }


    @GetMapping("/findPid")
    @ResponseBody
    public String findPid(HttpServletRequest request,String id){

        String json = "";

        List<OrgDict> list = orgDictMapper.findByPid(id);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            json = objectMapper.writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }


    @GetMapping("/findTree")
    @ResponseBody
    public String findTree(HttpServletRequest request,@RequestParam(value = "dicvalue", required = false) String name){

        List<OrgDict> list = new ArrayList<>();

        if (StringUtils.isNotEmpty(name)) {
            OrgDict orgDict = new OrgDict();
            orgDict.setDicvalue(name);
            List<OrgDict> orgDicts = orgDictMapper.findByValue(orgDict);

            List<OrgDict> sysCodes1 = new ArrayList<>();
            for (OrgDict code : orgDicts) {
                List<OrgDict> dl = getParent(code.getId());
                sysCodes1.addAll(dl);
            }

            List<OrgDict> uniqueOrg = MyUtils.removeDuplicate(sysCodes1);
            list = buildTree(uniqueOrg);

        } else {
            OrgDict orgDict = orgDictMapper.findRoot();
            if (orgDict == null) {
                return null;
            }
            List<OrgDict> dl = new ArrayList<>();
            orgDict.setText(orgDict.getDicvalue());
            orgDict.setNodes(dl);
            list.add(orgDict);
        }

        return MyUtils.listToJson(list);
    }

    @PostMapping("/getByParent")
    @ResponseBody
    public String list(@RequestParam("parentId") String parentId, HttpServletRequest request, HttpSession session, Model model) {
        List<OrgDict> orgDicts = orgDictMapper.findByPid(parentId);
        for (OrgDict hy : orgDicts) {
            List<OrgDict> dl = new ArrayList<>();
            hy.setText(hy.getDicvalue());
            hy.setNodes(dl);
        }
        return MyUtils.listToJson(orgDicts);
    }

    public List<OrgDict> getParent(String id){
        List<OrgDict> dl = new ArrayList<>();
        OrgDict code = orgDictMapper.selectByPrimaryKey(id);
        if (code != null) {
            List<OrgDict> parent = getParent(code.getpId());
            dl.addAll(parent);
        }
        dl.add(code);
        return dl;
    }

    private List<OrgDict> buildTree(List<OrgDict> dl) {
        OrgDict parent = new OrgDict();
        List<OrgDict> list = new ArrayList<>();
        for (OrgDict sysCode : dl) {
            if (sysCode != null && sysCode.getpId().equals("0")) {
                List<OrgDict> dd = getChildren(sysCode.getId(), dl);
                parent.setId(sysCode.getId());
                parent.setText(sysCode.getDicvalue());
                parent.setNodes(dd);
                break;
            }
        }
        list.add(parent);
        return list;
    }

    private List<OrgDict> getChildren(String uuid, List<OrgDict> dl) {
        List<OrgDict> dll = new ArrayList<>();
        List<OrgDict> child = new ArrayList<>();
        for (OrgDict s : dl) {
            if (s != null && s.getpId().equals(uuid)) {
                child.add(s);
            }
        }
        for (OrgDict ss : child) {
            List<OrgDict> chls = getChildren(ss.getId(), dl);
            if (!chls.isEmpty()) {
                ss.setNodes(chls);
            }
            ss.setId(ss.getId());
            ss.setText(ss.getDicvalue());
            dll.add(ss);
        }
        return dll;
    }
}
