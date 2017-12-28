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
		//����ID��ѯ��ǰ�����������¼
		SubjectPurchaseRecord spr=memberWithdrawRecordService.findSubjectPurchaseRecordById(sprId);
		float amount=spr.getAmount();
		Float lx=null;
		//���
		if (flag.equals("shenhe")) {
			Integer memberId=spr.getMemberId();
			//��������
			Subject subject=memberWithdrawRecordService.findSubject(spr.getSubjectId());
			Integer day=this.getDay(spr.getCreateDate());
			lx=spr.getAmount()*subject.getYearRate()/100/365*day;
			//�޸���Ϣ
			memberWithdrawRecordService.updateInterest(lx, sprId);
			//�޸��ۼ�����
			memberWithdrawRecordService.updateTotal(lx, memberId);
			//Ȼ����MEMBER_PROFIT_RECORD�б���һ����¼
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
			//��˺��޸�״̬
			memberWithdrawRecordService.UpdateShen(sprId);

		}
		//�ⶳ
		if(flag.equals("jiedong")){
			Integer memberId=spr.getMemberId();

			//�޸�Ͷ�ʽ��
			memberWithdrawRecordService.updateInvestAmount(memberId);
			//�޸Ŀ������
			memberWithdrawRecordService.updateUseAble(memberId);
			//�޸Ķ�����
			memberWithdrawRecordService.updateImusealeBalance(memberId);
			//�޸�״̬
			memberWithdrawRecordService.Updatejd(sprId);

		}
		//�������
		if(flag.equals("dakuan")){
			Integer memberId=spr.getMemberId();
			//��������
			Subject subject=memberWithdrawRecordService.findSubject(spr.getSubjectId());
			Integer day=this.getDay(spr.getCreateDate());
			lx=spr.getAmount()*subject.getYearRate()/100/365*day;

			Float useable_balance =amount+lx;
			//�����������
			memberWithdrawRecordService.updateUseable(useable_balance, memberId);	
			//����޸�״̬
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