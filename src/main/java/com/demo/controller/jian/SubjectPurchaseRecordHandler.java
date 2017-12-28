package com.demo.controller.jian;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.model.MemberProfitRecord;
import com.demo.model.Subject;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.service.jian.MemberWithdrawRecordService;

@RequestMapping("jian")
@Controller
public class SubjectPurchaseRecordHandler {
	@Autowired
	MemberWithdrawRecordService  memberWithdrawRecordService;
	@RequestMapping("sysmember/withdrawAudit/{sprId}/{flag}")
	public @ResponseBody Map tixian(@PathVariable("sprId") Integer sprId,@PathVariable("flag") String flag ){
		Map<String, String> map=new HashMap<String,String>();
		String code="";

		System.out.println(sprId);
		System.out.println(flag);
		//根据ID查询当前的这条购买记录
		SubjectPurchaseRecord spr=memberWithdrawRecordService.findSubjectPurchaseRecordById(sprId);
		float amount=spr.getAmount();
		Float lx=null;
		//审核
		if (flag.equals("shenhe")) {
			Integer memberId=spr.getMemberId();
			//计算收益
			Subject subject=memberWithdrawRecordService.findSubject(spr.getSubjectId());
			Integer day=this.getDay(spr.getCreateDate());
			lx=spr.getAmount()*subject.getYearRate()/100/365*day;
			//修改利息
			memberWithdrawRecordService.updateInterest(lx, sprId);
			//修改累计收益
			memberWithdrawRecordService.updateTotal(lx, memberId);
			//然后往MEMBER_PROFIT_RECORD中保存一条记录
			Calendar cal = Calendar.getInstance();
			Integer	year = cal.get(Calendar.YEAR);
			Integer	 month=cal.get(Calendar.MONTH);
			Integer date=cal.get(Calendar.DATE);
			MemberProfitRecord  memberProfitRecord=new MemberProfitRecord();
			memberProfitRecord.setSerialNumber(spr.getSerialNumber());
			memberProfitRecord.setAmount(amount);
			memberProfitRecord.setMemberId(memberId);
			memberProfitRecord.setMprType(null);
			memberProfitRecord.setDelflag(null);
			memberProfitRecord.setCreateDate(spr.getCreateDate());
			memberProfitRecord.setUpdateDate(spr.getUpdateDate());
			memberProfitRecord.setMprComment(subject.getSubjectComment());
			memberProfitRecord.setPurchaseId(spr.getSprId());
			memberProfitRecord.setProfitYear(year);
			memberProfitRecord.setProfitMonth(month);
			memberProfitRecord.setProfitDay(date);
			memberWithdrawRecordService.insertIn(memberProfitRecord);
			//审核后修改状态
			memberWithdrawRecordService.UpdateShen(sprId);

		}
		//解冻
		if(flag.equals("jiedong")){
			Integer memberId=spr.getMemberId();

			//修改投资金额
			memberWithdrawRecordService.updateInvestAmount(memberId);
			//修改可用余额
			memberWithdrawRecordService.updateUseAble(memberId);
			//修改冻结金额
			memberWithdrawRecordService.updateImusealeBalance(memberId);
			//修改状态
			memberWithdrawRecordService.Updatejd(sprId);

		}
		//贝付打款
		if(flag.equals("dakuan")){
			Integer memberId=spr.getMemberId();
			//计算收益
			Subject subject=memberWithdrawRecordService.findSubject(spr.getSubjectId());
			Integer day=this.getDay(spr.getCreateDate());
			lx=spr.getAmount()*subject.getYearRate()/100/365*day;

			Float useable_balance =amount+lx;
			//打款给可用余额
			memberWithdrawRecordService.updateUseable(useable_balance, memberId);	
			//打款修改状态
			memberWithdrawRecordService.Updatedk(sprId);
		}
		code="success";
		map.put("code", code);
		return map;
	}

	private Integer getDay(Date cdate){
		Long day = new Date().getTime();
		Long cday = cdate.getTime();
		Long d = (day-cday)/(1000*60*60*24);
		return Integer.parseInt(d.toString());

	}}