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
		
2.���ʵ��
	Category	�����ࣩ
		private String id;
		private String name;
		private String description;
		
	Book	���飩
		private String id;
		private String name;
		private double price;
		private String author;
		private String image;	//��ס���ͼƬ��λ��
		private String description;
		private Category category;
		
	Order	��������
		private String id;
		private Date ordertime;	//�µ�ʱ��
		private boolean state;	//����״̬
		private double price;	//�����ܼ�
		private User user;		//��ס�µ���
		private Set orderitems;	//��ס�������ж�����
	
	OrderItem	�������
		private String id;
		private Book book;	//��ס�������������ı���
		private int quantity;	//��ס�������е�������˼���
		private double price;	//��¼����ܼ�
		
	User	���������ڵ��û���
		private String id;
		private String username;
		private String password;
		private String cellphone;
		private String email;
		private String address;
		private int integral;	//����
		
3.��Ʊ�
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
			

4.дdao

5.дservice

6.��web��	
	






































			