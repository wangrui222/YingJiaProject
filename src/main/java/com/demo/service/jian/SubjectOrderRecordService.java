package com.demo.service.jian;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.SubjectOrderRecord;

/**
 * @author thinkpad
 * @time 2017年12月6日上午11:55:14
 */
public interface SubjectOrderRecordService {

	//public List<SubjectOrderRecord> findSubjectOrderRecordService(); 

	public Page<SubjectOrderRecord> pageSubjectOrderRecordService(Integer page,Integer size,final SubjectOrderRecord subjectOrderRecord);
	
	public SubjectOrderRecord findSubjectOrderRecordById(Integer sorId);

}

