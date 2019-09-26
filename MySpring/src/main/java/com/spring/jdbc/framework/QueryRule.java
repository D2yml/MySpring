package com.spring.jdbc.framework;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 主要功能用于构造查询条件
 * @author Administrator
 *
 */
public class QueryRule implements Serializable{

	private static final long serialVersionUID = 102931288606661817L;
	//排序规则
	public static final int ASC_ORDER = 100;
	public static final int DESC_ORDER = 101;
	//条件
	public static final int LIKE = 1;
	public static final int IN = 2;
	public static final int NOTIN = 3;
	public static final int BETWEEN = 4;
	public static final int EQ = 5;
	public static final int NOTEQ = 6;
	public static final int GT = 7;
	public static final int GE = 8;
	public static final int LT = 9;
	public static final int LE = 10;
	public static final int ISNULL = 11;
	public static final int ISNOTNULL = 12;
	public static final int ISEMPTY = 13;
	public static final int ISNOTEMPTY = 14;
	//逻辑规则
	public static final int AND = 201;
	public static final int OR = 202;
	private List<Rule> ruleList = new ArrayList<Rule>();
	private List<QueryRule> queryRules = new ArrayList<QueryRule>();
	private String propertyName;
	
	private QueryRule() {}
	private QueryRule(String properName) {
		this.propertyName = properName;
	}
	
	public static QueryRule getInstance() {
		return new QueryRule();
	}
	
	
	
	public List<Rule> getRuleList() {
		return ruleList;
	}
	public void setRuleList(List<Rule> ruleList) {
		this.ruleList = ruleList;
	}
	public List<QueryRule> getQueryRules() {
		return queryRules;
	}
	public void setQueryRules(List<QueryRule> queryRules) {
		this.queryRules = queryRules;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}



	//具体规则
	protected class Rule implements Serializable{
		
		private static final long serialVersionUID = 5156102115185866158L;
		private int type;					//规则类型
		private String property_name;		//规则是添加给那个属性的
		private Object[] values;			//规则的值
		private int andOr = AND;			//条件规则
		
		public int getType() {
			return type;
		}

		public void setType(int type) {
			this.type = type;
		}

		public String getProperty_name() {
			return property_name;
		}

		public void setProperty_name(String property_name) {
			this.property_name = property_name;
		}

		public Object[] getValues() {
			return values;
		}

		public void setValues(Object[] values) {
			this.values = values;
		}

		public int getAndOr() {
			return andOr;
		}

		public void setAndOr(int andOr) {
			this.andOr = andOr;
		}

		public Rule(int paramInt,String paramString) {
			this.property_name = paramString;
			this.type = paramInt;
		}
		
		public Rule(int paramInt,String paramString,Object[] paramArrayOfObject) {
			this.property_name = paramString;
			this.type = paramInt;
			this.values = paramArrayOfObject;
		}
	}
}







