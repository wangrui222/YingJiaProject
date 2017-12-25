package com.demo.service.jian;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.SubjectOrderRecordRepository;
import com.demo.model.MemberDepositRecord;
import com.demo.model.Members;

/**
 * @author thinkpad
 * @time 2017年12月6日上午11:53:29
 */
@Service
public class SubjectOrderRecordServiceImpl implements SubjectOrderRecordService{
    @Autowired
    SubjectOrderRecordRepository  subjectOrderRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordService()
	 */
	/**@Override
	public List<SubjectOrderRecord> findSubjectOrderRecordService() {
		List<SubjectOrderRecord> olist=subjectOrderRecordRepository.findAll();
		return olist;
	}
	 */
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#pageSubjectOrderRecordService()
	 */
	@Override
	public List<Object[]> selectMemberDepositRecord(Integer page,Integer size, MemberDepositRecord memberDepositRecord,Members members) {
		List<Object[]> slist=subjectOrderRecordRepository.selectMemberDepositRecord(page, size, members, memberDepositRecord);

		return slist;
	}
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordById()
	 */
	@Override
	public MemberDepositRecord findSubjectOrderRecordById(Integer sorId) {
		return null;
	}
	@Override
	public Integer selectCount(MemberDepositRecord memberDepositRecord, Members members) {
		
		return subjectOrderRecordRepository.selectCount(memberDepositRecord, members);
	}

}