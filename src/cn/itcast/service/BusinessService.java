package cn.itcast.service;

import java.util.List;

import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.Category;
import cn.itcast.domain.Order;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.QueryInfo;
import cn.itcast.domain.User;
//��ȡ�ӿڵ�Ŀ���ǽ�����Ȩ�޹���
public interface BusinessService {

	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	void addCategory(Category c);

	Category findCategory(String id);

	List getAll();

	/**************************************
	 * 
	 * ͼ����صķ���
	 * 
	 **************************************/
	void addBook(Book book);

	Book findBook(String id);

	PageBean bookPageQuery(QueryInfo info);

	/**************************************
	 * 
	 * �û���صķ���
	 * 
	 **************************************/
	void addUser(User user);

	User findUser(String username, String password);

	User findUser(String id);

	/**************************************
	 * 
	 * ������صķ���
	 * 
	 **************************************/
	//�����Ǹ����û��Ĺ��ﳵ�����ɵģ�����������ܵ��ǹ��ﳵ������û�����
	void saveOrder(Cart cart, User user);

	//��ѯ����
	Order findOrder(String id);

	//�õ����ж���
	List getOrderByState(boolean state);

}