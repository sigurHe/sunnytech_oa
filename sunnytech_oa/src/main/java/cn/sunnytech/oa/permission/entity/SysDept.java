package cn.sunnytech.oa.permission.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 权限:部门实体类
 */
@Getter
@Setter
@ToString
public class SysDept {

    private Integer id;
    private String name;
    private Integer subject;
    private String address;
    private Integer seq;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;

}
