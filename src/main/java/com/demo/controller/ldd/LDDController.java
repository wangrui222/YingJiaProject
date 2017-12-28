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
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.model.Subject;
import com.demo.service.lan.YJProjectService;
/**
 * ��̨��Ա����controller
 * @author ldd
 *
 */
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
		Integer rowsize=3;
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
		System.out.println(memberslist);
		map.put("memberslist", memberslist);

		MemberAccount membersaccountlist=yjprojectservice.selectmemberoneaccount(zid);
		map.put("membersaccountlist", membersaccountlist);


		FinancialPlanner FinancialPlannerlist=yjprojectservice.selectonefinancialplanner(zid);
		map.put("FinancialPlannerlist", FinancialPlannerlist);

		//���ּ�¼
		List<MemberWithdrawRecord> memberWithdrawRecord=yjprojectservice.selectoneonememberwithdrawrecord(zid);
		map.put("memberWithdrawRecord", memberWithdrawRecord);
		//Ǯ����¼
		List<MemberTradeRecord> membertraderecord=yjprojectservice.selectoneonemembertraderecord(zid);
		map.put("membertraderecord", membertraderecord);
		//��ֵ��¼
		List<MemberDepositRecord> memberdepositrecord=yjprojectservice.selectonememberdepositrecord(zid);
		map.put("memberdepositrecord", memberdepositrecord);
		//Ͷ�ʼ�¼
		List<Object[]> subjectpurchaserecord=yjprojectservice.selecttouzi(zid);
		map.put("subjectpurchaserecord", subjectpurchaserecord);


		return "/sysmember/member_info";

	}



	//��̨��Ա����-���ʦ��ѯsysmember/financiaAudit
	@RequestMapping(value="sysmember/financia")
	public String HYlcscx(Integer ss,String iphone,FinancialPlanner financialplanner,Integer page,Map<String, Object> map) {

		if (ss!=null&&!"".equals(ss)) {
			yjprojectservice.updatestatus(1, financialplanner.getMemberId());
		}
		System.out.println("000000000000000"+ss);
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
		Integer rowsize=10;
		//������
		Integer counts=yjprojectservice.getfinacialplannercount(maps);

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

		yjprojectservice.updatestatus(0, id);
		System.out.println("-----------------------");
		return "redirect:/ldd/sysmember/financia";

	}
	//��̨��Ա����-�󿨹���
	@RequestMapping(value="sysmember/dahua")
	public String HYbkgl(Integer del,String mobilePhone,String memberName,MemberBankcards memberbankcards,Integer page,Map<String, Object> map) {
		System.out.println("========"+del);
		if (del!=null&&!"".equals(del)) {
			yjprojectservice.updatedelflag(1, memberbankcards.getMemberId());
		}	
		Map<String, Object> maps=new HashMap<>();
		maps.put("iphone", mobilePhone);
		maps.put("name", memberName);
		maps.put("CardNo", memberbankcards.getCardNo());
		maps.put("time", memberbankcards.getCreateDate());
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=10;
		//������
		Integer counts=yjprojectservice.getselectmemberbankcardsrcount(maps);

		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectmemberbankcards(maps, page, rowsize);
		map.put("list", list);
		for (Object[] objects : list) {
			System.out.println("========"+objects[4]);
		}
		return "/sysmember/bkgl";

	}
	//��̨��Ա����-��Ϣ�ƻ�
	@RequestMapping(value="sysmember/payment")
	public String HYfxjh(Subject subject,Integer page,Map<String, Object> map) {
		Map<String, Object> maps=new HashMap<>();
		maps.put("name", subject.getSubjectName());
		maps.put("status", subject.getStatus());
		maps.put("type", subject.getSubjectType());
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=10;
		//������
		Integer counts=yjprojectservice.getselectmembersubjectcount(maps);
		System.out.println("========"+counts);
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectmembersubject(maps, page, rowsize);
		map.put("list", list);
		
		return "/sysmember/fxjh";

	}

	//��̨��Ա����-��Ϣ�ƻ�-�����Ϣ
	@RequestMapping(value="sysmember/paymentBbinContent/{id}")
	public String HYfxjhtyjfx(@PathVariable(value="id") Integer id,Integer page,Map<String, Object> map) {
		Object subject=yjprojectservice.selectmemberBbinpurchaserecordcount(id);
		map.put("subject", subject);
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=10;
		//������
		Integer counts=yjprojectservice.getselectmemberBbinpurchaserecordcount(id);
		System.out.println("========"+counts);
		if (counts==null) {
			counts=1;
		}
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectmembersubjectBbinpurchaserecord(id, page, rowsize);
		System.out.println(list);
		map.put("list", list);
		return "/sysmember/fxjh_bbin_content";
	}
	//��̨��Ա����-��Ϣ�ƻ�-��Ϣ�б�
	@RequestMapping(value="sysmember/paymentContent/{id}")
	public String HYfxjhfxlb(@PathVariable(value="id") Integer id,Integer page,Map<String, Object> map) {
		System.out.println("-----------------------------"+id);
		Object subject=yjprojectservice.selectmemberBbinpurchaserecordcount(id);
		map.put("subject", subject);
		//��ǰ�ڼ�ҳ
		if (page==null) {
			page=1;
		}
		map.put("page", page);
		Integer rowsize=10;
		//������
		Integer counts=yjprojectservice.getselectmemberpurchaserecordcount(id);
		System.out.println("========"+counts);
		if (counts==null) {
			counts=1;
		}
		//��ҳ��
		Integer allpage=counts%rowsize==0?counts/rowsize:counts/rowsize+1;
		map.put("allpage", allpage);
		List<Object[]> list=yjprojectservice.selectmembersubjectpurchaserecord(id, page, rowsize);
		map.put("list", list);		
		return "/sysmember/fxjh_content";
	}

	@InitBinder    
	public void initBinder(WebDataBinder binder) {    
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));    
	}
}
