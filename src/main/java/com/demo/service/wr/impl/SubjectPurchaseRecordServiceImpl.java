package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.SubjectPurchaseRecordRepository;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.service.wr.SubjectPurchaseRecordService;

@Service
public class SubjectPurchaseRecordServiceImpl implements SubjectPurchaseRecordService{

	@Autowired
	SubjectPurchaseRecordRepository subjectpr;
	
	@Transactional
	@Override
	public void addSubjectPurhaseRecord(SubjectPurchaseRecord subjectPurchaseRecord) {
		subjectpr.save(subjectPurchaseRecord);
		
	}

}
