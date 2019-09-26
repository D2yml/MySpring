package com.spring.aop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.spring.aop.dao.MemberDao;
import com.spring.aop.model.Member;
import com.spring.aop.service.MemberManagerService;

@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class MemberDaoTest {
	
	@Autowired
	public MemberDao  managerService;
	
	@Test
	public void tadd() {
		managerService.insert();
	}
}
