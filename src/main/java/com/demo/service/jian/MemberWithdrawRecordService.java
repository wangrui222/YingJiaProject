package com.demo.service.jian;


import org.springframework.data.domain.Page;

import com.demo.model.MemberWithdrawRecord;

/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/
public interface MemberWithdrawRecordService {
	  //public List<MemberWithdrawRecord> findMemberWithdrawRecord();  
	  
	  Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);
}
