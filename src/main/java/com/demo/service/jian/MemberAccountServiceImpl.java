package com.demo.service.jian;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.dao.jian.MemberAccountRepository;
import com.demo.model.AwardRecords;
import com.demo.model.MemberAccount;
import com.demo.model.Members;

/**
 *@author 作者：
 *@version 创建时间：2017年12月7日
 *类说明
 */
@Service
public class MemberAccountServiceImpl implements MemberAccountService {
	@Autowired
	MemberAccountRepository memberAccountRepository;

	@Override
	public List<Object[]> findMemberAccount(Integer size, Integer page, MemberAccount memberAccount, Members members,
			AwardRecords awardRecords) {

		return memberAccountRepository.findall(page, size, members, memberAccount, awardRecords);
	}

	@Override
	public Integer selectCount(MemberAccount memberAccount, Members members, AwardRecords awardRecords) {
		// TODO Auto-generated method stub
		return memberAccountRepository.selectCount(memberAccount, members, awardRecords);
	}

	@Override
	public List<Object[]> findAwardRecords(Integer memberId) {
		return memberAccountRepository.findAwardRecords(memberId);
	}

	@Override
	public List<Object[]> findRecords(Integer memberId) {
		return memberAccountRepository.findRecords(memberId);
	}
    @Transactional
	@Override
	public void upateTotal(float total, Integer memberId) {
		memberAccountRepository.updateTotal(total, memberId);
	}

}
