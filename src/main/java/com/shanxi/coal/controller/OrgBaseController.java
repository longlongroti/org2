package com.shanxi.coal.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.OrgBaseInfoMapper;
import com.shanxi.coal.dao.OrgDictMapper;
import com.shanxi.coal.dao.SysLogMapper;
import com.shanxi.coal.domain.*;
import com.shanxi.coal.enums.AuditRoleEnum;
import com.shanxi.coal.utils.MyUtils;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

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

        OrgBaseInfo orgBaseInfo = orgBaseInfoMapper.selectByPrimaryKey(id);
        model.addAttribute("orgBaseInfo", orgBaseInfo);

        return "system/user/add";
    }
}
