package com.demo.service.jian;

import java.util.List;
/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
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
	//�Ƿ���
	void updateIs(Integer memberId);
	
	void updateUser(Integer memberId);
	
	Members findMembers(Integer memberId);
	
	//��Ӽ�¼��������
	void addjiang(AwardRecords awardRecords);
}
