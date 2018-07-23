package cn.sunnytech.oa.work.entity;

import lombok.*;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 办公:员工实体类
 */
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    private String sn;
    private String password;
    private String name;
    private Integer subject;
    private Integer deptId;
    private String telephone;
    private String mail;
    private String post;
    private Integer status;
    private String remark;
    private Department department;



}
