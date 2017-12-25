package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.MemberRepository;
import com.demo.model.Members;
import com.demo.service.wr.MemberService;


@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	

	@Transactional
	@Override
	public void addMemberYanZheng(Integer memberid, String userName, String identity) {
		memberRepository.addMember(memberid,userName,identity);
		
	}

	@Transactional
	@Override
	public void updateMemberPassword(String password, Integer memberId) {
		memberRepository.updateMemberPassword(password, memberId);
		
	}

}
