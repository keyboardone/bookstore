1.搭建环境
	1.1导开发包
		mysql驱动
		dbutils框架（简化jdbc编码）
		c3p0连接池（提高数据库的访问性能）
		beanutils（方便把数据封装到javabean中）
		log4j（与beanutils配合使用）
		commons fileupload（方便图片上传）
		commons io（方便图片上传）
		jstl开发包（el表达式）
		
	1.2创建组织程序的包
		cn.itcast.domain
		cn.itcast.dao
		cn.itcast.dao.impl
		cn.itcast.service
		cn.itcast.web.controller
		cn.itcast.utils
		cn.itcast.filter
		
		
		创建组织jsp的目录(分为前台和后台，不保护jsp):
		在WebContent下新建manager目录，保存后台相关的jsp
		1.在WebContent下新建manager.jsp页面，这个页面代表后台首页，这个页面是个分真页面，代码如下：
		<frameset rows="18%,*">
		 	<frame src="${pageContext.request.contextPath }/manager/head.jsp">
		 	<frameset  cols="15%,*">
		  		<frame src="${pageContext.request.contextPath }/manager/left.jsp" name="left">
		 		<frame src="#" name="right">
			</frameset>
		 </frameset>
		
		2.在WebContent下新建client目录，保存前台相关的jsp
	
	3.创建工程所需的库
		create database bookstore;
		use bookstore;
		
	4.创建一些全局的工具类和过滤器
		JdbcUtils（操作数据库）
		WebUtils（将前台获取到的数据封装到bean里面去）
		CharacterEncodingFilter（解决中文乱码问题）
		HtmlFilter（html代码转义）
		TransActionFilter（编写事物过滤器，统一管理事务）
		DaoFactory（产生dao，用于dao接口实现时）
		
		
		
		







































			