package com.example.util;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtils {

    public static void CopyParamToBean(HttpServletRequest request, Object bean) {
        try {
            BeanUtils.populate(bean, request.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
