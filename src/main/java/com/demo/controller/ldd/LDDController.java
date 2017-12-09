package com.demo.controller.ldd;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberBankcards;
import com.demo.model.MemberPucChargeItem;
import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.service.lan.YJProjectService;
@Controller
@RequestMapping(value="ldd")
public class LDDController {
	@Autowired
	YJProjectService yjprojectservice;
	//��̨��Ա����-�˺Ź���
	@RequestMapping(value="sysmember/index")
	public String HYzhgl(Members members,Integer page,Map<String, Object> map) {
		System.out.println("==========="+members.getNames());
		if (page==null) {
			page=1;
		}
		Integer rowsize=1;
		Page<Members> memberslist=yjprojectservice.selectmembers(members, page, rowsize);

		//��ǰ�ڼ�ҳ
		map.put("pages", memberslist.getNumber()+1);
		System.out.println(memberslist.getNumber());
		//��ҳ��
		map.put("counts", memberslist.getTotalPages());
		System.out.println(memberslist.getTotalPages());
		//��ǰ�����
		map.put("lists", memberslist.getContent());
		System.out.println(memberslist.getContent());


		map.put("members", members);

		return "/sysmember/zhgl";

	}
	//��̨��Ա����-��ϸ�˺�-�˺�
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

		MemberTradeRecord membertraderecord=yjprojectservice.selectoneonemembertraderecord(zid);
		map.put("membertraderecord", membertraderecord);

		return "/sysmember/member_info";

	}



	//��̨��Ա����-���ʦ��ѯsysmember/financiaAudit
	@RequestMapping(value="sysmember/financia")
	public String HYlcscx(String iphone,FinancialPlanner financialplanner,Integer page,Map<String, Object> map) {
		Map<String, Object> maps=new HashMap<>();
		maps.put("iphone", iphone);
		maps.put("name", financialplanner.getFinancialPlannerName());
		maps.put("status", financialplanner.getStatus());
		maps.put("time", financialplanner.getCreateDate());
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=1;
		//������
		Integer counts=yjprojectservice.getfinacialplannercount(maps);
		System.out.println("========"+counts);
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectfinancialplanner(maps, page, rowsize);
		map.put("list", list);

		return "/sysmember/financia";

	}
	//��̨��Ա����-���ʦ���
	@RequestMapping(value="sysmember/financiaAudit/{id}")
	public String HYlcssh(@PathVariable(value="id")Integer id,Map<String, Object> map) {

		return "";

	}
	//��̨��Ա����-�󿨹���
	@RequestMapping(value="sysmember/dahua")
	public String HYbkgl(String iphone,String name,MemberBankcards memberbankcards,Integer page,Map<String, Object> map) {
		Map<String, Object> maps=new HashMap<>();
		maps.put("iphone", iphone);
		maps.put("name", name);
		maps.put("status", memberbankcards.getCardNo());
		maps.put("time", memberbankcards.getCreateDate());
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=1;
		//������
		Integer counts=yjprojectservice.getselectmemberbankcardsrcount(maps);
		System.out.println("========"+counts);
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectmemberbankcards(maps, page, rowsize);
		map.put("list", list);

		return "/sysmember/bkgl";

	}
	//��̨��Ա����-��Ϣ�ƻ�
	@RequestMapping(value="sysmember/payment")
	public String HYfxjh() {
		
		return "/sysmember/fxjh";

	}
	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));    
	}
}
