package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.MemberAccountRepository;
import com.demo.service.wr.MemberAmountService;



@Service
public class MemberAmountServiceImpl implements MemberAmountService {
	
	
	@Autowired
	MemberAccountRepository memberAccountRepository; 

	@Transactional
	@Override
	public void updateMemberAmount(float parseFloat, Integer memberId) {
		memberAccountRepository.updateMemberAmount(parseFloat, memberId);
		
	}
	@Transactional
	@Override
	public void updateMemberAmounts(float parseFloat, Integer memberId) {
		memberAccountRepository.updateMemberAmounts(parseFloat, memberId);
		
	}
	@Transactional
	@Override
	public void updateMA(float parseFloat, Integer memberid) {
		memberAccountRepository.updateMemberA(parseFloat, memberid);
		
	}

}
