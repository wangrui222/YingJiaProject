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
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.FinancialplannerRepository;

import com.demo.dao.ldd.MembertraderecordRepository;
import com.demo.dao.ldd.MemberaccountRepository;
import com.demo.dao.ldd.MemberbankcardsRepository;
import com.demo.dao.ldd.MemberdepositrecordRepository;
import com.demo.dao.ldd.MembersRepository;
import com.demo.dao.ldd.MemberwithdrawrecordRepository;
import com.demo.dao.ldd.SubjectpurchaserecordRepository;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SubjectPurchaseRecord;

@Service
public class YJProjectServiceImpl implements YJProjectService{
	@Autowired
	MembersRepository memberrepository;
	@Autowired
	MemberaccountRepository memberaccountrepository;
	@Autowired
	MemberdepositrecordRepository memberdepositrecordrepository;
	@Autowired
	FinancialplannerRepository financialplannerrepository;
	@Autowired
	MemberwithdrawrecordRepository memeberwithdrawrecordrepository;
	@Autowired
	MembertraderecordRepository membertraderecordrepository;
	@Autowired
	SubjectpurchaserecordRepository subjectpurchaserecordrepository;
	@Autowired
	MemberbankcardsRepository memberbankcarsrepository;

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

		return memberaccountrepository.selectMemberAccount(mid);
	}
	
	//��̨-��Ա����-һ���û����ʦ��ѯ
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerrepository.selectFinancialPlannert(mid);
	}
	//��̨-��Ա����-һ���û����ֲ�ѯ
	@Override
	public List<MemberWithdrawRecord> selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecordrepository.selectMemberWithdrawRecord(mid);
	}
	//��̨-��Ա����-һ���û�Ǯ����ѯ
	@Override
	public List<MemberTradeRecord> selectoneonemembertraderecord(Integer mid) {		
		return membertraderecordrepository.selectMemberTradeRecord(mid);
	}
	//��̨-��Ա����-һ���û���ֵ��¼��ѯ
	@Override
	public List<MemberDepositRecord> selectonememberdepositrecord(Integer mid) {
		return memberdepositrecordrepository.selectMemberDepositRecord(mid);
	}
	/*//��̨-��Ա����-һ���û�Ͷ�ʼ�¼��ѯ
	@Override
	public List<SubjectPurchaseRecord> selectonesubjectpurchaserecord(Integer mid) {
		return subjectpurchaserecordrepository.selectSubjectPurchaseRecord(mid);
	}*/
	
	
	

	//��̨-��Ա����-���ʦ���
	@Override
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize) {		
		return memberrepository.selectfinancialplanner(maps, page, rowsize);
	}
	//��̨-��Ա����-���ʦ��ѯ����
	@Override
	public Integer getfinacialplannercount(Map<String, Object> maps) {

		return memberrepository.getcounts(maps);
	}
	//��̨-��Ա����-���ʦ���-�޸�״̬
	@Override
	@Transactional
	public void updatestatus(Integer status,Integer id) {
		financialplannerrepository.updateFinancialPlannert(status, id);		
	}
	
	
	
	//��̨-��Ա����-�󿨹���
	@Override
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps, Integer page, Integer rowsize) {	
		return memberrepository.selectmemberbankcards(maps, page, rowsize);
	}
	//��̨-��Ա����-�󿨲�ѯ����
	public Integer getselectmemberbankcardsrcount(Map<String, Object> maps) {
		return memberrepository.getcountsbankcards(maps);
	}
	//��̨-��Ա����-�󿨹���-�޸�״̬
	@Override
	@Transactional
	public void updatedelflag(Integer delflag, Integer id) {
		memberbankcarsrepository.updateMemberbankcards(delflag, id);
	}
	//��̨-��Ա����-��Ϣ�ƻ�
	@Override
	public List<Object[]> selectmembersubject(Map<String, Object> maps, Integer page, Integer rowsize) {
		return memberrepository.selectsubject(maps, page, rowsize);
	}
	//��̨-��Ա����-��Ϣ�ƻ���ѯ����
	@Override
	public Integer getselectmembersubjectcount(Map<String, Object> maps) {
		// TODO Auto-generated method stub
		return memberrepository.getcountssubject(maps);
	}


	//��̨-��Ա����-��Ϣ�ƻ�-�����Ϣ
	@Override
	public List<Object[]> selectmembersubjectBbinpurchaserecord(Integer id, Integer page, Integer rowsize) {
		return memberrepository.selectsubjectBbinpurchaserecord(id, page, rowsize);
	}
	//��̨-��Ա����-��Ϣ�ƻ���ѯ����
	@Override
	public Integer getselectmemberBbinpurchaserecordcount(Integer id) {
		// TODO Auto-generated method stub
		return memberrepository.getcountssubjectBbinpurchaserecord(id);
	}
	//��̨-��Ա����-��Ϣ�ƻ�-��Ϣ�б�
	@Override
	public List<Object[]> selectmembersubjectpurchaserecord(Integer id, Integer page, Integer rowsize) {
		// TODO Auto-generated method stub
		return memberrepository.selectsubjectpurchaserecord(id, page, rowsize);
	}
	//��̨-��Ա����-��Ϣ�б��ѯ����
	@Override
	public Integer getselectmemberpurchaserecordcount(Integer id) {
		// TODO Auto-generated method stub
		return memberrepository.getcountssubjectpurchaserecord(id);
	}
	
	
	
	


}
