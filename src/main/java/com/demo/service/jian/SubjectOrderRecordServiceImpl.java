package com.demo.service.jian;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.jian.SubjectOdRrdDao;
/**
 * @author thinkpad
 * @time 2017��12��6������11:53:29
*/
@Service
public class SubjectOrderRecordServiceImpl implements SubjectOrderRecordService{
    @Autowired
    SubjectOdRrdDao subjectOdRrdDao;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findSubjectOrderRecordService()
	 */
	@Override
	public List<Object[]> findSubjectOrderRecordService() {
		List<Object[]> olist=subjectOdRrdDao.FindSubjectOrderRecord();
		return olist;
	}

}

