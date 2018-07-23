package cn.sunnytech.oa.work.controller;

import cn.sunnytech.oa.global.common.JsonData;
import cn.sunnytech.oa.work.dto.SearchDept;
import cn.sunnytech.oa.work.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公：部门控制层
 */
@Controller
@RequestMapping("/work/dept")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    @RequestMapping("/page.page")
    public String page(){
        return "dept_list";
    }
    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list(){
        return JsonData.success(departmentService.selectAll());
    }

    @RequestMapping("/query.json")
    @ResponseBody
    public JsonData query(SearchDept param){
        return JsonData.success(departmentService.query(param));
    }


}
