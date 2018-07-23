package cn.sunnytech.oa.global.common;

import cn.sunnytech.oa.global.exception.ParamException;
import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 全局异常处理类，spring管理
 */
@Slf4j
public class SpringExceptionHandler implements HandlerExceptionResolver{


    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        //获取请求的url
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        //定义默认异常msg
        String defaultMsg = "System error";

        //判断请求url是.json还是.page结尾
        if(url.endsWith(".json")){
            if(ex instanceof ParamException){
                log.error("json ParamException,url:"+url,ex);
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            }else{
                log.error("unknow json Exception,url:"+url,ex);
                //设置JsonData
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){
            log.error("unknow page Exception,url"+url,ex);
            JsonData result = JsonData.fail(ex.getMessage());
            mv = new ModelAndView("exception",result.toMap());
        }
        //全局处理
        else {
            log.error("unknow Exception,url"+url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView",result.toMap());
        }
        return mv;
    }
}
