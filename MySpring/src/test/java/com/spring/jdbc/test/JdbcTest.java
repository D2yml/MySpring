package com.spring.jdbc.test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.spring.model.Member;

public class JdbcTest {
	//原生JDBC
	public static void main(String[] args) {
		try {
			// 1.加载驱动类
			Class.forName("com.mysql.jdbc.Driver");
			// 2.建立连接
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring","root","root");
			// 3.创建语句集
			PreparedStatement pstm = con.prepareStatement("select * from Member");
			// 4.执行
			ResultSet rs = pstm.executeQuery();
			
			List<Object> result = new ArrayList<Object>();
			int len = rs.getMetaData().getColumnCount();
			// 5.获取结果
			while (rs.next()) {
				//这里手动模拟ORM(使用反射)
				//什么叫ORM:就是讲Java中的ResultSet改为自己定义的一个对象
				Class clazz = Member.class;
				Object obj = clazz.newInstance();
				for (int i = 1; i <= len; i++) {
					String columnName = rs.getMetaData().getColumnName(i);
					//获取字段名
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					//获取字段类型
					Class<?> type = field.getType();
					//动态修改属性
					if (type == Long.class) {
						field.set(obj, rs.getLong(columnName));
					} else if (type == String.class){
						field.set(obj, rs.getString(columnName));
					}
				}
				result.add(obj);
			}
			System.out.println(JSON.toJSON(result));
			rs.close();
			pstm.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
