package cn.itcast.domain;
//��װ��ѯ��Ϣ
public class QueryInfo {

	//web�����������:��ǰ������һҳ
	private int currentPage = 1;
	//ÿҳ��ʾ������,���û�����ã�����Ĭ��3��
	private int pagesize = 3;
	//�����ҳ�����ݿ����ʼλ��
	private int startindex;
	
	//����ѯ��������ѯĳ�������µķ�ҳ����
	private String queryname;	//category_id
	private String queryvalue;	//3�ŷ����µķ�ҳ����
	private String where;		//�����������ֵ��װ��һ��where����,	where = "where category_id=?"; ?����3
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	//startindex��������ģ�û��Ҫ�ṩset������ֻ��Ҫ�ṩget����
	public int getStartindex() {
		this.startindex = (this.currentPage-1)*(this.pagesize);
		return startindex;
	}
	
	public String getQueryname() {
		return queryname;
	}
	public void setQueryname(String queryname) {
		this.queryname = queryname;
	}
	public String getQueryvalue() {
		return queryvalue;
	}
	public void setQueryvalue(String queryvalue) {
		this.queryvalue = queryvalue;
	}
	//where�Ǹ������������ֵ������ģ����Բ���Ҫset����
	public String getWhere() {
		if(this.queryname==null || this.queryname.equals("")){
			return "";
		}else{
			//this.where = "where category_id=?"
			this.where = "where " + queryname +"=?";
		}
		return where;
	}
	
}
