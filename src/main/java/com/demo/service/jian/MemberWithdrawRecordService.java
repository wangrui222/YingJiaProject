package com.demo.service.jian;


import org.springframework.data.domain.Page;

import com.demo.model.MemberWithdrawRecord;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/
public interface MemberWithdrawRecordService {
	  //public List<MemberWithdrawRecord> findMemberWithdrawRecord();  
	  
	  Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);
	  
	  /**
	   * ��������¼
	   * @param memberWithdrawRecord
	   */
	  public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord);
}
