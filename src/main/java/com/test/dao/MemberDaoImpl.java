package com.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto select_user(MemberDto dto) throws Exception {
		return sqlSession.selectOne("com.test.mapper.MemberMapper.login",dto);
		
	}
	
	@Override
	public void insert(MemberDto dto) throws Exception {
		sqlSession.insert("com.test.mapper.MemberMapper.insertMember",dto);
	}

	@Override
	public List<MemberDto> selectList() {
		List<MemberDto> list = new ArrayList<MemberDto>();
		list = sqlSession.selectList("com.test.mapper.MemberMapper.selectList");
		for(MemberDto d : list) {
			System.out.println(d.getId() + d.getName() + d.getPoint() + d.getPw());
		}
		return list;
	}

	@Override
	public void update(MemberDto dto) {
		sqlSession.update("com.test.mapper.MemberMapper.updateMember",dto);
	}

	@Override
	public void delete(MemberDto dto) {
		sqlSession.delete("com.test.mapper.MemberMapper.deleteMember",dto);
	}


}
