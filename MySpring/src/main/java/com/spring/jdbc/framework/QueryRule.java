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

	/**
	 * 
	 */
	private static final long serialVersionUID = 102931288606661817L;
	public static final int ASC_ORDER = 100;
	public static final int DESC_ORDER = 101;
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
	
	protected class Rule implements Serializable{
		
		private static final long serialVersionUID = 5156102115185866158L;
		private int type;
		private String property_name;
		private Object[] values;
		private int andOr = AND;
		
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







