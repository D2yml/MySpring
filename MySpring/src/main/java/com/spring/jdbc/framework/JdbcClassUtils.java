package com.spring.jdbc.framework;

import java.math.BigDecimal;
import java.security.Timestamp;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JdbcClassUtils {
	private JdbcClassUtils() {}
	static final Set<Class<?>> SUPPORTED_SQL_OBJECT = new HashSet<Class<?>>();
	
	static {
		//只要是这里写了的,默认支持自动类型转换
		Class<?>[] classes = {
				boolean.class,Boolean.class,
				short.class,Short.class,
				int.class,Integer.class,
				long.class,Long.class,
				float.class,Float.class,
				double.class,Double.class,
				String.class,
				Date.class,
				Timestamp.class,
				BigDecimal.class
		};
		SUPPORTED_SQL_OBJECT.addAll(Arrays.asList(classes));
	}
}









