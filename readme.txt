1.�����
	1.1��������
		mysql����
		dbutils��ܣ���jdbc���룩
		c3p0���ӳأ�������ݿ�ķ������ܣ�
		beanutils����������ݷ�װ��javabean�У�
		log4j����beanutils���ʹ�ã�
		commons fileupload������ͼƬ�ϴ���
		commons io������ͼƬ�ϴ���
		jstl��������el���ʽ��
		
	1.2������֯����İ�
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.web.controller
		cn.itcast.utils
		cn.itcast.filter
		
		
		������֯jsp��Ŀ¼(��Ϊǰ̨�ͺ�̨��������jsp):
		��WebContent���½�managerĿ¼�������̨��ص�jsp
		1.��WebContent���½�manager.jspҳ�棬���ҳ������̨��ҳ�����ҳ���Ǹ�����ҳ�棬�������£�
		<frameset rows="18%,*">
		 	<frame src="${pageContext.request.contextPath }/manager/head.jsp">
		 	<frameset  cols="15%,*">
		  		<frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
		 		<frame src="#" name="right">
			</frameset>
		 </frameset>
		
		2.��WebContent���½�clientĿ¼������ǰ̨��ص�jsp
	
	3.������������Ŀ�
		create database bookstore;
		use bookstore;
		
	4.����һЩȫ�ֵĹ�����͹�����
		JdbcUtils���������ݿ⣩
		WebUtils����ǰ̨��ȡ�������ݷ�װ��bean����ȥ��
		CharacterEncodingFilter����������������⣩
		HtmlFilter��html����ת�壩
		TransActionFilter����д�����������ͳһ��������
		DaoFactory������dao������dao�ӿ�ʵ��ʱ��
		
		
		
		







































			