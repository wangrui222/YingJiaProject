package com.demo.service.jian;

import java.util.List;
/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/

import org.springframework.data.domain.Page;

import com.demo.model.MemberAccount;
public interface MemberAccountService {
  // public List<MemberAccount> findMemberAccount();
	Page<MemberAccount> findMemberAccount(Integer size,Integer page);
}
