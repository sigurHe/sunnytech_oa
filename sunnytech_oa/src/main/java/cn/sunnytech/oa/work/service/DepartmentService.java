package cn.sunnytech.oa.work.service;

import cn.sunnytech.oa.work.dto.SearchDept;
import cn.sunnytech.oa.work.entity.Department;
import cn.sunnytech.oa.work.param.DepartmentParam;

import java.util.List;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公：部门业务层接口
 */
public interface DepartmentService {

    List<Department> selectAll();
    List<Department> query(SearchDept param);
}
