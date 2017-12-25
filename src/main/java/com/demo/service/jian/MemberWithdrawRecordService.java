package com.demo.service.jian;


import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.model.MemberWithdrawRecord;


/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/
public interface MemberWithdrawRecordService {
	  public List<MemberWithdrawRecord> findMemberWithdrawRecord( Integer memberId);  
	  
	  Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);
	  

	  /**
	   * 保存提款记录
	   * @param memberWithdrawRecord
	   */
	  public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord);

	  void UpdateStatus(Integer mwrId);
	  
	  void UpdateJieD(Integer mwrId);
	  
	  Object[] findSubject(Integer memberId);
	  
	  Integer findMemberId(Integer mwrId);
	  

}
