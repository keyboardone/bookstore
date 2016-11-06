package cn.itcast.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
//将请求的数据封装到bean中
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try {
			//new 一个封装数据的bean
			T bean = beanClass.newInstance();
			//拿到一个map集合
			Map map = request.getParameterMap();
			//用beanutils框架往里填充
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
