package cn.sunnytech.oa.work.controller;

import cn.sunnytech.oa.global.common.JsonData;
import cn.sunnytech.oa.global.exception.ParamException;
import cn.sunnytech.oa.global.util.BeanValidator;
import cn.sunnytech.oa.work.param.TestVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2018\6\14 0014.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/demo")
    public String demo(){
        return "index";
    }
    @RequestMapping("/vo.json")
    @ResponseBody
    public JsonData testVo(TestVo testVo)throws ParamException
    {
        BeanValidator.check(testVo);
        return JsonData.success("test validator!");
    }
}
