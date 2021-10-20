package com.example.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class WebUtils {

    public static <T> T CopyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static int parserInt(String number,int default_value){
        if (number == null){
            return default_value;
        }
        try{
            return Integer.parseInt(number);
        }catch (Exception e){
            e.printStackTrace();
        }
        return default_value;
    }


}
