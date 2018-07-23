package cn.sunnytech.oa.work.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by HeBin on 2018\6\17 0017.
 */
@Getter
@Setter
@ToString
public class EmployeeParam {


    private String sn;

    @NotBlank(message = "员工名字不可以为空")
    @Length(min = 1,max = 20,message = "员工名字长度需要在20个字以内")
    private String name;

    @NotNull(message = "必须提供用户所在的部门隶属")
    private Integer subject;

    @NotNull(message = "必须提供用户所在的部门")
    private Integer deptId;

    @NotBlank(message = "电话不能为空")
    @Length(min = 1,max = 13,message = "电话长度需要在13个字以内")
    private String telephone;

    @NotBlank(message = "邮箱不能为空")
    @Length(min = 5,max = 50,message = "邮箱长度需要在50个字以内")
    private String mail;

    @NotBlank(message = "员工职位不能为空")
    @Length(min = 1,max = 20,message = "职位长度需要在20个字以内")
    private String post;

    @NotNull(message = "必须指定员工的状态")
    @Min(value = 0,message = "员工状态不合法")
    @Max(value = 1,message = "员工状态不合法")
    private Integer status;

    @Length(min = 0,max = 200,message = "备注长度需要在200个字以内")
    private String remark;



}
