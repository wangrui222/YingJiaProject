package com.demo.controller.jian;

import java.util.Date;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.reflect.MemberSignature;

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
import com.demo.model.SubjectPurchaseRecord;
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
		map.put("members", members);
		return "/sysmember/czgl";
	}
	//提现管理
	@RequestMapping("sysmember/WithdrawManage")
	public String toWithdrawManage(Map<String, Object> map,Integer page,SubjectPurchaseRecord subjectPurchaseRecord){
		if(page==null){
			page=1;
		}
		Integer size=10;
		System.err.println(subjectPurchaseRecord);
		Page pagelist=memberWithdrawRecordService.findSubjectPurchaseRecord(page, size, subjectPurchaseRecord);
		pagelist.getContent();
		List<SelectProject> slist=selectProjectService.findSelectProjectService("cardStatus");
		map.put("slist", slist);
		map.put("pagelist", pagelist);
		map.put("subjectPurchaseRecord", subjectPurchaseRecord);
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
		map.put("memberAccount", memberAccount);
		map.put("members", members);
		map.put("awardRecords", awardRecords);
		return "/sysmember/yqjl";
	}
	//更新订单

	@RequestMapping("sysmember/rechargeManage/{sorId}")
	public String updateRechargeManage(@PathVariable Integer sorId,Map<String, Object> map){
		MemberDepositRecord memberDepositRecord=subjectOrderRecordService.findSubjectOrderRecordById(sorId);
		map.put("memberDepositRecord", memberDepositRecord);
		return "redirect:jian/sysmember/rechargeManage";
	}
	//审核、解冻、贝付打款
	@RequestMapping("sysmember/withdrawAudit")
	public String withdrawAudit(@PathVariable Integer memberId,String channelName){
	
  
		return "redirect:/jian/sysmember/WithdrawManage";
	}

	//奖励详情
	@RequestMapping("sysmember/inviteRewardsRecord/{memberId}")
	public String inviteRewardsRecord(@PathVariable Integer memberId,Map<String, Object> map){
		List<Object[]> mlist=memberAccountService.findAwardRecords(memberId);
		List<Object[]> olist=memberAccountService.findRecords(memberId);
		map.put("mlist", mlist);
		map.put("olist", olist);
		return "/sysmember/yqjl_record";
	}
  //注册奖励
	@RequestMapping("sysmember/zhucejiangli/{memberId}")
	public String zhucejiangli(@PathVariable Integer memberId){
		System.out.println(memberId);
		//修改状态 
		memberAccountService.updateIs(memberId);
		//奖励加到余额上
		memberAccountService.updateUser(memberId);
		
		
		//奖励记录标 
      Members members= memberAccountService.findMembers(memberId);
      AwardRecords awardRecords=new AwardRecords();
      awardRecords.setInvitingid(members.getMemberId());
      awardRecords.setByinvitingid(null);
      awardRecords.setAwardRecordsType(members.getStatus());
      awardRecords.setIsAward(null);
      awardRecords.setAmount(5f);
      awardRecords.setAddTime(new Date());
        memberAccountService.addjiang(awardRecords);
		return "redirect:/jian/sysmember/inviteRewards";
	}
}

