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

 *@author ���ߣ�
 *@version ����ʱ�䣺2017��12��7��
 *��˵��
 */
public interface MemberAccountRepository extends JpaRepository<MemberAccount, Integer>,JpaSpecificationExecutor<MemberAccount>,MemberAccountDao{

	//�޸Ŀ������


	@Query("From MemberAccount m where m.members.memberId = ? ")
	public MemberAccount getMemberbbinAmount(Integer memberId);
	
	
	/**
	 * ֧���ɹ�֮�������
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
	//�޸Ķ����ʽ�
	@Modifying
	@Query(value="update  Member_Account m set m.imuseale_Balance=0 where m.member_Id = ?",nativeQuery=true)
	public void updateImusealeBalance(Integer memberId);
	//�������
	@Modifying
	@Query(value="update Member_Account m set m.useable_Balance=m.useable_Balance+m.imuseale_Balance where m.member_Id = ?",nativeQuery=true)
	public void updateUseAble(Integer memberId);
	//Ͷ���ʽ�
	@Modifying
	@Query(value="update Member_Account m set m.invest_Amount=m.invest_Amount-m.imuseale_Balance where m.member_Id = ?",nativeQuery=true)
	public void updateInvestAmount(Integer memberId);
	//�޸�Ͷ���ۼ�����
	@Modifying
	@Query(value="update member_account m set m.total_Profit=m.total_Profit + ?1 where member_id= ?2",nativeQuery=true)
	public void updateToatal(Float total,Integer memberId);
	@Query(value="select * from Members m where m.member_id=?1 ",nativeQuery=true)
    public Object selectMembers(Integer memberId);
	//�޸��Ƿ���Ͷ�ʽ���
	@Modifying
	@Query(value="update members m set m.status=1 where m.member_id= ?1",nativeQuery=true)
	public void UpdateIs(Integer  memberId);
	//��������
	@Modifying
	@Query(value="update member_account m set m.useable_balance=m.useable_balance+5 where member_id = ?1",nativeQuery=true)
	public void UpdateUser(Integer memberId);
	
	@Query("select s from Members s where s.memberId= ?")
	public Members Findmembers(Integer memberId);
	@Query(value="Update MemberAccount m set m.totalProfit=m.totalProfit+?1 where memberId=?2")
	public void updateTotal(float totalProfit,Integer memberId);

}
