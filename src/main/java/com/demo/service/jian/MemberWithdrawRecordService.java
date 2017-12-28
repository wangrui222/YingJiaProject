package com.demo.service.jian;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberProfitRecord;
import com.demo.model.Subject;
import com.demo.model.SubjectPurchaseRecord;


/**
 *@author 作者：
 *@version 创建时间：2017年12月7日
 *类说明
 */
public interface MemberWithdrawRecordService {


	Page<SubjectPurchaseRecord> findSubjectPurchaseRecord(Integer page, Integer size,final SubjectPurchaseRecord subjectPurchaseRecord);

	SubjectPurchaseRecord findSubjectPurchaseRecordById(Integer sprId);

	Subject findSubject(Integer subjectId);

	void updateInterest(Float interest,Integer sprId);

	void updateUseable(Float useable, Integer memberId);

	void updatesubject_purchase_record();

	void updateStatus(Integer sprId);
	//修改投资金额
	void updateInvestAmount(Integer memberId);
	//修改可用余额
	void updateUseAble(Integer memberId);
	//修改冻结金额
	void updateImusealeBalance(Integer memberId);
	//修改累计收益

	void  updateTotal(Float total,Integer memberId);
	//审核修改状态
	
		public void UpdateShen(Integer sprId);
		//解冻修改状态
	
		public void Updatejd(Integer sprId);
		//打款修改状态
	
		public void Updatedk(Integer sprId);
		
		void insertIn(MemberProfitRecord memberProfitRecord);

}
