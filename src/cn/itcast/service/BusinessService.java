package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.User;
//抽取接口的目的是将来做权限管理
public interface BusinessService {

	/**************************************
	 * 
	 * 分类相关的服务
	 * 
	 **************************************/
	void addCategory(Category c);

	Category findCategory(String id);

	List getAll();

	/**************************************
	 * 
	 * 图书相关的服务
	 * 
	 **************************************/
	void addBook(Book book);

	Book findBook(String id);

	PageBean bookPageQuery(QueryInfo info);

	/**************************************
	 * 
	 * 用户相关的服务
	 * 
	 **************************************/
	void addUser(User user);

	User findUser(String username, String password);

	User findUser(String id);

	/**************************************
	 * 
	 * 订单相关的服务
	 * 
	 **************************************/
	//订单是根据用户的购物车来生成的，所以这里接受的是购物车对象和用户对象
	void saveOrder(Cart cart, User user);

	//查询订单
	Order findOrder(String id);

	//得到所有订单
	List getOrderByState(boolean state);

}