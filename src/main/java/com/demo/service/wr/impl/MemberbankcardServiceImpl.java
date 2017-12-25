package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.MemberbankcardsRepository;
import com.demo.model.MemberBankcards;
import com.demo.service.wr.MemberbankcardService;

@Service
public class MemberbankcardServiceImpl implements MemberbankcardService{
	
	@Autowired
	MemberbankcardsRepository memberbankcardsRepository;

	@Transactional
	@Override
	public void addMemberbankcard(MemberBankcards memberbankcard) {
		
		memberbankcardsRepository.save(memberbankcard);
	}

}
