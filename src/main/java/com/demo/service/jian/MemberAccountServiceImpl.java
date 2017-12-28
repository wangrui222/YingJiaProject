package com.demo.service.jian;


import java.util.List;

import javax.persistence.TableGenerator;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.AwardRecordsRepository;
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
    @Autowired
    AwardRecordsRepository awardRecordsRepository;
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

	@Override
	public Object selectMembers(Integer memberId) {
		return memberAccountRepository.selectMembers(memberId);
	}
	@Transactional
	@Override
	public void updateIs(Integer memberId) {
		memberAccountRepository.UpdateIs(memberId);

	}
	@Transactional
	@Override
	public void updateUser(Integer memberId) {
	    memberAccountRepository.UpdateUser(memberId);
	}

	@Override
	public Members findMembers(Integer memberId) {
		
		return memberAccountRepository.Findmembers(memberId);
	}
	@Transactional
	@Override
	public void addjiang(AwardRecords awardRecords) {
		awardRecordsRepository.save(awardRecords);
		
	}  

}
