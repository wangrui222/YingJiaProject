package com.demo.dao.jian;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberWithdrawRecord;
import com.demo.model.SubjectPurchaseRecord;


/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/

public interface MemberWithdrawRecordRepository extends JpaRepository<SubjectPurchaseRecord, Integer>,JpaSpecificationExecutor<SubjectPurchaseRecord>{

	
	public SubjectPurchaseRecord findSubjectPurchaseRecordBysprId(Integer sprId);
	@Modifying
	@Query(value="update SubjectPurchaseRecord s set s.interest=?1 where s.sprId=?2")
	public  void  UpdateInterestById(Float interest,Integer sprId);
	
	@Modifying
	@Query(value="update  subject_purchase_record t  set t.status='1' where t.create_date+t.pay_interest_times<sysdate and t.status='0'",nativeQuery=true)
	public void updatesubject_purchase_record();
	@Modifying
	@Query("update SubjectPurchaseRecord s set s.status=4 where s.sprId=?1")
	public void  updateStatus(Integer sprId); 
	
	//审核修改状态
	@Modifying
	@Query(value="update SubjectPurchaseRecord s set s.status=2 where s.sprId=?1")
	public void UpdateShen(Integer sprId);
	@Modifying
	//解冻修改状态
	@Query(value="update SubjectPurchaseRecord s set s.status=3 where s.sprId=?1")
	public void Updatejd(Integer sprId);
	@Modifying
	//打款修改状态
	@Query(value="update SubjectPurchaseRecord s set s.status=4 where s.sprId=?1")
	public void Updatedk(Integer sprId); 
	
}
