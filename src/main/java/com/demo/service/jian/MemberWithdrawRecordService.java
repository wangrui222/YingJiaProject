package com.demo.service.jian;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberProfitRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Subject;
import com.demo.model.SubjectPurchaseRecord;


/**
 *@author ���ߣ�
 *@version ����ʱ�䣺2017��12��7��
 *��˵��
 */
public interface MemberWithdrawRecordService {



	Page<SubjectPurchaseRecord> findSubjectPurchaseRecord(Integer page, Integer size,final SubjectPurchaseRecord subjectPurchaseRecord);

	SubjectPurchaseRecord findSubjectPurchaseRecordById(Integer sprId);

	Subject findSubject(Integer subjectId);

	void updateInterest(Float interest,Integer sprId);

	void updateUseable(Float useable, Integer memberId);

	void updatesubject_purchase_record();

	void updateStatus(Integer sprId);
	//�޸�Ͷ�ʽ��
	void updateInvestAmount(Integer memberId);
	//�޸Ŀ������
	void updateUseAble(Integer memberId);
	//�޸Ķ�����
	void updateImusealeBalance(Integer memberId);
	//�޸��ۼ�����

	void  updateTotal(Float total,Integer memberId);
	//����޸�״̬

	public void UpdateShen(Integer sprId);
	//�ⶳ�޸�״̬

	public void Updatejd(Integer sprId);
	//����޸�״̬

	public void Updatedk(Integer sprId);

	void insertIn(MemberProfitRecord memberProfitRecord);


	public List<MemberWithdrawRecord> findMemberWithdrawRecord( Integer memberId);  

	Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page,Integer size,final MemberWithdrawRecord memberWithdrawRecord);


	/**
	 * ��������¼
	 * @param memberWithdrawRecord
	 */
	public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord);

	void UpdateStatus(Integer mwrId);

	void UpdateJieD(Integer mwrId);

	Object[] findSubjects(Integer memberId);

	Integer findMemberId(Integer mwrId);


}
