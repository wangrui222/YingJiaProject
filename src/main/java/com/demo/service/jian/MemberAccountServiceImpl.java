package com.demo.service.jian;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.MemberAccountRepository;
import com.demo.model.MemberAccount;

/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/
@Service
public class MemberAccountServiceImpl implements MemberAccountService {
    @Autowired
    MemberAccountRepository memberAccountRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.MemberAccountService#findMemberAccount()
	 */
	@Override
	public List<MemberAccount> findMemberAccount() {
		List<MemberAccount> mlist=memberAccountRepository.findAll();
		return mlist;
	}

}
