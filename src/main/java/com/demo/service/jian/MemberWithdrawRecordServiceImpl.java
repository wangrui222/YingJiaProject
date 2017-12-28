package com.demo.service.jian;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.jian.MemberAccountRepository;
import com.demo.dao.jian.MemberProfitRecordRepository;
import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.dao.ldd.SubjectpurchaserecordRepository;
import com.demo.dao.wr.SubjectPurchaseRecordRepository;
import com.demo.dao.wr.SubjectRepository;
import com.demo.model.MemberAccount;
import com.demo.model.MemberProfitRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Subject;
import com.demo.model.SubjectPurchaseRecord;

/**
 *@author 作者：
 *@version 创建时间：2017年12月7日
 *类说明
 */
@Service
public class MemberWithdrawRecordServiceImpl implements MemberWithdrawRecordService {
	@Autowired
	MemberWithdrawRecordRepository memberWithdrawRecordRepository;
	@Autowired
	SubjectRepository subjectRepository;
	@Autowired
	MemberAccountRepository memberAccountRepository;
	@Autowired
	MemberProfitRecordRepository memberProfitRecordRepository;
	@Autowired
	SubjectPurchaseRecordRepository subjectPurchaseRecordRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.jian.SubjectOrderRecordService#findMemberWithdrawRecord()
	 */
	//@Override
	/**public List<MemberWithdrawRecord> findMemberWithdrawRecord() {
	    List<MemberWithdrawRecord> mlist=memberWithdrawRecordRepository.findAll();
		return mlist;
	}*/

	/* (non-Javadoc)
	 * @see com.demo.service.jian.MemberWithdrawRecordService#findMemberWithdrawRecord(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public Page<SubjectPurchaseRecord> findSubjectPurchaseRecord(Integer page, Integer size,final SubjectPurchaseRecord subjectPurchaseRecord) {
		Specification<SubjectPurchaseRecord> specification=new Specification<SubjectPurchaseRecord>() {

			@Override
			public Predicate toPredicate(Root<SubjectPurchaseRecord> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				List<Predicate> plist=new ArrayList<>();
				if(subjectPurchaseRecord!=null){
					//流水号
					if (subjectPurchaseRecord.getSerialNumber()!=null&&!"".equals(subjectPurchaseRecord.getSerialNumber())) {
						Path pathSerialNumber=root.get("serialNumber");
						plist.add(builder.equal(pathSerialNumber,subjectPurchaseRecord.getSerialNumber()));
					}
					//状态
					if (subjectPurchaseRecord.getStatus()!=null&&!"".equals(subjectPurchaseRecord.getStatus())) {
						Path pathStatus=root.get("status");
						plist.add(builder.equal(pathStatus,subjectPurchaseRecord.getStatus()));
					}
				}

				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};

		Pageable pageable=new PageRequest(page-1, size);
		return subjectPurchaseRecordRepository.findAll(specification,pageable);
	}

	@Transactional
	@Override
	public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord) {
		memberWithdrawRecordRepository.save(memberWithdrawRecord);
		
	}

	@Override
	public SubjectPurchaseRecord findSubjectPurchaseRecordById(Integer sprId) {
		return subjectPurchaseRecordRepository.findSubjectPurchaseRecordBysprId(sprId);
	}
	@Override
	public Subject findSubject(Integer subjectId) {

		return subjectRepository.findOne(subjectId);
	}
	@Transactional
	@Override
	public void updateInterest(Float interest, Integer sprId) {
	    memberWithdrawRecordRepository.UpdateInterestById(interest, sprId);
		
	}
	@Transactional
	@Override
	public void updateUseable(Float useable, Integer memberId) {
		memberAccountRepository.updateUseable(useable, memberId);
	}
	@Transactional
	@Override
	public void updatesubject_purchase_record() {
    memberWithdrawRecordRepository.updatesubject_purchase_record();
		
	}
	@Transactional
	@Override
	public void updateStatus(Integer sprId) {
	memberWithdrawRecordRepository.updateStatus(sprId);
		
	}
	@Transactional
	//修改投资金额
	@Override
	public void updateInvestAmount(Integer memberId) {
		memberAccountRepository.updateInvestAmount(memberId);
	}
	@Transactional
	//修改可用余额
	@Override
	public void updateUseAble(Integer memberId) {
		memberAccountRepository.updateUseAble(memberId);
		
	}
	@Transactional
	//修改冻结金额
	@Override
	public void updateImusealeBalance(Integer memberId) {
		memberAccountRepository.updateImusealeBalance(memberId);
		
	}
	@Transactional
	@Override
	public void updateTotal(Float total, Integer memberId) {
		memberAccountRepository.updateToatal(total, memberId);
		
	}
	@Transactional
	@Override
	public void UpdateShen(Integer sprId) {
	  memberWithdrawRecordRepository.UpdateShen(sprId);
		
	}
	@Transactional
	@Override
	public void Updatejd(Integer sprId) {
	memberWithdrawRecordRepository.Updatejd(sprId);
		
	}
	@Transactional
	@Override
	public void Updatedk(Integer sprId) {
		memberWithdrawRecordRepository.Updatedk(sprId);
		
	}
	@Override
	public void insertIn(MemberProfitRecord memberProfitRecord) {
	  memberProfitRecordRepository.save(memberProfitRecord);
	}

	@Override
	public List<MemberWithdrawRecord> findMemberWithdrawRecord(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page, Integer size,
			MemberWithdrawRecord memberWithdrawRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void UpdateStatus(Integer mwrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void UpdateJieD(Integer mwrId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] findSubjects(Integer memberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findMemberId(Integer mwrId) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
