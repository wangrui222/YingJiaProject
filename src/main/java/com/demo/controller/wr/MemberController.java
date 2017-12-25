package com.demo.controller.wr;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.demo.dao.jian.MemberAccountRepository;
import com.demo.dao.jian.MemberWithdrawRecordRepository;
import com.demo.dao.ldd.FinancialplannerRepository;
import com.demo.dao.ldd.MemberbankcardsRepository;
import com.demo.dao.wr.FinanceProductSubscribeRepository;
import com.demo.dao.wr.MemberDepositRecordRepository;
import com.demo.dao.wr.MemberProfitRecordRepository;
import com.demo.dao.wr.MemberRepository;
import com.demo.dao.wr.SubjectRepository;
import com.demo.model.FinanceProductSubscribe;
import com.demo.model.FinancialPlanner;
import com.demo.model.MemberAccount;
import com.demo.model.MemberBankcards;
import com.demo.model.MemberDepositRecord;
import com.demo.model.MemberProfitRecord;
import com.demo.model.MemberWithdrawRecord;
import com.demo.model.Members;
import com.demo.service.jian.MemberWithdrawRecordService;
import com.demo.service.wr.FinancialPlannerService;
import com.demo.service.wr.MemberAmountService;
import com.demo.service.wr.MemberDepositRecordSerivce;
import com.demo.service.wr.MemberService;
import com.demo.service.wr.MemberbankcardService;
import com.demo.until.ResponseMsg;

@Controller
@RequestMapping("/member")
public class MemberController {
	/**
	 * 当前页显示的条数
	 */
	private static final Integer ROWSIZE = 1;

	@Autowired
	SubjectRepository subjectRepository;

	@Autowired
	MemberProfitRecordRepository memberProfitRecordRepository;

	@Autowired
	FinanceProductSubscribeRepository financeProductSubscribeRepository;

	@Autowired
	MemberDepositRecordRepository memberDepositRecordRepository;
	/**
	 * 提款
	 */
	@Autowired
	MemberWithdrawRecordRepository memberWithdrawRecordRepository;



	@Autowired
	MemberAccountRepository memberAccountRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	MemberDepositRecordSerivce memberDepositRecordSerivce;


	@Autowired
	MemberAmountService memberAmountService;

	@Autowired
	MemberWithdrawRecordService memberWithdrawRecordService;

	@Autowired
	MemberService memberService;

	@Autowired
	MemberbankcardService memberbankcardService;


	@Autowired
	MemberbankcardsRepository memberbankcardsRepository;

	@Autowired
	FinancialplannerRepository financialplannerRepository;
	
	@Autowired
	FinancialPlannerService financialPlannerService;
	/*
	 * 投资
	 * @param request
	 * @return
	 */
	@RequestMapping("/touzi")
	public String getTouZi(HttpServletRequest request){

		Integer memberid = getMemberId(request);

		String pageStr = request.getParameter("pageTouzi");//分页页数
		Integer countTouzi = subjectRepository.getCount(memberid);//总条数
		Integer pagesTouzi = countTouzi%ROWSIZE==0?countTouzi/ROWSIZE:countTouzi/ROWSIZE+1;//总页数
		Integer pageTouzi = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageTouzi = Integer.parseInt(pageStr);
		List<Object[]> touzilist = subjectRepository.findTouZiJiLu(memberid, pageTouzi, ROWSIZE);//当前页显示的信息

		//预约记录
		String pageYuyueStr = request.getParameter("pageYuyue");//分页页数
		Integer countYuyue = financeProductSubscribeRepository.getCount(memberid);//总条数
		Integer pagesYuyue = countYuyue%ROWSIZE==0?countYuyue/ROWSIZE:countYuyue/ROWSIZE+1;//总页数
		Integer pageYuyue = 1;//当前页数
		if(!"".equals(pageYuyueStr)&&pageYuyueStr!=null) pageYuyue = Integer.parseInt(pageYuyueStr);
		List<FinanceProductSubscribe> fpslist =  financeProductSubscribeRepository.findFinanceProductSubscribe(memberid, pageYuyue, ROWSIZE);

		request.getSession().setAttribute("touzilist", touzilist); 
		request.getSession().setAttribute("pageTouzi", pageTouzi); 
		request.getSession().setAttribute("pagesTouzi", pagesTouzi); 
		request.getSession().setAttribute("countTouzi", countTouzi);


		request.getSession().setAttribute("fpslist", fpslist); 
		request.getSession().setAttribute("pageYuyue", pageYuyue); 
		request.getSession().setAttribute("pagesYuyue", pagesYuyue); 
		request.getSession().setAttribute("countYuyue", countYuyue);


		return "/index/invest/touzi";

	}

	/**
	 * 收益
	 * @param request
	 * @return
	 */
	@RequestMapping("/shouyi")
	public String getShouYi(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageShouyi");//分页页数
		Integer countShouyi = memberProfitRecordRepository.getMemberProfitRecordCount(memberid);//总条数
		Integer pagesShouyi = countShouyi%ROWSIZE==0?countShouyi/ROWSIZE:countShouyi/ROWSIZE+1;//总页数
		Integer pageShouyi = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageShouyi = Integer.parseInt(pageStr);

		List<MemberProfitRecord> MemberProfitRecordList = memberProfitRecordRepository.getMemberProfitRecord(memberid, pageShouyi, ROWSIZE);


		request.getSession().setAttribute("MemberProfitRecordList", MemberProfitRecordList); 
		request.getSession().setAttribute("pageShouyi", pageShouyi); 
		request.getSession().setAttribute("pagesShouyi", pagesShouyi); 
		request.getSession().setAttribute("countShouyi", countShouyi);


		return "/index/invest/shouyi";

	}

	/**
	 * 充值记录
	 * @return
	 */
	@RequestMapping("/chongzhi")
	public String getChongZhi(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageChongzhi");//分页页数
		Integer countChongzhi = memberDepositRecordRepository.getMemberDepositRecordCount(memberid);//总条数
		Integer pagesChongzhi = countChongzhi%ROWSIZE==0?countChongzhi/ROWSIZE:countChongzhi/ROWSIZE+1;//总页数
		Integer pageChongzhi = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageChongzhi = Integer.parseInt(pageStr);

		List<MemberDepositRecord> memberDepositRecordList = memberDepositRecordRepository.getMemberDepositRecord(memberid, pageChongzhi, ROWSIZE);

		request.getSession().setAttribute("memberDepositRecordList", memberDepositRecordList); 
		request.getSession().setAttribute("pageChongzhi", pageChongzhi); 
		request.getSession().setAttribute("pagesChongzhi", pagesChongzhi); 
		request.getSession().setAttribute("countChongzhi", countChongzhi);

		return "/index/invest/chongzhi";

	}

	/**
	 * 提款
	 * @param request
	 * @return
	 */
	@RequestMapping("/tikuan")
	public String getTikuan(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageTikuan");//分页页数
		Integer countTikuan = memberWithdrawRecordRepository.getMemberWithdrawRecordCount(memberid);//总条数
		Integer pagesTikuan = countTikuan%ROWSIZE==0?countTikuan/ROWSIZE:countTikuan/ROWSIZE+1;//总页数
		Integer pageTikuan = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageTikuan = Integer.parseInt(pageStr);

		List<MemberWithdrawRecord> memberWithdrawRecordList = memberWithdrawRecordRepository.getMemberWithdrawRecord(memberid, pageTikuan, ROWSIZE);

		request.getSession().setAttribute("memberWithdrawRecordList", memberWithdrawRecordList); 
		request.getSession().setAttribute("pageTikuan", pageTikuan); 
		request.getSession().setAttribute("pagesTikuan", pagesTikuan); 
		request.getSession().setAttribute("countTikuan", countTikuan);

		return "/index/invest/tikuan";

	}


	@RequestMapping("/tiyan")
	public String getTiyan(HttpServletRequest request){

		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageTiyan");//分页页数
		Integer countTiyan = subjectRepository.getTiYanJinCount(memberid);//总条数
		Integer pagesTiyan = countTiyan%ROWSIZE==0?countTiyan/ROWSIZE:countTiyan/ROWSIZE+1;//总页数
		Integer pageTiyan = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageTiyan = Integer.parseInt(pageStr);

		List<Object[]> subjectlist = subjectRepository.findTiYanJin(memberid, pageTiyan, ROWSIZE);

		MemberAccount amount = memberAccountRepository.getMemberbbinAmount(memberid);
		request.getSession().setAttribute("subjectlist", subjectlist); 
		request.getSession().setAttribute("pageTiyan", pageTiyan); 
		request.getSession().setAttribute("pagesTiyan", pagesTiyan); 
		request.getSession().setAttribute("countTiyan", countTiyan);
		request.getSession().setAttribute("amount", amount.getBbinAmount());
		return "/index/invest/tiyan";
	}

	@ResponseBody
	@RequestMapping("/mytikuanl")
	public ResponseMsg getTikuanle(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		Float amount = Float.parseFloat(request.getParameter("amount"));
		String withdrawalPassword =request.getParameter("withdrawalPassword");
		String bankCard =request.getParameter("bankCard");
		//查询余额是否满足体现需求
		MemberAccount memberAccount = memberAccountRepository.getMemberbbinAmount(memberid);

		Members members = memberRepository.findMemberAll(memberid);

		Object credentials = new SimpleHash("MD5", withdrawalPassword, ByteSource.Util.bytes(members.getMobilePhone()), 1024);

		if(!credentials.toString().contains(members.getPasswords())){
			return new ResponseMsg(2, "密码错误", null);
		}
		if(memberAccount.getUseableBalance()<amount){
			return new ResponseMsg(1, "可提余额不足", null);
		}
		//账户余额减去提出的额度
		try{
			memberAmountService.updateMemberAmounts(amount, memberid);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg(3, "提款异常", null);
		}
		//提款记录

		Members m = new Members();
		m.setMemberId(memberid);

		MemberWithdrawRecord mwr =null;
		try {
			mwr	= new MemberWithdrawRecord(getFormatDate(), m, amount, "", bankCard, 1, 0, "", "", new Date());
		} catch (Exception e) {
			e.printStackTrace();
			mwr.setStatus(0);
		}
		try{
			memberWithdrawRecordService.addMemberWithdrawRecord(mwr);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg(3, "提款异常", null);
		}


		return new ResponseMsg(0, "成功", null);



	}

	@RequestMapping("/mytikuan")
	public String getMytikuan(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageTikuan");//分页页数
		Integer countTikuan = memberWithdrawRecordRepository.getMemberWithdrawRecordCount(memberid);//总条数
		Integer pagesTikuan = countTikuan%ROWSIZE==0?countTikuan/ROWSIZE:countTikuan/ROWSIZE+1;//总页数
		Integer pageTikuan = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageTikuan = Integer.parseInt(pageStr);
		//提款记录
		List<MemberWithdrawRecord> memberWithdrawRecordList = memberWithdrawRecordRepository.getMemberWithdrawRecord(memberid, pageTikuan, ROWSIZE);
		//可提余额
		MemberAccount memberAccount = memberAccountRepository.getMemberbbinAmount(memberid);


		request.getSession().setAttribute("memberAccount", memberAccount);
		request.getSession().setAttribute("memberWithdrawRecordList", memberWithdrawRecordList); 
		request.getSession().setAttribute("pageTikuan", pageTikuan); 
		request.getSession().setAttribute("pagesTikuan", pagesTikuan); 
		request.getSession().setAttribute("countTikuan", countTikuan);
		return "/index/zhanghu/mytikuan";
	}


	@RequestMapping("/zhanghuchongzhi")
	public String getZhanghuchongzhi(HttpServletRequest request){

		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageChongzhijilu");//分页页数
		Integer countChongzhijilu = memberDepositRecordRepository.getMemberDepositRecordCount(memberid);//总条数
		Integer pagesChongzhijilu = countChongzhijilu%ROWSIZE==0?countChongzhijilu/ROWSIZE:countChongzhijilu/ROWSIZE+1;//总页数
		Integer pageChongzhijilu = 1;//当前页数
		if(!"".equals(pageStr)&&pageStr!=null) pageChongzhijilu = Integer.parseInt(pageStr);


		List<MemberDepositRecord> memberlist  = memberDepositRecordRepository.getMemberDepositRecord(memberid,pageChongzhijilu,ROWSIZE);


		request.getSession().setAttribute("memberlist", memberlist); 
		request.getSession().setAttribute("pageChongzhijilu", pageChongzhijilu); 
		request.getSession().setAttribute("pagesChongzhijilu", pagesChongzhijilu); 
		request.getSession().setAttribute("countChongzhijilu", countChongzhijilu);


		return "/index/zhanghu/accountChongzhi";

	}



	@RequestMapping("/accountchongzhi")
	public String getAccountchongzhi(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String total_amount = request.getParameter("fee");//充值金额
		String out_trade_no =getFormatDate();//充值商品单号
		String subjects = "账户充值";
		String body = "支付宝" ;
		MemberDepositRecord member = new MemberDepositRecord(out_trade_no, memberid, Float.parseFloat(total_amount), 0, body);
		member.setCreateDate(new Date());
		memberDepositRecordSerivce.addMemberDepositRecord(member);

		request.setAttribute("total_amount",total_amount);
		request.setAttribute("out_trade_no",out_trade_no);
		request.setAttribute("subject",subjects);
		request.setAttribute("body",body);


		return "/alipay/alipay";

	}


	/**
	 * 
	 * @param out_trade_no 流水号
	 * @param trade_no 交易订单号
	 * @param request
	 * @return
	 */
	@RequestMapping("/zhifu/{out_trade_no}/{trade_no}/{total_amount}")
	public String getZhifu(@PathVariable("out_trade_no")String out_trade_no,
			@PathVariable("trade_no")String trade_no,
			@PathVariable("total_amount")String total_amount,
			HttpServletRequest request){
		//加上支付成功之后的订单编号
		memberDepositRecordSerivce.updateMemberDepositRecordSerivce(out_trade_no,trade_no);

		//查出会员ID
		Integer memberId = memberDepositRecordRepository.selectMemberId(out_trade_no);

		//账户余额加钱
		memberAmountService.updateMemberAmount(Float.parseFloat(total_amount),memberId);


		MemberAccount memberAccount = memberAccountRepository.getMemberbbinAmount(memberId);
		request.getSession().setAttribute("memberAccount", memberAccount);
		Members members = memberRepository.findMemberAll(memberId);
		request.getSession().setAttribute("members", members);


		return "/index/member";

	}
	@RequestMapping("/anquan")
	public String anquan(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		//1.实名认证 2.绑定手机 3.登陆密码 4.提款密码
		Members members = memberRepository.findMemberAll(memberid);
		//绑卡认证
		MemberBankcards memberBankcards = memberbankcardsRepository.findMemberBankcards(memberid);

		request.getSession().setAttribute("members", members);
		request.getSession().setAttribute("memberBankcards", memberBankcards);



		return "/index/zhanghu/anquan01";

	}


	@ResponseBody
	@RequestMapping("/shenfen")
	public ResponseMsg getShenfenYanzheng(HttpServletRequest request){

		//会员ID
		Integer memberid = getMemberId(request);

		String userName = request.getParameter("userName");

		String identity = request.getParameter("identity");
		String bankCard = request.getParameter("bankCard");
		String type = request.getParameter("type");
		String cardaddress = request.getParameter("cardaddress");

		//绑卡对象
		MemberBankcards memberbankcard = new MemberBankcards(type, memberid, bankCard, 1, new Date(), cardaddress);


		//实名认证
		try {
			memberService.addMemberYanZheng(memberid,userName,identity);
		} catch (Exception e) {
			return new ResponseMsg(1, "实名认证失败", null);

		}
		//绑卡认证
		try {
			memberbankcardService.addMemberbankcard(memberbankcard);
		} catch (Exception e) {
			return new ResponseMsg(2, "绑卡认证失败", null);

		}

		//"/index/zhanghu/anquan01";

		return new ResponseMsg(0, "操作成功", null);


	}


	@ResponseBody
	@RequestMapping("/password")
	public ResponseMsg updatePassoword(HttpServletRequest request){
		//会员ID
		Integer memberid = getMemberId(request);

		Members member = memberRepository.findMemberAll(memberid);

		String oriPwd = request.getParameter("oriPwd");
		String newPwd = request.getParameter("newPwd");
		Object oriPwdobj = new SimpleHash("MD5", oriPwd, ByteSource.Util.bytes(member.getMobilePhone()), 1024);
		if(!member.getPasswords().contentEquals(oriPwdobj.toString())){
			return new ResponseMsg(1, "原密码错误", null);
		}

		Object newPwdobj = new SimpleHash("MD5", newPwd, ByteSource.Util.bytes(member.getMobilePhone()), 1024);
		memberService.updateMemberPassword(newPwdobj.toString(), member.getMemberId());
		//"/index/zhanghu/anquan01";

		return new ResponseMsg(0, "操作成功", null);


	}


	@RequestMapping("/loginout")
	public String layout(HttpServletRequest request){
		request.getSession().removeAttribute("members");
		request.getSession().removeAttribute("memberAccount");
		
		return "/index/login";

	}

	@RequestMapping("/tiyanshi")
	public String getTiyanshi(HttpServletRequest request){
		Integer memberid = getMemberId(request);

		FinancialPlanner financialplanner = financialplannerRepository.selectFinancialPlannert(memberid);

		request.getSession().setAttribute("financialplanner", financialplanner);

		return "/index/zhanghu/licaishi";

	}

	@RequestMapping("/licaishi")
	public String getLicaishi(FinancialPlanner financialPlanner,@RequestParam MultipartFile mycards,HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String filename = mycards.getOriginalFilename();
		InputStream is = null;
		try{
			is=mycards.getInputStream();
			//写文件到upload文件夹
			String path = request.getRealPath("upload")+"\\"+filename;
			FileUtils.copyInputStreamToFile(is,new File(path));
		}catch(Exception e){}	
		
		financialPlanner.setMycard(filename);
		financialPlanner.setMemberId(memberid);
		financialPlanner.setCreateDate(new Date());
		
		financialPlannerService.addFinancialPlanner(financialPlanner);
		
		return "redirect:/member/tiyanshi";

	}



	public String getFormatDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmSSSSS");
		return sdf.format(new Date());
	}


	/**
	 * 获取会员信息
	 * @param request
	 * @return
	 */
	public Integer getMemberId(HttpServletRequest request){
		Members member = (Members)request.getSession().getAttribute("members");
		Integer memberid = member.getMemberId();//登陆用户ID
		return memberid;
	}

}
