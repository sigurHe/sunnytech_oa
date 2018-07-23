package cn.sunnytech.oa.permission.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 权限:用户实体类
 */
@Getter
@Setter
public class SysUser {

    private Integer id;
    private String sn;
    private String name;
    private String telephone;
    private String mail;
    private String password;
    private Integer deptId;
    private Integer status;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;

}
