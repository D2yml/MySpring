package com.spring.jdbc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//如果不写name则默认表明与类名相同
@Table(name="Member")
public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1660140615165973510L;

	@Id
	private Long id;
	
	//如果不传参数,则默认字段名相同
	@Column(name = "user_name")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	private Long creat_time;//原则上使用时间戳,为了更加直观使用yyyyMMddHHmmss;谁用谁解析
	
	
	
	
}













