package com.demo.service.jian;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.dao.jian.SubjectOrderRecordRepository;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.SubjectOrderRecord;
/**
 * @author thinkpad
 * @time 2017��12��6������11:53:29
*/
@Service
public class SubjectOrderRecordServiceImpl implements SubjectOrderRecordService{
	
    @Autowired
    SubjectOrderRecordRepository subjectOrderRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordService()
	 */
	@Override
	public List<SubjectOrderRecord> findSubjectOrderRecordService() {
		List<SubjectOrderRecord> olist=subjectOrderRecordRepository.findAll();
		return olist;
	}


}

