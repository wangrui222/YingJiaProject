package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

	@Query("From MemberAccount m where m.members.memberId = ? ")
	public MemberAccount getMemberbbinAmount(Integer memberId);
	
	
	/**
	 * 支付成功之后余额变多
	 * @param parseFloat
	 */
	@Modifying
	@Query(value="update Member_Account  set useable_Balance = useable_Balance + :balance where member_Id = :memberId",nativeQuery=true)
	public void updateMemberAmount(@Param("balance")float parseFloat,@Param("memberId")Integer memberId);
	
	
	
	@Modifying
	@Query(value="update Member_Account  set useable_Balance = useable_Balance - :balance where member_Id = :memberId",nativeQuery=true)
	public void updateMemberAmounts(@Param("balance")float parseFloat,@Param("memberId")Integer memberId);

	@Modifying
	@Query(value="update Member_Account  set useable_Balance = useable_Balance - :balance ,imuseale_Balance = imuseale_Balance + :balance"
			+ " ,invest_Amount = invest_Amount + :balance where member_Id = :memberId",nativeQuery=true)
	public void updateMemberA(@Param("balance")float parseFloat,@Param("memberId")Integer memberId);


	@Modifying
	@Query(value="Update MemberAccount m set m.totalProfit=m.totalProfit+?1 where memberId=?2")
	public void updateTotal(float totalProfit,Integer memberId);

}
