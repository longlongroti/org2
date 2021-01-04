package com.shanxi.coal.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shanxi.coal.dao.*;
import com.shanxi.coal.domain.*;
import com.shanxi.coal.excel.*;
import com.shanxi.coal.utils.MyUtils;
import liquibase.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/xml")
public class XmlController {

    @PostMapping("/send")
    @ResponseBody
    public String delete(@RequestParam("id") String id) throws JAXBException {
        OrgBaseInfo base = new OrgBaseInfo();
        base.setCreditcode( "cc" );
        base.setUnitname("asd");
        base.setRemark("");
        base.setSource("系统");
        base.setOperType("add");
        /* init jaxb marshaler */
        JAXBContext jaxbContext = JAXBContext.newInstance( OrgBaseInfo.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        /* set this flag to true to format the output */
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
        /* marshaling of java objects in xml (output to file and standard output) */
        jaxbMarshaller.marshal( base, new File( "country.xml"));
        jaxbMarshaller.marshal( base, System.out );
        return "ok";
    }

}
