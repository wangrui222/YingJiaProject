package com.demo.controller.jian;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.MemberAccount;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.SubjectOrderRecord;
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
	//充值管理
	@RequestMapping("sysmember/rechargeManage")
	public String toRechargeManage(Map<String, Object> map){
		List<SubjectOrderRecord> olist=subjectOrderRecordService.findSubjectOrderRecordService();
		map.put("olist", olist);
		return "/sysmember/czgl";
	}
	//提现管理
	@RequestMapping("sysmember/WithdrawManage")
	public String toWithdrawManage(Map<String, Object> map){
		List<MemberWithdrawRecord> mlist=memberWithdrawRecordService.findMemberWithdrawRecord();
		map.put("mlist", mlist);
		return "/sysmember/txgl";
	}
	//邀请奖励
	@RequestMapping("sysmember/inviteRewards")
	public String toinviteRewards(Map<String, Object> map){
        List<MemberAccount> mlist=memberAccountService.findMemberAccount();
        map.put("mlist", mlist);
		return "/sysmember/yqjl";
	}

}

