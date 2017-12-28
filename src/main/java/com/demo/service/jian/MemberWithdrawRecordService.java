package com.demo.service.jian;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberProfitRecord;
import com.demo.model.MemberWithdrawRecord;
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


	public List<MemberWithdrawRecord> findMemberWithdrawRecord( Integer memberId);  

	Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);


	/**
	 * 保存提款记录
	 * @param memberWithdrawRecord
	 */
	public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord);

	void UpdateStatus(Integer mwrId);

	void UpdateJieD(Integer mwrId);

	Object[] findSubjects(Integer memberId);

	Integer findMemberId(Integer mwrId);


}
