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
	 * ��ǰҳ��ʾ������
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
	 * ���
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
	 * Ͷ��
	 * @param request
	 * @return
	 */
	@RequestMapping("/touzi")
	public String getTouZi(HttpServletRequest request){

		Integer memberid = getMemberId(request);

		String pageStr = request.getParameter("pageTouzi");//��ҳҳ��
		Integer countTouzi = subjectRepository.getCount(memberid);//������
		Integer pagesTouzi = countTouzi%ROWSIZE==0?countTouzi/ROWSIZE:countTouzi/ROWSIZE+1;//��ҳ��
		Integer pageTouzi = 1;//��ǰҳ��
		if(!"".equals(pageStr)&&pageStr!=null) pageTouzi = Integer.parseInt(pageStr);
		List<Object[]> touzilist = subjectRepository.findTouZiJiLu(memberid, pageTouzi, ROWSIZE);//��ǰҳ��ʾ����Ϣ

		//ԤԼ��¼
		String pageYuyueStr = request.getParameter("pageYuyue");//��ҳҳ��
		Integer countYuyue = financeProductSubscribeRepository.getCount(memberid);//������
		Integer pagesYuyue = countYuyue%ROWSIZE==0?countYuyue/ROWSIZE:countYuyue/ROWSIZE+1;//��ҳ��
		Integer pageYuyue = 1;//��ǰҳ��
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
	 * ����
	 * @param request
	 * @return
	 */
	@RequestMapping("/shouyi")
	public String getShouYi(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageShouyi");//��ҳҳ��
		Integer countShouyi = memberProfitRecordRepository.getMemberProfitRecordCount(memberid);//������
		Integer pagesShouyi = countShouyi%ROWSIZE==0?countShouyi/ROWSIZE:countShouyi/ROWSIZE+1;//��ҳ��
		Integer pageShouyi = 1;//��ǰҳ��
		if(!"".equals(pageStr)&&pageStr!=null) pageShouyi = Integer.parseInt(pageStr);

		List<MemberProfitRecord> MemberProfitRecordList = memberProfitRecordRepository.getMemberProfitRecord(memberid, pageShouyi, ROWSIZE);


		request.getSession().setAttribute("MemberProfitRecordList", MemberProfitRecordList); 
		request.getSession().setAttribute("pageShouyi", pageShouyi); 
		request.getSession().setAttribute("pagesShouyi", pagesShouyi); 
		request.getSession().setAttribute("countShouyi", countShouyi);


		return "/index/invest/shouyi";

	}

	/**
	 * ��ֵ��¼
	 * @return
	 */
	@RequestMapping("/chongzhi")
	public String getChongZhi(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageChongzhi");//��ҳҳ��
		Integer countChongzhi = memberDepositRecordRepository.getMemberDepositRecordCount(memberid);//������
		Integer pagesChongzhi = countChongzhi%ROWSIZE==0?countChongzhi/ROWSIZE:countChongzhi/ROWSIZE+1;//��ҳ��
		Integer pageChongzhi = 1;//��ǰҳ��
		if(!"".equals(pageStr)&&pageStr!=null) pageChongzhi = Integer.parseInt(pageStr);

		List<MemberDepositRecord> memberDepositRecordList = memberDepositRecordRepository.getMemberDepositRecord(memberid, pageChongzhi, ROWSIZE);

		request.getSession().setAttribute("memberDepositRecordList", memberDepositRecordList); 
		request.getSession().setAttribute("pageChongzhi", pageChongzhi); 
		request.getSession().setAttribute("pagesChongzhi", pagesChongzhi); 
		request.getSession().setAttribute("countChongzhi", countChongzhi);

		return "/index/invest/chongzhi";

	}

	/**
	 * ���
	 * @param request
	 * @return
	 */
	@RequestMapping("/tikuan")
	public String getTikuan(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageTikuan");//��ҳҳ��
		Integer countTikuan = memberWithdrawRecordRepository.getMemberWithdrawRecordCount(memberid);//������
		Integer pagesTikuan = countTikuan%ROWSIZE==0?countTikuan/ROWSIZE:countTikuan/ROWSIZE+1;//��ҳ��
		Integer pageTikuan = 1;//��ǰҳ��
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
		String pageStr = request.getParameter("pageTiyan");//��ҳҳ��
		Integer countTiyan = subjectRepository.getTiYanJinCount(memberid);//������
		Integer pagesTiyan = countTiyan%ROWSIZE==0?countTiyan/ROWSIZE:countTiyan/ROWSIZE+1;//��ҳ��
		Integer pageTiyan = 1;//��ǰҳ��
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
		//��ѯ����Ƿ�������������
		MemberAccount memberAccount = memberAccountRepository.getMemberbbinAmount(memberid);

		Members members = memberRepository.findMemberAll(memberid);

		Object credentials = new SimpleHash("MD5", withdrawalPassword, ByteSource.Util.bytes(members.getMobilePhone()), 1024);

		if(!credentials.toString().contains(members.getPasswords())){
			return new ResponseMsg(2, "�������", null);
		}
		if(memberAccount.getUseableBalance()<amount){
			return new ResponseMsg(1, "��������", null);
		}
		//�˻�����ȥ����Ķ��
		try{
			memberAmountService.updateMemberAmounts(amount, memberid);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseMsg(3, "����쳣", null);
		}
		//����¼

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
			return new ResponseMsg(3, "����쳣", null);
		}


		return new ResponseMsg(0, "�ɹ�", null);



	}

	@RequestMapping("/mytikuan")
	public String getMytikuan(HttpServletRequest request){
		Integer memberid = getMemberId(request);
		String pageStr = request.getParameter("pageTikuan");//��ҳҳ��
		Integer countTikuan = memberWithdrawRecordRepository.getMemberWithdrawRecordCount(memberid);//������
		Integer pagesTikuan = countTikuan%ROWSIZE==0?countTikuan/ROWSIZE:countTikuan/ROWSIZE+1;//��ҳ��
		Integer pageTikuan = 1;//��ǰҳ��
		if(!"".equals(pageStr)&&pageStr!=null) pageTikuan = Integer.parseInt(pageStr);
		//����¼
		List<MemberWithdrawRecord> memberWithdrawRecordList = memberWithdrawRecordRepository.getMemberWithdrawRecord(memberid, pageTikuan, ROWSIZE);
		//�������
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
		String pageStr = request.getParameter("pageChongzhijilu");//��ҳҳ��
		Integer countChongzhijilu = memberDepositRecordRepository.getMemberDepositRecordCount(memberid);//������
		Integer pagesChongzhijilu = countChongzhijilu%ROWSIZE==0?countChongzhijilu/ROWSIZE:countChongzhijilu/ROWSIZE+1;//��ҳ��
		Integer pageChongzhijilu = 1;//��ǰҳ��
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
		String total_amount = request.getParameter("fee");//��ֵ���
		String out_trade_no =getFormatDate();//��ֵ��Ʒ����
		String subjects = "�˻���ֵ";
		String body = "֧����" ;
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
	 * @param out_trade_no ��ˮ��
	 * @param trade_no ���׶�����
	 * @param request
	 * @return
	 */
	@RequestMapping("/zhifu/{out_trade_no}/{trade_no}/{total_amount}")
	public String getZhifu(@PathVariable("out_trade_no")String out_trade_no,
			@PathVariable("trade_no")String trade_no,
			@PathVariable("total_amount")String total_amount,
			HttpServletRequest request){
		//����֧���ɹ�֮��Ķ������
		memberDepositRecordSerivce.updateMemberDepositRecordSerivce(out_trade_no,trade_no);

		//�����ԱID
		Integer memberId = memberDepositRecordRepository.selectMemberId(out_trade_no);

		//�˻�����Ǯ
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
		//1.ʵ����֤ 2.���ֻ� 3.��½���� 4.�������
		Members members = memberRepository.findMemberAll(memberid);
		//����֤
		MemberBankcards memberBankcards = memberbankcardsRepository.findMemberBankcards(memberid);

		request.getSession().setAttribute("members", members);
		request.getSession().setAttribute("memberBankcards", memberBankcards);



		return "/index/zhanghu/anquan01";

	}


	@ResponseBody
	@RequestMapping("/shenfen")
	public ResponseMsg getShenfenYanzheng(HttpServletRequest request){

		//��ԱID
		Integer memberid = getMemberId(request);

		String userName = request.getParameter("userName");

		String identity = request.getParameter("identity");
		String bankCard = request.getParameter("bankCard");
		String type = request.getParameter("type");
		String cardaddress = request.getParameter("cardaddress");

		//�󿨶���
		MemberBankcards memberbankcard = new MemberBankcards(type, memberid, bankCard, 1, new Date(), cardaddress);


		//ʵ����֤
		try {
			memberService.addMemberYanZheng(memberid,userName,identity);
		} catch (Exception e) {
			return new ResponseMsg(1, "ʵ����֤ʧ��", null);

		}
		//����֤
		try {
			memberbankcardService.addMemberbankcard(memberbankcard);
		} catch (Exception e) {
			return new ResponseMsg(2, "����֤ʧ��", null);

		}

		//"/index/zhanghu/anquan01";

		return new ResponseMsg(0, "�����ɹ�", null);


	}


	@ResponseBody
	@RequestMapping("/password")
	public ResponseMsg updatePassoword(HttpServletRequest request){
		//��ԱID
		Integer memberid = getMemberId(request);

		Members member = memberRepository.findMemberAll(memberid);

		String oriPwd = request.getParameter("oriPwd");
		String newPwd = request.getParameter("newPwd");
		Object oriPwdobj = new SimpleHash("MD5", oriPwd, ByteSource.Util.bytes(member.getMobilePhone()), 1024);
		if(!member.getPasswords().contentEquals(oriPwdobj.toString())){
			return new ResponseMsg(1, "ԭ�������", null);
		}

		Object newPwdobj = new SimpleHash("MD5", newPwd, ByteSource.Util.bytes(member.getMobilePhone()), 1024);
		memberService.updateMemberPassword(newPwdobj.toString(), member.getMemberId());
		//"/index/zhanghu/anquan01";

		return new ResponseMsg(0, "�����ɹ�", null);


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
			//д�ļ���upload�ļ���
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
	 * ��ȡ��Ա��Ϣ
	 * @param request
	 * @return
	 */
	public Integer getMemberId(HttpServletRequest request){
		Members member = (Members)request.getSession().getAttribute("members");
		Integer memberid = member.getMemberId();//��½�û�ID
		return memberid;
	}

}
