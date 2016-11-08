package cn.itcast.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import cn.itcast.dao.BookDao;
import cn.itcast.dao.CategoryDao;
import cn.itcast.dao.OrderDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.QueryResult;
import cn.itcast.domain.User;
import cn.itcast.factory.DaoFactory;
import cn.itcast.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {

	private CategoryDao cdao = DaoFactory.getInstance().createDao(CategoryDao.class);
	private BookDao bdao = DaoFactory.getInstance().createDao(BookDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao(OrderDao.class);
	private UserDao udao = DaoFactory.getInstance().createDao(UserDao.class);
	
	/**************************************
	 * 
	 * 分类相关的服务
	 * 
	 **************************************/
	public void addCategory(Category c){
		cdao.add(c);
	}
	
	public Category findCategory(String id){
		return cdao.find(id);
	}
	
	public List getAll(){
		return cdao.getAll();
	}
	
	/**************************************
	 * 
	 * 图书相关的服务
	 * 
	 **************************************/
	public void addBook(Book book){
		bdao.add(book);
	}
	
	public Book findBook(String id){
		return bdao.find(id);
	}
	
	public PageBean bookPageQuery(QueryInfo info){
		QueryResult result = bdao.pageQuery(info.getStartindex(), info.getPagesize(), info.getWhere(), info.getQueryvalue());
		
		//用QueryResult和QueryInfo生成一个页面显示需要的PageBean
		PageBean bean = new PageBean();
		bean.setCurrentpage(info.getCurrentPage());
		bean.setList(result.getList());
		bean.setPagesize(info.getPagesize());
		bean.setTotalrecord(result.getTotalrecord());
		
		return bean;
	}
	
	/**************************************
	 * 
	 * 用户相关的服务
	 * 
	 **************************************/
	public void addUser(User user){
		udao.add(user);
	}
	
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
	
	public User findUser(String id){
		return udao.find(id);
	}
	
	/**************************************
	 * 
	 * 订单相关的服务
	 * 
	 **************************************/
	//订单是根据用户的购物车来生成的，所以这里接受的是购物车对象和用户对象
	public void saveOrder(Cart cart,User user){
		Order order = new Order();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(cart.getPrice());
		order.setState(false);
		order.setUser(user);
		
		//定义一个集合，用于保存所有订单项
		Set oitems = new HashSet();
		//用购物车中的购物项生成订单项
		Set<Map.Entry<String, CartItem>> set = cart.getMap().entrySet();
		for(Map.Entry<String, CartItem> entry : set){
			CartItem citem = entry.getValue();		//得到每一个购物项
			OrderItem oitem = new OrderItem();		//对应的生成每一个订单项
			//用购物车中的购物项生成订单项
			oitem.setBook(citem.getBook());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			
			oitems.add(oitem);
		}
		
		//将oitems集合给order对象
		order.setOrderitems(oitems);
		odao.add(order);
	}
	
	//查询订单
	public Order findOrder(String id){
		return odao.find(id);
	}
	
	//得到所有订单
	public List getOrderByState(boolean state){
		return odao.getAll(state);
	}
	
}















