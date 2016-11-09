package junit.test;

import org.junit.Test;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.domain.Category;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.User;
import cn.itcast.service.impl.BusinessServiceImpl;
import cn.itcast.utils.JdbcUtils;

public class BusinessServiceTest {

	private BusinessServiceImpl service = new BusinessServiceImpl();
	@Test
	public void testAddCategory(){
		Category c = new Category();
		c.setId("1");
		c.setName("java开发");
		c.setDescription("java");
		
		service.addCategory(c);
		
		JdbcUtils.commitTransaction();
	}
	
	@Test
	public void testFindCategory(){
		service.findCategory("1");
	}
	
	@Test
	public void testGetAllCategory(){
		service.getAllCategory();
	}
	
	@Test
	public void testAddBook(){
		Category c = new Category();
		c.setId("1");
		c.setName("java开发");
		c.setDescription("java");
		
		Book book = new Book();
		book.setAuthor("任冰");
		book.setCategory(c);
		book.setDescription("hhaha");
		book.setId("2341341");
		book.setImage("223");
		book.setName("javaweb开发");
		book.setPrice(89);
		
		service.addBook(book);
		JdbcUtils.commitTransaction();
	}
	
	@Test
	public void testFindBook(){
		//没必要找category，显示书的时候没有必要显示分类
		service.findBook("2341341");
	}
	
	@Test
	public void testPageQuery(){
		QueryInfo  info = new QueryInfo();
		info.setCurrentPage(1);
		info.setPagesize(3);
//		info.setQueryname("category_id");
//		info.setQueryvalue("1");
		
		PageBean bean = service.bookPageQuery(info);
		System.out.println(bean);
	}
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setAddress("神殿");
		user.setCellphone("1803517");
		user.setEmail("2892075608@qq.com");
		user.setId("1");
		user.setPassword("123");
		user.setIntegral(10);
		user.setUsername("任冰");
		
		service.addUser(user);
		JdbcUtils.commitTransaction();
	}
	
	@Test
	public void testSaveOrder(){
		User user = new User();
		user.setAddress("神殿");
		user.setCellphone("1803517");
		user.setEmail("2892075608@qq.com");
		user.setId("1");
		user.setPassword("123");
		user.setIntegral(10);
		user.setUsername("任冰");
		
		Cart cart = new Cart();
		
		Book book = new Book();
		book.setAuthor("任冰");
		book.setCategory(null);
		book.setDescription("hhaha");
		book.setId("2341341");
		book.setImage("223");
		book.setName("javaweb开发");
		book.setPrice(89);
		
		cart.add(book);
		
		service.saveOrder(cart, user);
		JdbcUtils.commitTransaction();
	}
	
	@Test
	public void testFindOrder(){
		service.findOrder("0d64e292-de70-4c42-a061-60d563c3501e");
	}
}
















