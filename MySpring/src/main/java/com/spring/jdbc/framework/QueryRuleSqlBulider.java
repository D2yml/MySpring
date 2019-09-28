package com.spring.jdbc.framework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import com.spring.jdbc.framework.QueryRule.Rule;

/**
 * 根据QueryRule自动构建Sql语句
 * @author Administrator
 *
 */
public class QueryRuleSqlBulider {
	
	private int CURR_INDEX = 0;		//记录参数所在的位置
	private List<String> properties;	//保存列名列表
	private List<Object> values;			//保存参数值列表
	private List<Order> orders;			//保存排序规则列表
	
	private String whereSql = "";
	private String orderSql = "";
	private Object[] valueArr = new Object[] {};
	private Map<Object,Object> valueMap = new HashMap<Object, Object>();
	
	/**
	 * 创建SQl构造器
	 * 这只是一个工具类,这些功能是可以给用户直接用的
	 * @param queryRule
	 */
	public QueryRuleSqlBulider(QueryRule queryRule) {
		CURR_INDEX = 0;
		properties = new ArrayList<String>();
		values = new ArrayList<Object>();
		orders = new ArrayList<Order>();
		for (QueryRule.Rule rule : queryRule.getRuleList()) {
			switch (rule.getType()) {
				case QueryRule.BETWEEN:
//					processBetween(rule);
					break;
				case QueryRule.EQ:
//					processEqual(rule);
					break;
				case QueryRule.LIKE:
					processLike(rule);
					break;
				case QueryRule.NOTEQ:
//					processNotEqual(rule);
					break;
				case QueryRule.GT:
//					processGreaterThen(rule);
					break;
				case QueryRule.GE:
//					processGreaterEqual(rule);
					break;
				case QueryRule.LT:
					processLessThen(rule);
					break;
				case QueryRule.LE:
					processLessEqual(rule);
					break;	
				case QueryRule.IN:
					processIN(rule);
					break;
				case QueryRule.NOTIN:
					processNotIN(rule);
					break;
				case QueryRule.ISNULL:
					processIsNull(rule);
					break;
				case QueryRule.ISNOTNULL:
					processIsNotNull(rule);
					break;
//				case QueryRule.ISEMPTY:
//					processIsEmpty(rule);
//					break;
				case QueryRule.ISEMPTY:
					processIsEmpty(rule);
					break;
				case QueryRule.ISNOTEMPTY:
					processIsNotEmpty(rule);
					break;
				case QueryRule.ASC_ORDER:
					processOrder(rule);
					break;
				default:
					throw new IllegalArgumentException();
					
			}
		}
		//拼装where
		appendWhereSql();
		//拼装排序
//		appendOrderSql();
		//拼装参数
//		appendValues();
	}
	
	private void processIsNotEmpty(QueryRule.Rule rule) {
		add(rule.getAndOr(), rule.getProperty_name(), "<>", "''");
	}

	private void processIsEmpty(QueryRule.Rule rule) {
		add(rule.getAndOr(), rule.getProperty_name(), "=", "''");
	}

	private void processIsNotNull(QueryRule.Rule rule) {
		add(rule.getAndOr(), rule.getProperty_name(), "is not null", null);
	}

	private void processIsNull(QueryRule.Rule rule) {
		add(rule.getAndOr(), rule.getProperty_name(), "is null", null);
		
	}

	/**
	 * 处理>=
	 * @param rule
	 */
	private void processLessThen(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(), rule.getProperty_name(), ">=", rule.getValues()[0]);
	}

	/**
	 * 处理<=
	 * @param rule
	 */
	private void processLessEqual(QueryRule.Rule rule) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		add(rule.getAndOr(), rule.getProperty_name(), "<=", rule.getValues()[0]);
	}

	private void appendWhereSql() {
		StringBuilder wheresql = new StringBuilder();
		for (String p : properties) {
			wheresql.append(p);
		}
//		this.whereSql = removeSelect(removeOrders(whereSql.toString()));
	}

	private void processNotIN(QueryRule.Rule rule) {
		inAndNotIn(rule,"not in");
		
	}

	private void processIN(QueryRule.Rule rule) {
		inAndNotIn(rule,"in");
	}
	
	

	private void inAndNotIn(QueryRule.Rule rule, String string) {
		if (ArrayUtils.isEmpty(rule.getValues())) {
			return;
		}
		if ((rule.getValues().length) == 1 && (rule.getValues()[0] != null && (rule.getValues()[0] instanceof List))) {
			List<Object> list = (List) rule.getValues()[0];
			if ((list != null) && (list.size()) > 0) {
				
			}
		}
	}

	/**
	 * 处理orderBy
	 * @param rule
	 */
	private void processOrder(Rule rule) {
		switch(rule.getType()) {
			case QueryRule.ASC_ORDER:
				if (!StringUtils.isEmpty(rule.getProperty_name())) {
					orders.add(Order.asc(rule.getProperty_name()));
				}
			case QueryRule.DESC_ORDER:
				if (!StringUtils.isEmpty(rule.getProperty_name())) {
					orders.add(Order.desc(rule.getProperty_name()));
				}
		}
	}

	//如果要自己执行SQl可以自己拼接
	//只拿到了QueryRule,并不知道执行CRUD哪一个
	//只是用来操作SQL语句

	private void processLike(QueryRule.Rule rule) {
		if(ArrayUtils.isEmpty(rule.getValues())) {
			return ;
		}
		Object obj = rule.getValues()[0];
		if (obj != null) {
			String value = obj.toString();
			if (!StringUtils.isEmpty(value)) {
				
			}
		}
	}
	
	private void add(int andOr,String key,String split,Object value) {
		add(andOr,key,split,"",value,"");
	}

	/**
	 * 加入查询规则队列
	 * @param andOr
	 * @param key
	 * @param split
	 * @param string
	 * @param value
	 * @param string2
	 */
	private void add(int andOr, String key, String split, String string, Object value, String string2) {
		String andOrStr = (0 == andOr ? "" : (QueryRule.AND == andOr ? " and " : " or ")) ;
		if (value != null) {
			values.add(CURR_INDEX,value);
			CURR_INDEX++;
		}
	}

	/**
	 * 获得查询条件
	 * @return
	 */
	public String getWhereSql() {
		return this.whereSql;
	}
	
	/**
	 * 获得排序条件
	 * @return
	 */
	public String getOrderSql() {
		return this.orderSql;
	}
	
	/**
	 * 获得参数值列表
	 * @return
	 */
	public Object[] getValues() {
		return this.valueArr;
	}
	
	/**
	 * 获取参数列表
	 * @return
	 */
	public Map<Object,Object> getValueMap(){
		return this.valueMap;
	}
	
}








