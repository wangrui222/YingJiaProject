package com.demo.dao.wr;

import java.util.List;

import com.demo.model.MemberWithdrawRecord;

public interface MemberWithdrawRecordDao {
	
	public List<MemberWithdrawRecord> getMemberWithdrawRecord(Integer memberid,Integer page,Integer rowsize);
	
	public Integer getMemberWithdrawRecordCount(Integer memberid);

}
