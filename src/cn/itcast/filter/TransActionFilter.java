package cn.itcast.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.itcast.utils.JdbcUtils;

import com.sun.net.httpserver.Filter.Chain;

public class TransActionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//����ֻ���index���������Ӧ���������ز��������ݿ�
		try {
			//ֻҪ�����������������������ȡ���ӣ�Ȼ�������񣬲��ѵ�ǰ���Ӱ󶨵���ǰ�߳�����ȥ���Ժ�daoҪ�������ݿ�Ļ��������ҵ�ǰ�߳��õ����ӣ�
			//�����Ϳ��Ա�֤��һ������Χ�����еĲ�������һ�������������������������
			//Ӧ���ڵ���dao֮��������
			//JdbcUtils.StartTransaction();
			
			
			//����
			chain.doFilter(request, response);	//Ŀ����Դִ��
			
			//��ȡ��ǰ�߳��ϰ󶨵����ӣ��ύ���񣬲��ر����ӣ��ͷ������뵱ǰ�̵߳İ�
			//���˲�������JdbcUtilsȥ��
			//����Ľ�֮���൱������һ���ӳ٣���ֻ֤���ڵ�һ�η������ݿ��ʱ��ſ�������
			JdbcUtils.commitTransaction();
		} finally{
			JdbcUtils.closeConn();
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
