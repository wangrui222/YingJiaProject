package com.demo.service.jian;

import java.util.List;
/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/

import org.springframework.data.domain.Page;

import com.demo.model.MemberAccount;
public interface MemberAccountService {
  // public List<MemberAccount> findMemberAccount();
	Page<MemberAccount> findMemberAccount(Integer size,Integer page);
}
