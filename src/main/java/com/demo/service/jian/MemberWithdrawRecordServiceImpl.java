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

import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.dao.jian.SubjectsRepository;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SubjectOrderRecord;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/
@Service
public class MemberWithdrawRecordServiceImpl implements MemberWithdrawRecordService {
	@Autowired
	MemberWithdrawRecordRepository memberWithdrawRecordRepository;
	@Autowired
	SubjectsRepository subjectsRepository;
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
	public Page<MemberWithdrawRecord> findMemberWithdrawRecord(Integer page, Integer size,final MemberWithdrawRecord memberWithdrawRecord) {
		Pageable pageable=new PageRequest(page-1, size);
		Specification<MemberWithdrawRecord> specification=new Specification<MemberWithdrawRecord>() {
			
			@Override
			public Predicate toPredicate(Root<MemberWithdrawRecord> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
			    List<Predicate> plist=new ArrayList<>();
			    if(memberWithdrawRecord!=null){
			    	//����
			    	if (memberWithdrawRecord.getMembers()!=null) {
						if(memberWithdrawRecord.getMembers()!=null&&memberWithdrawRecord.getMembers().getMemberName()!=null){					
							Join<MemberWithdrawRecord, Members> join=root.join("members");
							Path<String> pathMemberName=join.get("memberName");
							plist.add(builder.like(pathMemberName, memberWithdrawRecord.getMembers().getMemberName()+"%"));
						}
					}
                     //�ֻ���
			    	if(memberWithdrawRecord.getMembers()!=null&&!"".equals(memberWithdrawRecord.getMembers().getMobilePhone())){
						Join<MemberWithdrawRecord, Member> join=root.join("members");
						Path mobilePhonePath=join.get("mobilePhone");
						plist.add(builder.equal(mobilePhonePath,memberWithdrawRecord.getMembers().getMobilePhone()));

					}
			    	
			    	//�󿨿���
			    	if (memberWithdrawRecord.getBankCard()!=null&&!"".equals(memberWithdrawRecord.getBankCard())) {
						Path pathBankCard=root.get("bankCard");
						plist.add(builder.equal(pathBankCard,memberWithdrawRecord.getBankCard()));
					}
			    	//״̬
			    	if(memberWithdrawRecord.getStatus()!=null&&memberWithdrawRecord.getStatus()!=-1){
			    		Path pathStatus=root.get("status");
			    		plist.add(builder.equal(pathStatus, memberWithdrawRecord.getStatus()));
			    		
			    	}
			    	//����ʱ��
			    }
			    
				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return memberWithdrawRecordRepository.findAll(specification,pageable);
	}
	@Override
	public List<MemberWithdrawRecord> findMemberWithdrawRecord(Integer memberId) {
		
		return null;
	}
	@Transactional
	@Override
	public void UpdateStatus(Integer memberId) {
      memberWithdrawRecordRepository.updateStatus(memberId);
	}
	@Transactional
	@Override
	public void UpdateJieD(Integer mwrId) {
	memberWithdrawRecordRepository.updateJieD(mwrId);
		
	}
	@Override
	public Object[] findSubject(Integer memberId) {
		
		return subjectsRepository.findSubject(memberId);
	}
	@Override
	public Integer findMemberId(Integer mwrId) {
		return memberWithdrawRecordRepository.findMemberId(mwrId);
	}
	
}
