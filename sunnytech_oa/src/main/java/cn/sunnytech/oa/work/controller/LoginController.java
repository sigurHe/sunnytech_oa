package cn.sunnytech.oa.work.controller;

import cn.sunnytech.oa.global.common.JsonData;
import cn.sunnytech.oa.work.entity.Employee;
import cn.sunnytech.oa.work.service.EmployeeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HeBin on 2018\6\18 0018.
 * 登录控制器
 */
@Controller
public class LoginController {

    @Resource
    private EmployeeService employeeService;

    @RequestMapping("/login.page")
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Employee employee = employeeService.selectByKeyword(username);
        System.out.println(employee);
        String errorMsg = "";
        String path = "login.jsp";
        String ret = request.getParameter("ret");//跳转链接
        //判断输入的用户名是否存在
        if(employee == null){
            errorMsg = "工号/邮箱/手机号不存在";
        }
        else if(!employee.getPassword().equals(password)){
            errorMsg = "用户名或密码错误";
        }
        //判断当前员工状态
        else if(employee.getStatus() == 0){
            errorMsg = "您无权限登录，请联系管理员";
        }
        else{
            request.getSession().setAttribute("employee",employee);
            request.getSession().setAttribute("USER",employee);
            if(!StringUtils.isBlank(ret)){
                response.sendRedirect(ret);
            }else{

                response.sendRedirect("/work/dept/page.page");
            }
            return;
        }
        request.setAttribute("errorMsg",errorMsg);
        request.getRequestDispatcher(path).forward(request,response);
    }
}
