package cn.sunnytech.oa.global.common;

import cn.sunnytech.oa.global.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * HTTP请求前后监听器
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    //处理前调用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request start.  url:{}，params:{}",url, JsonMapper.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute("ST",start);
        return true;

    }
    //处理后调用
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        long start = (long) request.getAttribute("ST");
        long end = System.currentTimeMillis();

        log.info("request finished.  url:{}，cost{}",url, end-start);
        //移除当前进程所有信息
        //removeThreadLocalInfo();
    }
    //任何情况最后调用
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        String url = request.getRequestURL().toString();
        Map parameterMap = request.getParameterMap();
        log.info("request completed.  url:{}，params:{}",url, JsonMapper.obj2String(parameterMap));
        //移除当前进程所有信息
        //removeThreadLocalInfo();
    }
/*
    public void removeThreadLocalInfo(){
        RequestHolder.remove();
    }*/
}
