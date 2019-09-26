package com.spring.jdbc.javax.core.common;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = -3387854182962980540L;
	private static final int DEFAULT_PAGE_SIZE = 20;
	private int pageSize = DEFAULT_PAGE_SIZE;			//每页条数
	private long start;									//开始位置
	private List<T> rows;								//本页数据
	private long total;									//记录总数
	public Page(int pageSize, long start, List<T> rows, long total) {
		super();
		this.pageSize = pageSize;
		this.start = start;
		this.rows = rows;
		this.total = total;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public long getStart() {
		return start;
	}
	public void setStart(long start) {
		this.start = start;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	
	
	
	
}
