package com.demo.dao.jian;

import java.util.List;

import com.demo.model.MemberDepositRecord;
import com.demo.model.Members;


public interface SubjectOrderDao {
	
	public List<Object[]> selectMemberDepositRecord( Integer page,Integer size,Members members,MemberDepositRecord memberDepositRecord);
	
	public   Integer selectCount(MemberDepositRecord memberDepositRecord,Members members);

}
