package com.demo.service.jian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
/**
	public List<MemberAccount> findMemberAccount() {
		List<MemberAccount> mlist=memberAccountRepository.findAll();
		return mlist;
	}*/

	/* (non-Javadoc)
	 * @see com.demo.service.jian.MemberAccountService#findMemberAccount(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page<MemberAccount> findMemberAccount(Integer size, Integer page) {
		Pageable pageable=new PageRequest(page-1, size);
		return memberAccountRepository.findAll(pageable);
	}

}
