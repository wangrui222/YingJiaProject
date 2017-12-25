package com.demo.service.jian;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.MemberDepositRecord;
import com.demo.model.Members;
import com.demo.model.SubjectOrderRecord;

/**
 * @author thinkpad
 * @time 2017年12月6日上午11:55:14
 */
public interface SubjectOrderRecordService {

	//public List<SubjectOrderRecord> findSubjectOrderRecordService(); 

	public List<Object[]> selectMemberDepositRecord(Integer page,Integer size,MemberDepositRecord memberDepositRecord,Members Members);
	
	public MemberDepositRecord findSubjectOrderRecordById(Integer sorId);
	
	public Integer selectCount(MemberDepositRecord memberDepositRecord,Members members);

}

