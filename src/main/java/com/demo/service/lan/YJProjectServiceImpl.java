package com.demo.service.lan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ldd.FinancialplannerDao;
import com.demo.dao.ldd.MemberaccountDao;
import com.demo.dao.ldd.MemberpucchargeitemDao;
import com.demo.dao.ldd.MembersDao;
import com.demo.dao.ldd.MemberwithdrawrecordDao;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
@Service
public class YJProjectServiceImpl implements YJProjectService{
	@Autowired
	MembersDao memberdao;
	@Autowired
	MemberaccountDao memberaccountdao;
	@Autowired
	FinancialplannerDao financialplannerdao;
	@Autowired
	MemberwithdrawrecordDao memeberwithdrawrecorddao;
	@Autowired
	MemberpucchargeitemDao memberpucchargeitemdao;
	
	
	//后台-会员管理-全部用户查询
	@Override
	public List<Members> selectmembers() {
		
		return memberdao.findAll();
	}
	//后台-会员管理-一个用户信息查询
	@Override
	public Members selectonemember(Integer mid) {
		return memberdao.findOne(mid);
	}
	//后台-会员管理-一个用户资金查询
	@Override
	public MemberAccount selectmemberoneaccount(Integer mid) {
		
		return memberaccountdao.findOne(mid);
	}
	//后台-会员管理-一个用户理财师查询
	@Override
	public FinancialPlanner selectonefinancialplanner(Integer mid) {
		return financialplannerdao.findOne(mid);
	}
	//后台-会员管理-一个用户提现查询
	@Override
	public MemberWithdrawRecord selectoneonememberwithdrawrecord(Integer mid) {
		return memeberwithdrawrecorddao.findOne(mid);
	}
	//后台-会员管理-一个用户钱包查询
	@Override
	public MemberPucChargeItem selectoneonememberpucchargeitem(Integer mid) {		
		return memberpucchargeitemdao.findOne(mid);
	}
	
	

}
