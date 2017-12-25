package com.demo.dao.jian;

import java.util.List;

import com.demo.model.AwardRecords;
import com.demo.model.MemberAccount;
import com.demo.model.Members;

public interface MemberAccountDao {
	
	public List<Object[]> findall(Integer page,Integer size,Members members,MemberAccount memberAccount,AwardRecords awardRecords);
	
	Integer selectCount(MemberAccount memberAccount,Members members,AwardRecords awardRecords);
	
	List<Object[]> findAwardRecords(Integer memberId);
	
	List<Object[]> findRecords(Integer memberId);
	
}