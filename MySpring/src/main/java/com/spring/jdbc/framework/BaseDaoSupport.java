package com.spring.jdbc.framework;

import java.io.Serializable;

import javax.sql.DataSource;


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
	
	
}
