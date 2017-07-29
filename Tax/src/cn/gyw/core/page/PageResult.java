package cn.gyw.core.page;

import java.util.ArrayList;
import java.util.List;

public class PageResult {

	//当前单词写错了，修改太麻烦了，抱歉不修改了total total 当前
	//总记录数
	private long totleCount;
	//当前页号
	private int pageNo;
	//总页数
	private int totlePageCount;
	//页大小
	private int pageSize;
	//列表记录
	private List items;
	
	

	public PageResult(Long totleCount, int pageNo, int pageSize, List items) {
		this.totleCount=totleCount;
		this.items = items==null?new ArrayList():items;
		this.pageNo = pageNo;
		this.pageSize = pageSize;
		if(totleCount != 0){
			//计算总页数
			int tem = (int) (totleCount/pageSize);
			this.totlePageCount=(totleCount%pageSize==0)?tem:(tem+1);
		}else{
			this.pageNo=0;
		}
	}
	public PageResult() {
	}


	public long getTotleCount() {
		return totleCount;
	}
	public void setTotleCount(long totleCount) {
		this.totleCount = totleCount;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getTotlePageCount() {
		return totlePageCount;
	}
	public void setTotlePageCount(int totlePageCount) {
		this.totlePageCount = totlePageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
}
