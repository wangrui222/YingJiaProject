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

	//修改可用余额


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
	@Query(value="Update Member_Account m set m.useable_balance=m.useable_Balance + ?1 where member_Id = ?2",nativeQuery=true)
	public void updateUseable(Float useable,Integer memberId);
	//修改冻结资金
	@Modifying
	@Query(value="update  Member_Account m set m.imuseale_Balance=0 where m.member_Id = ?",nativeQuery=true)
	public void updateImusealeBalance(Integer memberId);
	//可用余额
	@Modifying
	@Query(value="update Member_Account m set m.useable_Balance=m.useable_Balance+m.imuseale_Balance where m.member_Id = ?",nativeQuery=true)
	public void updateUseAble(Integer memberId);
	//投资资金
	@Modifying
	@Query(value="update Member_Account m set m.invest_Amount=m.invest_Amount-m.imuseale_Balance where m.member_Id = ?",nativeQuery=true)
	public void updateInvestAmount(Integer memberId);
	//修改投资累计收益
	@Modifying
	@Query(value="update member_account m set m.total_Profit=m.total_Profit + ?1 where member_id= ?2",nativeQuery=true)
	public void updateToatal(Float total,Integer memberId);
	@Query(value="select * from Members m where m.member_id=?1 ",nativeQuery=true)
    public Object selectMembers(Integer memberId);
	//修改是否已投资奖励
	@Modifying
	@Query(value="update members m set m.status=1 where m.member_id= ?1",nativeQuery=true)
	public void UpdateIs(Integer  memberId);
	//可用余额加
	@Modifying
	@Query(value="update member_account m set m.useable_balance=m.useable_balance+5 where member_id = ?1",nativeQuery=true)
	public void UpdateUser(Integer memberId);
	
	@Query("select s from Members s where s.memberId= ?")
	public Members Findmembers(Integer memberId);
	@Query(value="Update MemberAccount m set m.totalProfit=m.totalProfit+?1 where memberId=?2")
	public void updateTotal(float totalProfit,Integer memberId);

}
