package com.demo.controller.jian;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.AwardRecords;
import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.SelectProject;
import com.demo.model.SubjectOrderRecord;
import com.demo.service.SelectProjectService;
import com.demo.service.jian.MemberAccountService;
import com.demo.service.jian.MemberWithdrawRecordService;
import com.demo.service.jian.SubjectOrderRecordService;

/**
 * @author thinkpad
 * @time 2017年12月6日下午12:08:16
 */
@Controller
@RequestMapping("jian")
public class SubjectOrderRecordHandler {
	@Autowired
	SubjectOrderRecordService subjectOrderRecordService;
	@Autowired
	MemberWithdrawRecordService  memberWithdrawRecordService;
	@Autowired
	MemberAccountService memberAccountService;
	@Autowired
	SelectProjectService selectProjectService;

	//充值管理
	@RequestMapping("sysmember/rechargeManage")
	public String toRechargeManage( Integer page,MemberDepositRecord memberDepositRecord,Map<String, Object> map,Members members){
		if(page==null){
			page=1;
		}
		Integer size=10;
		Integer count=subjectOrderRecordService.selectCount(memberDepositRecord, members);
		Integer pages=count%size==0?count/size:count/size+1;
		List<Object[]> plist=subjectOrderRecordService.selectMemberDepositRecord(page, size, memberDepositRecord, members);
		List<SelectProject> slist=selectProjectService.findSelectProjectService("orderStatus");
		map.put("slist", slist);
		map.put("pages", pages);
		map.put("page", page);
		map.put("plist", plist);
		map.put("memberDepositRecord", memberDepositRecord);
		return "/sysmember/czgl";
	}
	//提现管理
	@RequestMapping("sysmember/WithdrawManage")
	public String toWithdrawManage(Map<String, Object> map,Integer page,MemberWithdrawRecord memberWithdrawRecord){
		if(page==null){
			page=1;
		}
		Integer size=10;
		System.err.println(memberWithdrawRecord);
		Page pagelist=memberWithdrawRecordService.findMemberWithdrawRecord(page, size,memberWithdrawRecord);
		pagelist.getContent();
		List<SelectProject> slist=selectProjectService.findSelectProjectService("cardStatus");
		map.put("slist", slist);
		map.put("pagelist", pagelist);
		map.put("memberWithdrawRecord", memberWithdrawRecord);
		return "/sysmember/txgl";
	}
	//邀请奖励
	@RequestMapping("sysmember/inviteRewards")
	public String toinviteRewards(Map<String, Object> map,Integer page,MemberAccount memberAccount,Members members,AwardRecords awardRecords){
		if(page==null){
			page=1;
		}
		Integer size=10;
		Integer count=memberAccountService.selectCount(memberAccount, members, awardRecords);
		Integer pages=count%size==0?count/size:count/size+1;
		List<Object[]> pagelist=memberAccountService.findMemberAccount(size, page, memberAccount, members, awardRecords);
		map.put("pages", pages);
		map.put("page", page);
		map.put("pagelist", pagelist);
		return "/sysmember/yqjl";
	}
	//更新订单

	@RequestMapping("sysmember/rechargeManage/{sorId}")
	public String updateRechargeManage(@PathVariable Integer sorId,Map<String, Object> map){
		MemberDepositRecord memberDepositRecord=subjectOrderRecordService.findSubjectOrderRecordById(sorId);
		map.put("memberDepositRecord", memberDepositRecord);
		return "redirect:jian/sysmember/rechargeManage";
	}
	//审核
	@RequestMapping("sysmember/withdrawAudit")
	public String withdrawAudit(@PathVariable Integer memberId,String channelName){
		
		//修改状态
		memberWithdrawRecordService.UpdateStatus(memberId);
		Object[]o= memberWithdrawRecordService.findSubject(memberId);
		//标的周期
		Integer period=(Integer) o[0];
		//年花率
		float yearRate=(float) o[1]/100;
		//可用余额
		float userAble=(float) o[2];
		//收益
		float total=period*yearRate*userAble;
		//累计收益修改
        memberAccountService.upateTotal(total, memberId);
		//打款方式
  
		return "redirect:/jian/sysmember/WithdrawManage";
	}
	//解冻
	@RequestMapping("sysmember/WithdrawUnfreeze/{mwrId}")
	public String WithdrawUnfreeze(@PathVariable Integer mwrId){
		memberWithdrawRecordService.UpdateJieD(mwrId);


		return "redirect:/jian/sysmember/WithdrawManage";
	}
	//贝付打款


	//奖励详情
	@RequestMapping("sysmember/inviteRewardsRecord/{memberId}")
	public String inviteRewardsRecord(@PathVariable Integer memberId,Map<String, Object> map){
		List<Object[]> mlist=memberAccountService.findAwardRecords(memberId);
		List<Object[]> olist=memberAccountService.findRecords(memberId);
		map.put("mlist", mlist);
		map.put("olist", olist);
		return "/sysmember/yqjl_record";
	}


}

