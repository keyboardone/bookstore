package cn.itcast.domain;

import java.util.List;

public class QueryResult {
//����һ�����󣬷��ط�ҳ��Ϣ
	private List list;
	private int totalrecord;
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public int getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
	}
	
}
