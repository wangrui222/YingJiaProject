package com.demo.controller.jian;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.SubjectOrderRecord;
import com.demo.service.jian.SubjectOrderRecordService;

/**
 * @author thinkpad
 * @time 2017��12��6������12:08:16
 */
@Controller
public class SubjectOrderRecordHandler {
	@Autowired
	SubjectOrderRecordService subjectOrderRecordService;
	@RequestMapping("rechargeManage")
	public String toRechargeManage(Map<String, Object> map){
		List<SubjectOrderRecord> olist=subjectOrderRecordService.findSubjectOrderRecordService();
		map.put("olist", olist);
		return "sysmember/czgl.jsp";
		}
	}

