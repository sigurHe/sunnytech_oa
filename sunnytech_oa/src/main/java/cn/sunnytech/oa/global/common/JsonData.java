package cn.sunnytech.oa.global.common;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by HeBin on 2018\6\14 0014.
 * Json请求返回的类,
 * 如果是json返回，返回值是JsonData
 */
@Getter
@Setter
public class JsonData {
    //返回结果
    private boolean ret;
    //返回异常时的异常信息
    private String msg;
    //返回的数据
    private Object data;

    public JsonData(boolean ret){
        this.ret = ret;
    }
    //返回 成功处理,有数据及信息
    public static JsonData success(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.msg = msg;
        jsonData.data = object;
        return jsonData;
    }
    //返回 成功处理,有数据
    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }
    //返回 成功处理，无参
    public static JsonData success(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }
    //返回 失败处理
    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }
    //将三个数据存入一个map集合并返回
    public Map<String,Object> toMap(){
        Map<String,Object> result = Maps.newHashMap();
        result.put("ret",ret);
        result.put("msg",ret);
        result.put("data",data);
        return result;

    }



}
