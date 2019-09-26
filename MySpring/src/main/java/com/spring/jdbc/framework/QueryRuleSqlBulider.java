package com.spring.jdbc.framework;

import java.util.List;

/**
 * 根据QueryRule自动构建Sql语句
 * @author Administrator
 *
 */
public class QueryRuleSqlBulider {
	private int CURR_INDEX = 0;		//记录参数所在的位置
	private List<String> properties;	//保存列名列表
	private List<Object> value;			//保存参数值列表
	private List<Order> orders;			//保存排序规则列表
	
	private String whereSql = "";
	private String orderSql = "";
	private Object[] valueArr = new Object[] {};
	
}








