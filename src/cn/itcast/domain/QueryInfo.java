package cn.itcast.domain;
//封装查询信息
public class QueryInfo {

	//web层带来的数据:当前看的那一页
	private int currentPage = 1;
	//每页显示多少条,如果没有设置，就是默认3条
	private int pagesize = 3;
	//算出该页在数据库的起始位置
	private int startindex;
	
	//带查询条件，查询某个分类下的分页数据
	private String queryname;	//category_id
	private String queryvalue;	//3号分类下的分页数据
	private String where;		//将上面的两个值组装成一个where条件,	where = "where category_id=?"; ?就是3
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
	//startindex是算出来的，没必要提供set方法，只需要提供get方法
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
	//where是根据上面的两个值算出来的，所以不需要set方法
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
