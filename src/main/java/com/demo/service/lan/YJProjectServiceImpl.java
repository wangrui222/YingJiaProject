package com.demo.service.lan;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


	//后台-会员管理-全部用户查询
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
	//后台-会员管理-一个用户信息查询
	@Override
	public Members selectonemember(Integer mid) {
		return memberrepository.findOne(mid);
	}
	//后台-会员管理-一个用户资金查询
	@Override
	public MemberAccount selectmemberoneaccount(Integer mid) {

		return memberaccountrepository.findOne(mid);
	}
	//后台-会员管理-一个用户理财师查询
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerrepository.findOne(mid);
	}
	//后台-会员管理-一个用户提现查询
	@Override
	public MemberWithdrawRecord selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecordrepository.findOne(mid);
	}
	//后台-会员管理-一个用户钱包查询
	@Override
	public MemberTradeRecord selectoneonemembertraderecord(Integer mid) {		
		return membertraderecordrepository.findOne(mid);
	}
	
	
	//后台-会员管理-理财师审核
	@Override
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize) {		
		return memberrepository.selectfinancialplanner(maps, page, rowsize);
	}
	//后台-会员管理-理财师查询总数
	@Override
	public Integer getfinacialplannercount(Map<String, Object> maps) {
		 
		return memberrepository.getcounts(maps);
	}
	//后台-会员管理-绑卡管理
	@Override
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps, Integer page, Integer rowsize) {	
		return memberrepository.selectmemberbankcards(maps, page, rowsize);
	}
	//后台-会员管理-绑卡查询总数
	public Integer getselectmemberbankcardsrcount(Map<String, Object> maps) {
		return memberrepository.getcountsbankcards(maps);
	}
	//后台-会员管理-付息计划
	@Override
	public List<Object[]> selectmembersubject(Map<String, Object> maps, Integer page, Integer rowsize) {
		return memberrepository.selectsubject(maps, page, rowsize);
	}
	//后台-会员管理-付息计划查询总数
	@Override
	public Integer getselectmembersubjectcount(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return memberrepository.getcountssubject(maps);
	}



}
