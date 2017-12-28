package com.demo.service.jian;

import java.util.List;
/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/


import com.demo.model.AwardRecords;
import com.demo.model.MemberAccount;
import com.demo.model.Members;
public interface MemberAccountService {
  // public List<MemberAccount> findMemberAccount();
	List<Object[]> findMemberAccount(Integer size,Integer page, MemberAccount memberAccount,Members members,AwardRecords awardRecords);
	
	Integer selectCount(MemberAccount memberAccount,Members members,AwardRecords awardRecords);
	
	List<Object[]> findAwardRecords(Integer memberId);
	
	List<Object[]> findRecords(Integer memberId);
	
	Object selectMembers(Integer memberId);
	//是否奖励
	void updateIs(Integer memberId);
	
	void updateUser(Integer memberId);
	
	Members findMembers(Integer memberId);
	
	//添加纪录到奖励标
	void addjiang(AwardRecords awardRecords);
}
