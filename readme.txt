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
		
		
		创建组织jsp的目录(分为前台和后台，不保护jsp)
		在WebContent下新建manager目录，保存后台相关的jsp
		在WebContent下新建client目录，保存前台相关的jsp
				