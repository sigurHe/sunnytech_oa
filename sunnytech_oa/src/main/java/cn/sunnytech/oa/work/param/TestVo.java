package cn.sunnytech.oa.work.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 校验测试类
 */
@Getter
@Setter
public class TestVo {

    @NotBlank
    private String msg;
    @NotNull
    @Max(value = 10,message = "id 不能大于10")
    @Min(value = 0,message = "id 至少大于等于0")
    private Integer id;
}
