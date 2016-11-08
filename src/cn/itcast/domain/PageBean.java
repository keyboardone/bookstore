package cn.itcast.domain;

import java.util.List;

public class PageBean {

	//返回分页所需的信息，封装到pageBean中，页面数据使用list集合封装
	private List list;
	private int totalrecord;	//记录总记录数
	private int pagesize;		//记录每一页多少条
	private int totalpage;		//记录多少页
	private int currentpage;	//记录当前页，由客户机带来
	private int previouspage;	//记录上一页
	private int nextpage;		//记录下一页
	private int[] pagebar;	//页码条
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
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	//页数是算出来的
	public int getTotalpage() {
		if(this.totalrecord % this.pagesize==0){
			this.totalpage = this.totalrecord/this.pagesize;
		}else{
			this.totalpage = this.totalrecord/this.pagesize + 1;
		}
		return totalpage;
	}
	
	public int getCurrentpage() {
		return currentpage;
	}
	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}
	public int getPreviouspage() {
		if(this.currentpage-1>1){
			this.previouspage = this.currentpage - 1;
		}else{
			this.previouspage = 1;
		}
		return previouspage;
	}
	
	public int getNextpage() {
		if(this.currentpage+1>this.totalrecord){
			this.nextpage = this.totalpage;
		}else{
			this.nextpage = this.currentpage + 1; 
		}
		return nextpage;
	}
	
	public int[] getPagebar() {
		//根据当前页调整起始值和结束值
		int startpage;
		int endpage;
		if(this.totalpage<=10){
			startpage = 1;
			endpage = this.totalpage;
		}else{
			startpage = this.currentpage - 4;
			endpage = this.currentpage + 5;
			
			if(startpage<1){
				startpage = 1;
				endpage = 10;
			}
			if(endpage>totalpage){
				endpage = totalpage;
				startpage = totalpage - 9;
			}
		}
		
		this.pagebar = new int[endpage-startpage+1]; 
		int index = 0;		//维护一个缩影号
		for(int i = startpage;i<=endpage;i++){
			this.pagebar[index++] = i;
		}
		return pagebar;
	}
	
	
}
