package cn.itcast.utils;

import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
//�������ݿ����ӳ�
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static DataSource ds;
	static{
		ds = new ComboPooledDataSource();
	}
	public static DataSource getDataSource(){
		return ds;
	}
	//һ����ȡ���ӵķ���
	public static Connection getConnection(){
		try {
			//���Ȳ鿴��ǰ�߳������ް�
			Connection conn = tl.get();
			if(conn == null){
				//���û�а󶨣��������ݿ����ӳ�Ҫһ������
				conn = ds.getConnection();
				conn.setAutoCommit(false);
			}
			//����֮ǰ���ѵ�ǰ���Ӱ󶨵���ǰ�߳���ȥ
			tl.set(conn);
			return conn;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//��������
	public static void StartTransaction(){
		try {
			//��ȡ����
			Connection conn = getConnection();
			//��������Զ��ύ��Ϊfalse��
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void commitTransaction(){
		try {
			//��ȡ����
			Connection conn = getConnection();
			if(conn != null){
				conn.commit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void closeConn(){
		Connection conn = null;
		try {
			//��ȡ����
			conn = getConnection();
			if(conn != null){
				conn.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally{
				tl.remove();
		}
	}
}









