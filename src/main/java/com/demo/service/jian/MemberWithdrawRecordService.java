package com.demo.service.jian;


import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.MemberWithdrawRecord;


/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/
public interface MemberWithdrawRecordService {
	  public List<MemberWithdrawRecord> findMemberWithdrawRecord( Integer memberId);  
	  
	  Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);
	  

	  /**
	   * ��������¼
	   * @param memberWithdrawRecord
	   */
	  public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord);

	  void UpdateStatus(Integer mwrId);
	  
	  void UpdateJieD(Integer mwrId);
	  
	  Object[] findSubject(Integer memberId);
	  
	  Integer findMemberId(Integer mwrId);
	  

}
