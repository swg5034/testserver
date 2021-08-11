package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.MemberDao;
import com.test.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao dao;

	@Override
	public void insert(MemberDto dto) throws Exception {
		dao.insert(dto);
	}

	@Override
	public List<MemberDto> selectList() {
		return dao.selectList();
	}

	@Override
	public void update(MemberDto dto) {
		dao.update(dto);
	}

	@Override
	public void delete(MemberDto dto) {
		dao.delete(dto);
	}

	@Override
	public MemberDto select_user(MemberDto dto) throws Exception {
		return	dao.select_user(dto);
		
	}

}
