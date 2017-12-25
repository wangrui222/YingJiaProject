package com.demo.controller.wr.product;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.wr.FinanceProductFundsRepository;
import com.demo.dao.wr.OverseaConfigRepository;
import com.demo.dao.wr.SubjectPurchaseRecordRepository;
import com.demo.dao.wr.SubjectRepository;
import com.demo.model.FinanceProductFunds;
import com.demo.model.MemberTradeRecord;
import com.demo.model.Members;
import com.demo.model.OverseaConfig;
import com.demo.model.Subject;
import com.demo.model.SubjectOrderRecord;
import com.demo.model.SubjectPurchaseRecord;
import com.demo.service.jian.MemberAccountService;
import com.demo.service.wr.FinanceProductFundService;
import com.demo.service.wr.MemberAmountService;
import com.demo.service.wr.MemberTradeRecordService;
import com.demo.service.wr.OverseaConfigService;
import com.demo.service.wr.SubjectPurchaseRecordService;
import com.demo.service.wr.SubjectService;
import com.demo.until.ResponseMsg;

@Controller
@RequestMapping("/product")
public class ProductsController {

	private static final Integer rowsize = 5;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	FinanceProductFundsRepository fPFundsRepository;

	@Autowired
	OverseaConfigRepository overseaConfigRepository;

	@Autowired
	SubjectPurchaseRecordRepository subjectPurchaseRecordRepository;

	@Autowired
	SubjectService subjectService;

	@Autowired
	FinanceProductFundService financeProductFundService;

	@Autowired
	OverseaConfigService overseaConfigService;
	
	@Autowired
	SubjectPurchaseRecordService subjectPurchaseRecordService;
	
	@Autowired
	MemberTradeRecordService memberTradeRecordService;
	
	@Autowired
	MemberAmountService memberAmountService;

	@RequestMapping("/main")
	public String getGuShouList(HttpSession session){
		Integer page =1;
		int subjectType = 10;
		Float yearRate = (float) -1;
		int period = -1;
		int status = -1;
		Subject subject = new Subject(subjectType, status, period, yearRate);

		//总条数
		Integer subjectCount = subjectRepository.getGushouCount();
		//总页数
		Integer pages = subjectCount%rowsize==0?subjectCount/rowsize:subjectCount/rowsize+1;
		List<Object[]> pagesubject = subjectRepository.selectSubject(subject, page, rowsize);

		session.setAttribute("pagesubject", pagesubject);
		session.setAttribute("subjectType", subjectType);
		session.setAttribute("yearRate", yearRate);
		session.setAttribute("period", period);
		session.setAttribute("status", status);
		session.setAttribute("page", page);
		session.setAttribute("pages", pages);
		return "/index/main";
	}

	@RequestMapping("/gushou/{subjectType}/{yearRate}/{period}/{status}")
	public String getGuShouLists(
			@PathVariable("subjectType")Integer subjectType,@PathVariable("yearRate")Float yearRate,
			@PathVariable("period")Integer period, @PathVariable("status")Integer status,
			HttpServletRequest request,HttpSession session){

		String pageStr = request.getParameter("page");
		Integer page = 1;
		if(subjectType==null) subjectType = 10;
		if(yearRate==null) yearRate = (float)-1;
		if(period==null) period = -1;
		if(status==null) status = -1;
		if(pageStr!=null) page =Integer.parseInt(pageStr);
		Subject subject = new Subject(subjectType, status, period, yearRate);
		//总条数
		Integer subjectCount = subjectRepository.getGushouCount();
		//总页数
		Integer pages = subjectCount%rowsize==0?subjectCount/rowsize:subjectCount/rowsize+1;
		//固收类查询
		List<Object[]> pagesubject = subjectRepository.selectSubject(subject, page, rowsize);




		//Page<Subject> pagesubject = subjectService.selectSubject(subject, page, rowsize);
		//	pagesubject.getContent();
		session.setAttribute("pagesubject", pagesubject);

		session.setAttribute("subjectType", subjectType);
		session.setAttribute("yearRate", yearRate);
		session.setAttribute("period", period);
		session.setAttribute("status", status);

		session.setAttribute("page", page);
		session.setAttribute("pages", pages);

		return "/index/product_gushou";
	}
	@RequestMapping("/gushougoumai/{subjectId}")
	public String getGuShouGouMai(@PathVariable("subjectId")Integer subjectId,HttpSession session){
		
		Object[] list = subjectRepository.getGushouGouMai(subjectId);
		session.setAttribute("gushougoumailist", list);
		
		Calendar  c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE,Integer.parseInt(list[4].toString()));
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(c.getTime());
		
		Calendar  c1 = Calendar.getInstance();
		c1.setTime(new Date());
		c1.add(Calendar.DATE,Integer.parseInt(list[4].toString())+1);
		SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = sim1.format(c1.getTime());
		
		
		session.setAttribute("beforedate",date);
		session.setAttribute("afterdate",date1);
		session.setAttribute("date",getFormatDate());
		session.setAttribute("amountcount", list[12]);
		return "/index/gushougoumai";
	}

	@RequestMapping("/simu")
	public String getSiMuList(HttpServletRequest request){
		String pageStr = request.getParameter("page");
		String name = request.getParameter("name");
		/*if(request.getSession().getAttribute("name")!=null){
				String names = (String) request.getSession().getAttribute("name");
		}else{
		}*/

		request.getSession().setAttribute("name", name);




		Integer page = 1;
		if(pageStr!=null){
			page = Integer.parseInt(pageStr);
		}

		System.out.println(request.getParameter("name"));
		Page<FinanceProductFunds> financeProductFunds = financeProductFundService.selectGuShouAndGuQuan(name, page, rowsize);
		request.getSession().setAttribute("financeProductFunds", financeProductFunds.getContent());
		request.getSession().setAttribute("pageFinanceProductFunds", financeProductFunds);
		return "/index/product_simu";
	}

	@RequestMapping("/seaover")
	public String getOverSeaList(HttpServletRequest request){
		String pageStr = request.getParameter("page");

		Integer page = 1;
		if(pageStr!=null){
			page = Integer.parseInt(pageStr);
		}

		//List<OverseaConfig> overseaConfig = overseaConfigRepository.getOverseaList();
		Page<OverseaConfig> pageOverseaConfig = overseaConfigService.selectOversea(page, rowsize);
		request.getSession().setAttribute("overseaConfig", pageOverseaConfig.getContent());
		request.getSession().setAttribute("pageOverseaConfig", pageOverseaConfig);
		return "/index/product_seaover";
	}

	@RequestMapping("/simugoumai/{financeProductFundsId}")
	public String getSiMuList(@PathVariable("financeProductFundsId")Integer financeProductFundsId,HttpSession session){
		System.out.println(financeProductFundsId);
		FinanceProductFunds financeProductFunds  = fPFundsRepository.getSiMuGouMai(Integer.parseInt(financeProductFundsId.toString()));
		session.setAttribute("simygoumaiFinanceProductFundsId", financeProductFunds);
		return "/index/simugoumai";
	}

	@RequestMapping("/seaover/{ocid}")
	public String getOverSeaGouMai(@PathVariable("ocid")Integer ocid,HttpSession session){
		OverseaConfig overseaConfig = overseaConfigRepository.getOverSeaGouMai(ocid);
		session.setAttribute("overseaConfig",overseaConfig);
		return "/index/seagoumai";

	}
	
	@ResponseBody
	@RequestMapping("/Yuding")
	public ResponseMsg Yuding(HttpServletRequest request){
		String subjectId = request.getParameter("subjectid");
		String mytext2 = request.getParameter("mytext2");//预购金额
		Members members = (Members)request.getSession().getAttribute("members");
		Integer memberid = members.getMemberId();
		try{
		Subject subject = subjectRepository.getSubject(Integer.parseInt(subjectId));
		MemberTradeRecord memberTradeRecord = new MemberTradeRecord(memberid, getFormatDateLSH() ,"购买："+subject.getSubjectName()+"; 金额:"+Float.parseFloat(mytext2), Float.parseFloat(mytext2), "gushou", 0,0,subjectId, new Date());
		memberTradeRecordService.addMemberTradeRecord(memberTradeRecord );
		request.getSession().setAttribute("memberTradeRecord", memberTradeRecord);
		request.getSession().setAttribute("yugousubject", subject);
		}catch(Exception e){
			return new ResponseMsg(1,"抢购失败",null);
		}
		request.getSession().setAttribute("SFM", getFormatDateSFM());
		return new ResponseMsg(0, "请购成功", null);
		
	}
	
	@RequestMapping("/fukuan")
	public String fukuan(HttpServletRequest request){
		Integer strid = Integer.parseInt(request.getParameter("mtrId"));
		
		MemberTradeRecord memberTradeRecord = (MemberTradeRecord)request.getSession().getAttribute("memberTradeRecord");
		
		Integer status = 1;
		try {
			SubjectPurchaseRecord subjectPurchaseRecord  = 
					new SubjectPurchaseRecord(memberTradeRecord.getTradeNo(),memberTradeRecord.getAmount(),Inet4Address.getLocalHost().getHostAddress(),
							Integer.parseInt(memberTradeRecord.getExtField_1()), memberTradeRecord.getMemberId(), new Date(),(float)0.0, 0, 0, "");
			//标的购买
			subjectPurchaseRecordService.addSubjectPurhaseRecord(subjectPurchaseRecord);
			
			memberAmountService.updateMA(memberTradeRecord.getAmount(), memberTradeRecord.getMemberId());
		} catch (Exception e) {
			status = 2;//购买失败
		}
		//交易状态的修改
		memberTradeRecordService.updateMemberTradeRecordService(status, strid);
		return "redirect:/product/gushougoumai/"+Integer.parseInt(memberTradeRecord.getExtField_1());
		
	}
/*	@ResponseBody
	@RequestMapping("/Yuding")
	public ResponseMsg Yuding(HttpServletRequest request){
		String subjectId = request.getParameter("subjectid");
		String mytext2 = request.getParameter("mytext2");//预购金额
		Members members = (Members)request.getSession().getAttribute("members");
		Integer memberid = members.getMemberId();
		try {
			SubjectPurchaseRecord subjectPurchaseRecord  = 
					new SubjectPurchaseRecord(getFormatDateLSH(), Float.parseFloat(mytext2),Inet4Address.getLocalHost().getHostAddress(),Integer.parseInt(subjectId), memberid, new Date(),(float)0.0, 0, 0, "");
			//标的购买
			subjectPurchaseRecordService.addSubjectPurhaseRecord(subjectPurchaseRecord);
		} catch (Exception e) {
			return new ResponseMsg(1, "操作失败", null);
		}
		
		
		
		return new ResponseMsg(0, "预购成功", null);
		
	}
*/	
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	public String getFormatDateLSH(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmSSSSS");
		return sdf.format(new Date());
	}

	
	public String getFormatDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public String getFormatDateSFM(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date());
	}
}
