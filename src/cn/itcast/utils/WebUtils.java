package cn.itcast.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {
//����������ݷ�װ��bean��
	public static <T> T request2Bean(HttpServletRequest request,Class<T> beanClass){
		try {
			//new һ����װ���ݵ�bean
			T bean = beanClass.newInstance();
			//�õ�һ��map����
			Map map = request.getParameterMap();
			//��beanutils����������
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
