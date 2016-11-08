package cn.itcast.domain;

import java.util.List;

public class PageBean {

	//���ط�ҳ�������Ϣ����װ��pageBean�У�ҳ������ʹ��list���Ϸ�װ
	private List list;
	private int totalrecord;	//��¼�ܼ�¼��
	private int pagesize;		//��¼ÿһҳ������
	private int totalpage;		//��¼����ҳ
	private int currentpage;	//��¼��ǰҳ���ɿͻ�������
	private int previouspage;	//��¼��һҳ
	private int nextpage;		//��¼��һҳ
	private int[] pagebar;	//ҳ����
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
	//ҳ�����������
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
		//���ݵ�ǰҳ������ʼֵ�ͽ���ֵ
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
		int index = 0;		//ά��һ����Ӱ��
		for(int i = startpage;i<=endpage;i++){
			this.pagebar[index++] = i;
		}
		return pagebar;
	}
	
	
}
