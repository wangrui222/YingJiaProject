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
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SubjectOrderRecord;

/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/
@Service
public class MemberWithdrawRecordServiceImpl implements MemberWithdrawRecordService {
	@Autowired
	MemberWithdrawRecordRepository memberWithdrawRecordRepository;
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
			    	//姓名
			    	if (memberWithdrawRecord.getMembers()!=null) {
						if(memberWithdrawRecord.getMembers()!=null&&memberWithdrawRecord.getMembers().getMemberName()!=null){					
							Join<MemberWithdrawRecord, Members> join=root.join("members");
							Path<String> pathMemberName=join.get("memberName");
							plist.add(builder.like(pathMemberName, memberWithdrawRecord.getMembers().getMemberName()+"%"));
						}
					}
                     //手机号
			    	if(memberWithdrawRecord.getMembers()!=null&&!"".equals(memberWithdrawRecord.getMembers().getMobilePhone())){
						Join<SubjectOrderRecord, Member> join=root.join("members");
						Path mobilePhonePath=join.get("mobilePhone");
						plist.add(builder.equal(mobilePhonePath,memberWithdrawRecord.getMembers().getMobilePhone()));

					}
			    	
			    	//绑卡卡号
			    	if (memberWithdrawRecord.getBankCard()!=null&&!"".equals(memberWithdrawRecord.getBankCard())) {
						Path pathBankCard=root.get("bankCard");
						plist.add(builder.equal(pathBankCard,memberWithdrawRecord.getBankCard()));
					}
			    	//状态
			    	if(memberWithdrawRecord.getStatus()!=null&&memberWithdrawRecord.getStatus()!=-1){
			    		Path pathStatus=root.get("status");
			    		plist.add(builder.equal(pathStatus, memberWithdrawRecord.getStatus()));
			    		
			    	}
			    	//提现时间
			    }
			    
				return builder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return memberWithdrawRecordRepository.findAll(specification,pageable);
	}
	@Transactional
	@Override
	public void addMemberWithdrawRecord(MemberWithdrawRecord memberWithdrawRecord) {
		memberWithdrawRecordRepository.save(memberWithdrawRecord);
		
	}
}
