package cn.sunnytech.oa.work.service.impl;

import cn.sunnytech.oa.work.dao.DepartmentDao;
import cn.sunnytech.oa.work.dto.SearchDept;
import cn.sunnytech.oa.work.entity.Department;
import cn.sunnytech.oa.work.param.DepartmentParam;
import cn.sunnytech.oa.work.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公：部门业务层实现类
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    public List<Department> selectAll() {
        return departmentDao.selectAll();
    }

    public List<Department> query(SearchDept param) {
        Department department = Department.builder().subject(param.getSubject()).name("%"+param.getName().trim()+"%").build();
        return departmentDao.getBySelective(department);
    }
}
