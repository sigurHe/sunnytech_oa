package cn.sunnytech.oa.work.dao;

import cn.sunnytech.oa.work.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by HeBin on 2018\6\15 0015.
 * 办公：员工持久层接口
 */
@Repository
public interface EmployeeDao {

    void insert(Employee employee);
    void insertSelective(Employee employee);
    void updateBySnSelective(Employee employee);
    void delete(Integer id);
    Employee select(Integer id);
    List<Employee> selectAll();

    Employee selectByKeyword(@Param("keyword") String keyword);

    List<Employee> getBySelective(Employee employee);
}
