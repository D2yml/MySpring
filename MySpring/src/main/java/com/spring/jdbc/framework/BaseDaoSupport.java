package com.spring.jdbc.framework;

import java.io.Serializable;
import java.util.List;

import javax.sql.DataSource;

import org.aspectj.weaver.tools.cache.AsynchronousFileCacheBacking.RemoveCommand;
import org.springframework.util.StringUtils;


public abstract class BaseDaoSupport<T extends Serializable,PK extends Serializable>  {
	//此类需要别人去继承
	//所以并不会被new出来
	//而且这个类中方法都应设置为protected
	
	/**
	 * 设置主键列名
	 * @return
	 */
//	protected abstract String getPKColumn();
	
	/**
	 * 设置数据源(一般是动态注入)
	 * @param dataSourece
	 */
	protected abstract void seDataSource(DataSource dataSourece);
	
	protected List<T> find(QueryRule queryRule) throws Exception{
		//把用户设置的所有查询规则都带过来了
		//接下来要生成SQl语句
		QueryRuleSqlBulider bulider = new QueryRuleSqlBulider(queryRule);
//		String ws = removeFirstAnd(bulider.getWhereSal());
//		String whereSql = ("".equals(ws)) ? ws : ("where" + ws);
//		String sql = "select " + op.allColumn + " from " + getTableName() + whereSql;
//		Object[] values = bulider.getvalues();
//		String orderSql = bulider.getOrderSql();
//		orderSql = (StringUtils.isEmpty(orderSql)) ? " " : (" order by" + orderSql);
//		sql += orderSql;
//		log.debug(sql);
//		return this.jdbcTemplateReadOnly().query(sql,this.op.rowMapper,values);
		return null;
	}
	
	
}
