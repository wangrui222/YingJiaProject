package com.demo.controller.wr.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.dao.wr.FinanceProductFundsRepository;
import com.demo.dao.wr.OverseaConfigRepository;
import com.demo.dao.wr.SubjectPurchaseRecordRepository;
import com.demo.dao.wr.SubjectRepository;
import com.demo.model.FinanceProductFunds;
import com.demo.model.OverseaConfig;
import com.demo.model.Subject;
import com.demo.service.wr.FinanceProductFundService;
import com.demo.service.wr.OverseaConfigService;
import com.demo.service.wr.SubjectService;

@Controller
@RequestMapping("/product")
public class ProductsController {
	
	private static final Integer rowsize = 1;
	
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
	
	@RequestMapping("/main")
	public String getGuShouList(HttpSession session){
		int subjectType = 10;
		Float yearRate = (float) -1;
		int period = -1;
		int status = -1;
		Subject subject = new Subject(subjectType, status, period, yearRate);
		Page<Subject> pagesubject = subjectService.selectSubject(subject, 1, rowsize);
		session.setAttribute("pagesubject", pagesubject);
		session.setAttribute("subjectType", subjectType);
		session.setAttribute("yearRate", yearRate);
		session.setAttribute("period", period);
		session.setAttribute("status", status);
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
		//List<Object[]> list = subjectRepository.getGushouList(subject);
		
	
		
	
		Page<Subject> pagesubject = subjectService.selectSubject(subject, page, rowsize);
		pagesubject.getContent();
		session.setAttribute("pagesubject", pagesubject);
		
		session.setAttribute("subjectType", subjectType);
		session.setAttribute("yearRate", yearRate);
		session.setAttribute("period", period);
		session.setAttribute("status", status);
		
		return "/index/product_gushou";
	}
	@RequestMapping("/gushougoumai/{subjectId}")
	public String getGuShouGouMai(@PathVariable("subjectId")Integer subjectId,HttpSession session){
		Subject list = subjectRepository.getGushouGouMai(subjectId);
		Float floats = subjectPurchaseRecordRepository.getSumamount(subjectId);
		session.setAttribute("gushougoumailist", list);
		session.setAttribute("sumamount",floats);
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

}
