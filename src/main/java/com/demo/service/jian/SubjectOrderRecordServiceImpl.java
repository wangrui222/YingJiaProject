package com.demo.service.jian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.SubjectOrderRecordRepository;
/**
 * @author thinkpad
 * @time 2017年12月6日上午11:53:29
*/
@Service
public class SubjectOrderRecordServiceImpl implements SubjectOrderRecordService{
    @Autowired
    SubjectOrderRecordRepository SubjectOrderRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordService()
	 */
	@Override
	public List<Object[]> findSubjectOrderRecordService() {
		List<Object[]> olist=SubjectOrderRecordRepository.FindSubjectOrderRecord();
		return olist;
	}

}

