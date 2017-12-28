package com.demo.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.demo.service.jian.MemberWithdrawRecordService;
import com.demo.service.jian.SubjectOrderRecordService;

@Component
public class TaskUtil {
	@Autowired
    MemberWithdrawRecordService memberWithdrawRecordService;
	
	@Scheduled(cron = "0 0/1 15,* * * ?")
	public void test(){
		//去扫描到期时间的购买记录的数据
		System.out.println("=============================================================");
		memberWithdrawRecordService.updatesubject_purchase_record();
	}
}
