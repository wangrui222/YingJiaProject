package com.demo.controller.ldd;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.service.lan.YJProjectService;
@Controller
@RequestMapping(value="ldd")
public class LDDController {
	@Autowired
	YJProjectService yjprojectservice;
	//后台会员管理-账号管理
	@RequestMapping(value="sysmember/index")
	public String HYzhgl(Map<String, Object> map) {
		System.out.println("111111111111");
		List<Members> memberslist=yjprojectservice.selectmembers();
		map.put("memberslist", memberslist);
		System.out.println(memberslist);
		return "/sysmember/zhgl";

	}
	//后台会员管理-详细账号-账号
	@RequestMapping(value="sysmember/memberInfo/{zid}")
	public String HYxxzhgl(@PathVariable("zid")Integer zid,Map<String, Object> map) {
		System.out.println("==="+zid);
		Members memberslist=yjprojectservice.selectonemember(zid);
		map.put("memberslist", memberslist);
		
		MemberAccount membersaccountlist=yjprojectservice.selectmemberoneaccount(zid);
		map.put("membersaccountlist", membersaccountlist);
		
		FinancialPlanner FinancialPlannerlist=yjprojectservice.selectonefinancialplanner(zid);
		map.put("FinancialPlannerlist", FinancialPlannerlist);
		
		MemberWithdrawRecord memberWithdrawRecord=yjprojectservice.selectoneonememberwithdrawrecord(zid);
		map.put("memberWithdrawRecord", memberWithdrawRecord);
		
		MemberPucChargeItem memberpucchargeitem=yjprojectservice.selectoneonememberpucchargeitem(zid);
		map.put("memberpucchargeitem", memberpucchargeitem);
		
		return "/sysmember/member_info";

	}
	/*//后台会员管理-详细账号-资金查询
	@RequestMapping(value="sysmember/memberInfo/{zid}")
	public String HYxxzhglzj(@PathVariable("zid")Integer zid,Map<String, Object> map) {
		System.out.println("==="+zid);
		List<Members> memberslist=yjprojectservice.selectonemember(zid);
		map.put("memberslist", memberslist);
		return "/sysmember/member_info";

	}*/
	//后台会员管理-理财师审核
	@RequestMapping(value="sysmember/financia")
	public String HYlcssh() {

		return "/sysmember/financia";

	}
	//后台会员管理-绑卡管理
	@RequestMapping(value="sysmember/dahua")
	public String HYbkgl() {

		return "/sysmember/bkgl";

	}
	//后台会员管理-付息计划
	@RequestMapping(value="sysmember/payment")
	public String HYfxjh() {

		return "/sysmember/fxjh";

	}
}
