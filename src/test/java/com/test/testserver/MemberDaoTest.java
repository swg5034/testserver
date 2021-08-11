package com.test.testserver;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.dao.MemberDao;
import com.test.dto.MemberDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDaoTest {
	@Autowired
	private MemberDao dao;
	
	@Test
	public void testInsertMember() throws Exception {
		dao.insert(new MemberDto("test","1234","테스트",1000));
	}
	@Test
	public void testUpdateMember() throws Exception{
		dao.update(new MemberDto("test","1234","테스트",55555));
	}
	public void testSelectAll() throws Exception{
		dao.selectList();
	}
}
