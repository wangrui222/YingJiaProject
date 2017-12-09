package com.demo.service.jian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.model.MemberWithdrawRecord;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/
@Service
public class MemberWithdrawRecordServiceImpl implements MemberWithdrawRecordService {
	@Autowired
	MemberWithdrawRecordRepository memberWithdrawRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findMemberWithdrawRecord()
	 */
	@Override
	public List<MemberWithdrawRecord> findMemberWithdrawRecord() {
	    List<MemberWithdrawRecord> mlist=memberWithdrawRecordRepository.findAll();
		return mlist;
	}
}
