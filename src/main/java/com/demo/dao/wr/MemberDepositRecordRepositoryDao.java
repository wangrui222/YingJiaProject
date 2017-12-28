package com.demo.dao.wr;

import java.util.List;

import com.demo.model.MemberDepositRecord;

public interface MemberDepositRecordRepositoryDao {
	
	public List<MemberDepositRecord> getMemberDepositRecord(Integer memberid,Integer page,Integer rowsize);
	
	public Integer getMemberDepositRecordCount(Integer memberid);
	
	
	
	
	
	

}
