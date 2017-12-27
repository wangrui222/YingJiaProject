package com.demo.service.lan;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Date;
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
import com.demo.dao.ldd.UsersRepository;
import com.demo.dao.ldd.UsersRoleRepository;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.Subject;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.model.UserRole;
import com.demo.model.Users;

@Service
public class YJProjectServiceImpl implements YJProjectService{
	//会员账号
	@Autowired
	MembersRepository memberrepository;
	//会员余额
	@Autowired
	MemberaccountRepository memberaccountrepository;
	//会员充值
	@Autowired
	MemberdepositrecordRepository memberdepositrecordrepository;
	//会员理财师审核
	@Autowired
	FinancialplannerRepository financialplannerrepository;
	//会员提现
	@Autowired
	MemberwithdrawrecordRepository memeberwithdrawrecordrepository;
	//会员钱包交易记录
	@Autowired
	MembertraderecordRepository membertraderecordrepository;
	//会员付息
	@Autowired
	SubjectpurchaserecordRepository subjectpurchaserecordrepository;
	//会员绑卡管理
	@Autowired
	MemberbankcardsRepository memberbankcarsrepository;
	/**------------------------------------------------------**/
	//账号设置
	@Autowired
	UsersRepository usersrepository;
	//账号设置-角色repository
	@Autowired
	UsersRoleRepository userrolerepository;
	
	
	/************************************************/
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

		return memberaccountrepository.selectMemberAccount(mid);
	}

	//后台-会员管理-一个用户理财师查询
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerrepository.selectFinancialPlannert(mid);
	}
	//后台-会员管理-一个用户提现查询
	@Override
	public List<MemberWithdrawRecord> selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecordrepository.selectMemberWithdrawRecord(mid);
	}
	//后台-会员管理-一个用户钱包查询
	@Override
	public List<MemberTradeRecord> selectoneonemembertraderecord(Integer mid) {		
		return membertraderecordrepository.selectMemberTradeRecord(mid);
	}
	//后台-会员管理-一个用户充值记录查询
	@Override
	public List<MemberDepositRecord> selectonememberdepositrecord(Integer mid) {
		return memberdepositrecordrepository.selectMemberDepositRecord(mid);
	}
	/*//后台-会员管理-一个用户投资记录查询
	@Override
	public List<SubjectPurchaseRecord> selectonesubjectpurchaserecord(Integer mid) {
		return subjectpurchaserecordrepository.selectSubjectPurchaseRecord(mid);
	}*/




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
	//后台-会员管理-理财师审核-修改状态
	@Override
	@Transactional
	public void updatestatus(Integer status,Integer id) {
		financialplannerrepository.updateFinancialPlannert(status, id);		
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
	//后台-会员管理-绑卡管理-修改状态
	@Override
	@Transactional
	public void updatedelflag(Integer delflag, Integer id) {
		memberbankcarsrepository.updateMemberbankcards(delflag, id);
	}
	//后台-会员管理-付息计划
	@Override
	public List<Object[]> selectmembersubject(Map<String, Object> maps, Integer page, Integer rowsize) {
		return memberrepository.selectsubject(maps, page, rowsize);
	}
	//后台-会员管理-付息计划查询总数
	@Override
	public Integer getselectmembersubjectcount(Map<String, Object> maps) {
		return memberrepository.getcountssubject(maps);
	}


	//后台-会员管理-付息计划-体验金付息
	@Override
	public List<Object[]> selectmembersubjectBbinpurchaserecord(Integer id, Integer page, Integer rowsize) {
		return memberrepository.selectsubjectBbinpurchaserecord(id, page, rowsize);
	}
	//后台-会员管理-付息计划查询总数
	@Override
	public Integer getselectmemberBbinpurchaserecordcount(Integer id) {
		
		return memberrepository.getcountssubjectBbinpurchaserecord(id);
	}
	//后台-会员管理-付息计划-付息列表
	@Override
	public List<Object[]> selectmembersubjectpurchaserecord(Integer id, Integer page, Integer rowsize) {
		
		return memberrepository.selectsubjectpurchaserecord(id, page, rowsize);
	}
	//后台-会员管理-付息列表查询总数
	@Override
	public Integer getselectmemberpurchaserecordcount(Integer id) {
		
		return memberrepository.getcountssubjectpurchaserecord(id);
	}

	/**===========================================================**/

	//后台-系统设置-账户设置-全部用户查询总数
	@Override
	public Integer getusercount() {
		return usersrepository.getcounts();
	}
	//后台-系统设置-账户设置-全部用户查询
	@Override
	public List<Object[]> selectuses(Integer page, Integer rowsize) {
		return usersrepository.selectusers(page, rowsize);
	}
	//后台-系统设置-账户设置-全部角色查询
	@Override
	public List<UserRole> selectuserrole() {
		return userrolerepository.findAll();
	}
	//后台-系统设置-账户设置-添加账号
	@Override
	@Transactional
	public void adduser(Users user) {
		usersrepository.save(user);
		
	}
	//后台-系统设置-账户设置-添加账号时判断账号是否存在
	@Override
	public List<Object[]> validateUserName(String uname) {
		return usersrepository.selectusersrole(uname);
	}
	//后台-系统设置-账户设置-按id查询一个账号
	@Override
	public Object[] selectoneuserrole(Integer uid) {	
		return usersrepository.selectoneusersrole(uid).get(0);
	}
	@Override
	public Users findone(Integer uid) {
		return usersrepository.findOne(uid);
	}
	@Override
	public Object findpassword(String name) {
		return usersrepository.selectpassword(name);
	}
	@Override
	public Object finduserid(String name) {
		return usersrepository.selectuserid(name);
	}
	
	//后台-系统设置-账户设置-修改账号
	@Override
	@Transactional
	public void updateuser(String pwd,String phone,Date update,Integer uid) {
		usersrepository.updatuser(pwd,phone,update,uid);
		
	}
	@Override
	@Transactional
	public void updateuserrole(Integer roleid, Integer uid) {
		usersrepository.updaterole(roleid, uid);
		
	}
	//后台-系统设置-账户设置-删除账号
	@Override
	@Transactional
	public void deleteuser(Integer uid) {
		usersrepository.delete(uid);
		
	}
	//后台-系统设置-角色设置-添加账号
	@Override
	@Transactional
	public void adduserrole(UserRole userrole) {
		userrolerepository.save(userrole);
		
	}
	//后台-系统设置-密码设置-修改密码
	@Override
	@Transactional
	public void updateuserpwd(String pwd,Integer uid) {
		usersrepository.updatepassword(pwd,uid);
		
	}
	//后台-系统设置-密码设置-修改密码时判断密码是否存在
	@Override
	public Object validateUserpwd(String uname) {		
		return usersrepository.selectpassword(uname);
	}
	//后台-会员管理-体验金付息按id查询三个信息
	@Override
	public Object selectmemberBbinpurchaserecordcount(Integer id) {		
		return memberrepository.selectsubjectBbinpurchaserecord(id);
	}
	
	
	
	
	
	






}
