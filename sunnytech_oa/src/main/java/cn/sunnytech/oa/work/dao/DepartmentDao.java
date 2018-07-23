package cn.sunnytech.oa.work.dao;

import cn.sunnytech.oa.work.entity.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公：部门持久层接口
 */
@Repository
public interface DepartmentDao {

    List<Department> selectAll();
    List<Department> getBySelective(Department department);
}
