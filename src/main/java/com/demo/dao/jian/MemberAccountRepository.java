package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberAccount;
import com.demo.model.Members;

/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Integer>,JpaSpecificationExecutor<MemberAccount>,MemberAccountDao{
	@Modifying
	@Query(value="Update MemberAccount m set m.totalProfit=m.totalProfit+?1 where memberId=?2")
	public void updateTotal(float totalProfit,Integer memberId);
}
