package com.spring.jdbc.framework;

/**
 * sql排序规则
 * @author Administrator
 *
 */
public class Order {
	//升序还是降序
	private boolean ascending;
	//根据那个字段排序
	private String propertyName;
	
	
	public Order(String propertyName,boolean ascending) {
		super();
		this.ascending = ascending;
		this.propertyName = propertyName;
	}


	public static Order asc(String property_name) {
		return new Order(property_name,true);
	}
	public static Order desc(String property_name) {
		return new Order(property_name,false);
	}
	
	
}
