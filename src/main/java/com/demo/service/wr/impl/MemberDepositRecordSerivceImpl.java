package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.MemberDepositRecordRepository;
import com.demo.model.MemberDepositRecord;
import com.demo.service.wr.MemberDepositRecordSerivce;

@Service
public class MemberDepositRecordSerivceImpl implements MemberDepositRecordSerivce {
	
	
	@Autowired
	MemberDepositRecordRepository memberDepositRecordRepository;

	@Transactional
	@Override
	public void addMemberDepositRecord(MemberDepositRecord memberDepositRecord) {
		memberDepositRecordRepository.save(memberDepositRecord);

	}
	@Transactional
	@Override
	public void updateMemberDepositRecordSerivce(String out_trade_no, String trade_no) {
		memberDepositRecordRepository.updateMemberDepositRecord(out_trade_no, trade_no);
		
	}

}
