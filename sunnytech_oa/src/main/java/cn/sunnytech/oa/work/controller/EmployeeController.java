package cn.sunnytech.oa.work.controller;

import cn.sunnytech.oa.global.beans.PageResult;
import cn.sunnytech.oa.global.common.JsonData;
import cn.sunnytech.oa.work.dto.SearchDept;
import cn.sunnytech.oa.work.dto.SearchEmployee;
import cn.sunnytech.oa.work.entity.Employee;
import cn.sunnytech.oa.work.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HeBin on 2018\6\17 0017.
 * 办公：员工控制层
 */
@Controller
@RequestMapping("/work/empl")
public class EmployeeController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/page.page")
    public String page(){
        return "empl_list";
    }
    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list(@RequestParam("pageIndex") String pageIndex){
        if(StringUtils.isEmpty(pageIndex)){
            //如果没有信息，则默认为第一页
            pageIndex = "1";
        }
        // Page PageInfo
        Page<Employee> page = PageHelper.startPage(Integer.parseInt(pageIndex),10);
        List<Employee> employees = employeeService.selectAll();
        if(CollectionUtils.isEmpty(employees)){
            employees = Lists.newArrayList();
        }
        PageInfo<Employee> pageInfo = page.toPageInfo();
        PageResult<Employee> pageResult = PageResult.<Employee>builder().pageInfo(pageInfo).data(employees).build();
        return JsonData.success(pageResult);
    }

    @RequestMapping("/query.json")
    @ResponseBody
    public JsonData query(@RequestParam("pageIndex") String pageIndex ,SearchEmployee param){
        if(StringUtils.isEmpty(pageIndex)){
            //如果没有信息，则默认为第一页
            pageIndex = "1";
        }
        // Page PageInfo
        Page<Employee> page = PageHelper.startPage(Integer.parseInt(pageIndex),10);
        List<Employee> employees = employeeService.query(param);
        System.out.println(employees);
        Collection
        if(CollectionUtils.isEmpty(employees)){
            employees = Lists.newArrayList();
        }
        PageInfo<Employee> pageInfo = page.toPageInfo();
        PageResult<Employee> pageResult = PageResult.<Employee>builder().pageInfo(pageInfo).data(employees).build();
        return JsonData.success(pageResult);
    }



}
