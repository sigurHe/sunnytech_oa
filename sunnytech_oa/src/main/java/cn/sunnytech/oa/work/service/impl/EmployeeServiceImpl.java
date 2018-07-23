package cn.sunnytech.oa.work.service.impl;

import cn.sunnytech.oa.work.dao.EmployeeDao;
import cn.sunnytech.oa.work.dto.SearchEmployee;
import cn.sunnytech.oa.work.entity.Employee;
import cn.sunnytech.oa.work.param.EmployeeParam;
import cn.sunnytech.oa.work.service.EmployeeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HeBin on 2018\6\17 0017.
 * 办公：员工业务层实现类
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

    @Resource
    private EmployeeDao employeeDao;

    public void insert(EmployeeParam param) {
    }

    public void insertSelective(EmployeeParam param) {

    }

    public void updateBySnSelective(EmployeeParam param) {

    }

    public void delete(Integer id) {

    }

    public Employee select(Integer id) {
        return null;
    }

    public List<Employee> selectAll() {
        return employeeDao.selectAll();
    }

    public Employee selectByKeyword(String keyword) {
        return employeeDao.selectByKeyword(keyword);
    }

    @Override
    public List<Employee> query(SearchEmployee param) {
        Employee employee = Employee.builder().deptId(param.getDeptId()).name("%"+param.getName()+"%").subject(param.getSubject()).build();
        return employeeDao.getBySelective(employee);
    }
}
