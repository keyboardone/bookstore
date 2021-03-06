package cn.itcast.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.dao.OrderDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Order;
import cn.itcast.domain.OrderItem;
import cn.itcast.domain.User;
import cn.itcast.utils.JdbcUtils;

public class OrderDaoImpl implements OrderDao {

	public void add(Order o){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into orders(id,ordertime,state,price,user_id) values(?,?,?,?,?)";
			Object params[] = {o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()};
			runner.update(conn, sql, params);
			
			Set<OrderItem> set = o.getOrderitems();
			for(OrderItem item : set){
				sql = "insert into orderitem(id,quantity,price,book_id,order_id) values(?,?,?,?,?)";
				params = new Object[]{item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getId()};
				runner.update(conn, sql, params);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Order find(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			//找出订单的信息
			String sql = "select * from orders where id=?";
			//new 封装到Order对象中去
			Order order = (Order) runner.query(conn, sql, id, new BeanHandler(Order.class));
			
			//找出order中的每一个订单项
			sql = "select * from orderitem where order_id=?";
			//这里是查询多个订单项，所以用BeanListHandler，每一个数据进入OrderItem
			//返回一个list集合，这个list集合保存了订单里面一个个的orderitem订单项
			List<OrderItem> list = (List) runner.query(conn, sql, id, new BeanListHandler(OrderItem.class));
			//思考订单项代表了哪本书，现在要把书的信息找出来
			for(OrderItem item : list){
				//一对多的多表联查，找出每一个订单项代表的书
				sql = "select * from orderitem oi,book b where oi.id=? and b.id=oi.book_id";
				//这里传递的是订单项的id值，一个订单项对应一本书，将数据封装到Book对象中，
				//返回一个book对象，表示查询出来了订单项对应的书
				Book book = (Book) runner.query(conn, sql, item.getId(), new BeanHandler(Book.class));
				//把书的信息给item
				item.setBook(book);
			}
			//将list集合中包含的书的信息封装到Order对象中
			order.getOrderitems().addAll(list);
			
			
			//找出收货人的信息
			sql = "select * from orders o,user u where o.id=? and u.id=o.user_id";
			User user = (User) runner.query(conn, sql, id, new BeanHandler(User.class));
			//把用户信息分装到订单对象Order中
			order.setUser(user);
			
			return order;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * state:true: 已发货
	 * state:false: 未发货
	 */
	public List<Order> getAll(boolean state){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from orders where state=?";
			List<Order> list = (List<Order>) runner.query(conn, sql, state, new BeanListHandler(Order.class));
			//找出每个订单的订单人
			for(Order o : list){
				sql = "select * from orders o,user u where o.id=? and u.id=o.user_id";
				User user = (User) runner.query(conn, sql, o.getId(), new BeanHandler(User.class));
				o.setUser(user);
			}
			
			return list;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(String id,boolean state){
		try{
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "update orders set state=? where id=?";
			Object params[] = {state,id};
			runner.update(conn,sql,params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
















