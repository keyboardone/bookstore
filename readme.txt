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
		
2.设计实体
	Category	（分类）
		private String id;
		private String name;
		private String description;
		
	Book	（书）
		private String id;
		private String name;
		private double price;
		private String author;
		private String image;	//记住书的图片的位置
		private String description;
		private Category category;
		
	Order	（订单）
		private String id;
		private Date ordertime;	//下单时间
		private boolean state;	//订单状态
		private double price;	//订单总价
		private User user;		//记住下单人
		private Set orderitems;	//记住订单所有订单项
	
	OrderItem	（订单项）
		private String id;
		private Book book;	//记住订单项代表的是哪本书
		private int quantity;	//记住订单项中的书出现了几本
		private double price;	//记录书的总价
		
	User	（订单属于的用户）
		private String id;
		private String username;
		private String password;
		private String cellphone;
		private String email;
		private String address;
		private int integral;	//积分
		
3.设计表
	create table category
	(
		id varchar(40) primary key,
		name varchar(40) not null unique,
		description varchar(255)
	);
	
	create table book
	(
		id varchar(40) primary key,
		name varchar(40) not null unique,
		price decimal(8,2) not null,
		author varchar(40) not null,
		image varchar(255) not null,
		description varchar(255),
		category_id varchar(40),
		constraint category_id_FK foreign key(category_id) references category(id)
	);	
	
	create table user
	(
		id varchar(40) primary key,
		username varchar(40) not null unique,
		password varchar(20) not null,
		cellphone varchar(20) not null,
		email varchar(40) not null,
		address varchar(255) not null
		integral int 
	);	
	
	create table orders
	(
		id varchar(40) primary key,
		ordertime datetime not null,
		state boolean not null,
		price decimal(8,2) not null,
		user_id varchar(40),
		constraint user_id_FK foreign key(user_id) references user(id)
	);
		
	create table orderitem
	(
		id varchar(40) primary key,
		quantity int not null,
		price decimal(8,2) not null,
		book_id varchar(40),
		constraint book_id_FK foreign key(book_id) references book(id),
		order_id varchar(40),
		constraint order_id_FK foreign key(order_id) references orders(id)
	);	
			

4.写dao

5.写service

6.做web层	
	






































			