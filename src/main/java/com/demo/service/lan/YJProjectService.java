package com.demo.service.lan;

import java.util.List;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.Members;

public interface YJProjectService {
	//后台-会员管理-全部用户查询
	public List<Members> selectmembers();
	//后台-会员管理-一个用户信息查询
	public Members selectonemember(Integer mid);	
	//后台-会员管理-一个用户资金查询
	public MemberAccount selectmemberoneaccount(Integer mid);
	//后台-会员管理-一个用户理财师查询
	public FinancialPlanner selectonefinancialplanner(Integer mid);
}
