package com.spring.aop.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring.aop.model.Member;

@Service
public class MemberManagerService {
	
	private final static Logger LOG = Logger.getLogger(MemberManagerService.class);
	
	public boolean add(Member member) {
		LOG.info("登录用户");
		return true;
	}
	
	public boolean remove(long id) throws Exception{
		LOG.info("删除用户");
		throw new Exception("自己抛出");
	}
	
	public boolean modify(Member member) {
		LOG.info("修改用户");
		return true;
	}
	
	public boolean query(String loginName) {
		LOG.info("查询用户");
		return true;
	}
}
