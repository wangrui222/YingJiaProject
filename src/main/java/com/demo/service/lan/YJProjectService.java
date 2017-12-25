package com.demo.service.lan;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.model.UserRole;
import com.demo.model.Users;

public interface YJProjectService {
	//后台-会员管理-全部用户查询
	public Page<Members> selectmembers(final Members members,Integer page,Integer rowsize);
	//后台-会员管理-一个用户信息查询
	public Members selectonemember(Integer mid);	
	//后台-会员管理-一个用户资金查询
	public MemberAccount selectmemberoneaccount(Integer mid);
	//后台-会员管理-一个用户理财师查询
	public FinancialPlanner selectonefinancialplanner(Integer mid);


	//后台-会员管理-一个用户提现查询
	public List<MemberWithdrawRecord> selectoneonememberwithdrawrecord(Integer mid);
	//后台-会员管理-一个用户所有钱包查询
	public List<MemberTradeRecord> selectoneonemembertraderecord(Integer mid);
	//后台-会员管理-一个用户所有充值记录查询
	public List<MemberDepositRecord> selectonememberdepositrecord(Integer mid);
	/*//后台-会员管理-一个用户所有投资记录查询
	public List<SubjectPurchaseRecord> selectonesubjectpurchaserecord(Integer mid);
	 */



	//后台-会员管理-理财师审核
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//后台-会员管理-理财师查询总数
	public Integer getfinacialplannercount(Map<String, Object> maps);
	//后台-会员管理-理财师审核-修改状态
	public void updatestatus(Integer status,Integer id);



	//后台-会员管理-绑卡管理
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);
	//后台-会员管理-绑卡管理查询总数
	public Integer getselectmemberbankcardsrcount(Map<String, Object> maps);
	//后台-会员管理-绑卡管理--修改状态
	public void updatedelflag(Integer delflag,Integer id);


	//后台-会员管理-付息计划
	public List<Object[]> selectmembersubject(Map<String, Object> maps,Integer page,Integer rowsize);
	//后台-会员管理-理财师查询总数
	public Integer getselectmembersubjectcount(Map<String, Object> maps);
	//后台-会员管理-付息计划-体验金付息
	public List<Object[]> selectmembersubjectBbinpurchaserecord(Integer id,Integer page,Integer rowsize);
	//后台-会员管理-体验金付息查询总数
	public Integer getselectmemberBbinpurchaserecordcount(Integer id);
	//后台-会员管理-付息计划-体验金付息
	public List<Object[]> selectmembersubjectpurchaserecord(Integer id,Integer page,Integer rowsize);
	//后台-会员管理-体验金付息查询总数
	public Integer getselectmemberpurchaserecordcount(Integer id);

	//==========================================================

	//后台-系统设置-账户设置-全部用户查询
	public List<Object[]> selectuses(Integer page,Integer rowsize);
	//后台-系统设置-账户设置-全部用户查询总数
	public Integer getusercount();
	//后台-系统设置-账户设置-全部角色查询
	public List<UserRole> selectuserrole();
	//后台-系统设置-账户设置-添加账号
	public void adduser(Users user);
	//后台-系统设置-账户设置-添加账号时判断用户名
	public List<Object[]> validateUserName(String uname);
	//后台-系统设置-账户设置-按id查询一个账号
	public Object[] selectoneuserrole(Integer uid);
	public Users findone(Integer uid);
	public Object findpassword(String name);
	public Object finduserid(String name);
	

	//后台-系统设置-账户设置-修改账号
	public void updateuser(String pwd,String phone,Date update,Integer uid);
	public void updateuserrole(Integer roleid,Integer uid);
	//后台-系统设置-账户设置-删除账号
	public void deleteuser(Integer uid);


	//后台-系统设置-角色设置-添加角色
	public void adduserrole(UserRole userrole);
	//后台-系统设置-密码设置-修改密码
	public void updateuserpwd(String pwd,Integer uid);
	//后台-系统设置-账户设置-修改账号时判断密码是否纯在
	public List<Object[]> validateUserpwd(String pwd);








}
