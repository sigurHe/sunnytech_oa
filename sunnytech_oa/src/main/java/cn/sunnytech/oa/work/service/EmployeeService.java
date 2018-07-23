package cn.sunnytech.oa.work.service;

import cn.sunnytech.oa.work.dto.SearchEmployee;
import cn.sunnytech.oa.work.entity.Employee;
import cn.sunnytech.oa.work.param.EmployeeParam;

import java.util.List;

/**
 * Created by HeBin on 2018\6\17 0017.
 * 办公：员工业务层接口
 */
public interface EmployeeService {

    void insert(EmployeeParam param);
    void insertSelective(EmployeeParam param);
    void updateBySnSelective(EmployeeParam param);
    void delete(Integer id);
    Employee select(Integer id);
    List<Employee> selectAll();

    Employee selectByKeyword(String keyword);

    List<Employee> query(SearchEmployee param);
}
