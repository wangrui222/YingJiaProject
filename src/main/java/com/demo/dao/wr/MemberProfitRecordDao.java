package com.demo.dao.wr;

import java.util.List;

import com.demo.model.MemberProfitRecord;

public interface MemberProfitRecordDao {
	
	public List<MemberProfitRecord> getMemberProfitRecord(Integer memberId,Integer page,Integer rowsize);
	
	public Integer getMemberProfitRecordCount(Integer memberId);

}
