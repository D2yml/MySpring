package com.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.aop.model.Member;
import com.spring.aop.service.MemberManagerService;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AopTest {
	
	@Autowired
	public MemberManagerService  managerService;
	
	@Test
	public void tadd() {
		managerService.add(null);
	}
	
	@Test
	public void remove(){
		try {
			managerService.remove(0);
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}
	
	@Test
	public void modify() {
		managerService.modify(null);
	}
	
	@Test
	public void query() {
		managerService.query("");
	}
}
