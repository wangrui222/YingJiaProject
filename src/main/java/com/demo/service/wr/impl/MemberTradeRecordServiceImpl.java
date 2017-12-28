package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.MembertraderecordRepository;
import com.demo.model.MemberTradeRecord;
import com.demo.service.wr.MemberTradeRecordService;

@Service
public class MemberTradeRecordServiceImpl implements MemberTradeRecordService{
	
	@Autowired
	MembertraderecordRepository membertraderecordRepository;

	@Transactional
	@Override
	public void addMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
		
		membertraderecordRepository.save(memberTradeRecord);
		
	}

	@Transactional
	@Override
	public void updateMemberTradeRecordService(Integer status,Integer id) {
		membertraderecordRepository.updateMTR(status,id);
		
	}

}
