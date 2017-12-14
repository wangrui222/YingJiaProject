package com.demo.controller.jian;

import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.demo.model.MemberWithdrawRecord;
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
	public String toRechargeManage( Integer page,SubjectOrderRecord subjectOrderRecord,Map<String, Object> map){
		if(page==null){
			page=1;
		}
		Integer size=2;
		System.out.println(page);
		System.out.println(subjectOrderRecord);
		Page pagelist=subjectOrderRecordService.pageSubjectOrderRecordService(page, size,subjectOrderRecord);
		List<SelectProject> slist=selectProjectService.findSelectProjectService("orderStatus");
		map.put("slist", slist);
		map.put("pagelist", pagelist);
	    map.put("subjectOrderRecord", subjectOrderRecord);
		return "/sysmember/czgl";
	}
	//提现管理
	@RequestMapping("sysmember/WithdrawManage")
	public String toWithdrawManage(Map<String, Object> map,Integer page,MemberWithdrawRecord memberWithdrawRecord){
		if(page==null){
			page=1;
		}
		Integer size=2;
		System.err.println(memberWithdrawRecord);
		Page pagelist=memberWithdrawRecordService.findMemberWithdrawRecord(page, size,memberWithdrawRecord);
		pagelist.getContent();
		List<SelectProject> slist=selectProjectService.findSelectProjectService("cardStatus");
		map.put("slist", slist);
		map.put("pagelist", pagelist);
		return "/sysmember/txgl";
	}
	//邀请奖励
	@RequestMapping("sysmember/inviteRewards")
	public String toinviteRewards(Map<String, Object> map,Integer page){
		if(page==null){
			page=1;
		}
		Integer size=2;
        Page pagelist=memberAccountService.findMemberAccount(size, page);
   
        map.put("pagelist", pagelist);
		return "/sysmember/yqjl";
	}
	//更新订单
	
	@RequestMapping("sysmember/rechargeManage/{sorId}")
	public String updateRechargeManage(@PathVariable Integer sorId,Map<String, Object> map){
        SubjectOrderRecord subjectOrderRecord=subjectOrderRecordService.findSubjectOrderRecordById(sorId);
        map.put("subjectOrderRecord", subjectOrderRecord);
		return "redirect:jian/sysmember/rechargeManage";
	}

}

