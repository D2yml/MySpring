package com.spring.aop.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.spring.aop.model.Member;

@Service
public class AuthService {
	private final static Logger LOG = Logger.getLogger(AuthService.class);
	
	public Member login(String loginName,String loginPass) {
		LOG.info("登录");
		return null;
	}
	
	public boolean logout(String loginName) {
		return true;
	}
}
