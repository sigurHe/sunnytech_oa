package cn.sunnytech.oa.global.util;

import cn.sunnytech.oa.global.exception.ParamException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * Created by HeBin on 2018\6\14 0014.
 * 参数校验工具
 */
public class BeanValidator {
    //全局校验工厂
    private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
    //单个类校验
    public static <T> Map<String,String> validate(T t,Class...groups){
        Validator validator = validatorFactory.getValidator();
        //校验结果，调用validate方法,得到校验结果
        Set validateResult = validator.validate(t,groups);

        if(validateResult.isEmpty()){
            //没有校验结果，返回空集合
            return Collections.emptyMap();
        }else{
            //其实就是声明了一个LinkedHashMap对象
            LinkedHashMap errors = Maps.newLinkedHashMap();
            Iterator iterator = validateResult.iterator();
            while(iterator.hasNext()){
                //validateResult中是ConstraintViolation对象
                ConstraintViolation violation =
                        (ConstraintViolation) iterator.next();
                errors.put(violation.getPropertyPath().toString()
                        ,violation.getMessage());
            }
            return errors;
        }
    }

    //list，多个类
    public static Map<String,String> validateList(Collection<?> collection){
        //校验是否为空
        Preconditions.checkNotNull(collection);
        //遍历
        Iterator iterator = collection.iterator();
        Map errors;
        do{
            if(!iterator.hasNext()){
                return Collections.emptyMap();
            }
            Object object = iterator.next();
            errors = validate(object,new Class[0]);
        }while (errors.isEmpty());
        return errors;

    }
    //包装前面两个方法
    public static Map<String,String> validateObject(Object first,Object...objects){
        if(objects != null && objects.length>0){
            return validateList(Lists.asList(first,objects));
        }else{
            return validate(first,new Class[0]);
        }
    }

    public static void check(Object param) throws ParamException {
        Map<String,String> map = validateObject(param);
        if(MapUtils.isNotEmpty(map)){
            throw new ParamException(map.toString());
        }
    }


}
