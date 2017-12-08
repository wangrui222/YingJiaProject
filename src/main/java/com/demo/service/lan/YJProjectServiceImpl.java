package com.demo.service.lan;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.FinancialplannerRepository;
import com.demo.dao.ldd.MembertraderecordRepository;
import com.demo.dao.ldd.MemberaccountRepository;
import com.demo.dao.ldd.MembersRepository;
import com.demo.dao.ldd.MemberwithdrawrecordRepository;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;

@Service
public class YJProjectServiceImpl implements YJProjectService{
	@Autowired
	MembersRepository memberrepository;
	@Autowired
	MemberaccountRepository memberaccountrepository;
	@Autowired
	FinancialplannerRepository financialplannerrepository;
	@Autowired
	MemberwithdrawrecordRepository memeberwithdrawrecordrepository;
	@Autowired
	MembertraderecordRepository membertraderecordrepository;


	//��̨-��Ա����-ȫ���û���ѯ
	@Override
	public Page<Members> selectmembers(final Members members,Integer page,Integer rowsize) {
		org.springframework.data.domain.Pageable pageable= new PageRequest(page-1, rowsize);
		Specification<Members> specification=new Specification<Members>() {
			@Override
			public Predicate toPredicate(Root<Members> paramRoot, CriteriaQuery<?> paramCriteriaQuery,
					CriteriaBuilder paramCriteriaBuilder) {
				List<Predicate> plist = new ArrayList();
				if(members!=null){
					if(members.getNames()!=null&&!"".equals(members.getNames())){
						Path path = paramRoot.get("names");
						plist.add(paramCriteriaBuilder.like(path, "%"+members.getNames()+"%"));
					}

					if(members.getMobilePhone()!=null&&!"".equals(members.getMobilePhone())){
						Path path = paramRoot.get("mobilePhone");
						plist.add(paramCriteriaBuilder.like(path, "%"+members.getMobilePhone()+"%"));
					}
					if(members.getMemberName()!=null&&!"".equals(members.getMemberName())){
						Path path = paramRoot.get("memberName");
						plist.add(paramCriteriaBuilder.like(path, "%"+members.getMemberName()+"%"));
					}
					if(members.getInvitationcode()!=null&&!"".equals(members.getInvitationcode())){
						Path path = paramRoot.get("invitationcode");
						plist.add(paramCriteriaBuilder.like(path, "%"+members.getInvitationcode()+"%"));
					}
					if(members.getCreateDate()!=null&&!"".equals(members.getCreateDate())){
						Path path = paramRoot.get("createDate");
						plist.add(paramCriteriaBuilder.equal(path,members.getCreateDate()));
					}
				}
				return paramCriteriaBuilder.and(plist.toArray(new Predicate[plist.size()]));
			}
		};
		return memberrepository.findAll(specification, pageable);
	}
	//��̨-��Ա����-һ���û���Ϣ��ѯ
	@Override
	public Members selectonemember(Integer mid) {
		return memberrepository.findOne(mid);
	}
	//��̨-��Ա����-һ���û��ʽ��ѯ
	@Override
	public MemberAccount selectmemberoneaccount(Integer mid) {

		return memberaccountrepository.findOne(mid);
	}
	//��̨-��Ա����-һ���û����ʦ��ѯ
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerrepository.findOne(mid);
	}
	//��̨-��Ա����-һ���û����ֲ�ѯ
	@Override
	public MemberWithdrawRecord selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecordrepository.findOne(mid);
	}
	//��̨-��Ա����-һ���û�Ǯ����ѯ
	@Override
	public MemberTradeRecord selectoneonemembertraderecord(Integer mid) {		
		return membertraderecordrepository.findOne(mid);
	}
	
	
	//��̨-��Ա����-���ʦ���
	@Override
	public List<Object[]> selectfinancialplanner() {
		
		return memberrepository.selectfinancialplanner();
	}



}
