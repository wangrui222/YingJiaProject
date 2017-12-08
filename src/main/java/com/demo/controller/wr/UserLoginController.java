package com.demo.controller.wr;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.httpclient.HttpException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.wr.UserLoginRepository;
import com.demo.model.Users;
import com.demo.until.ResponseMsg;
import com.demo.until.SendMsg_webchinese;


@Controller
@RequestMapping("/wangrui")
public class UserLoginController {

	@Autowired
	UserLoginRepository userLoginRepository;

	@RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public String login()
	{
		return "redirect:/view/login.jsp";
	}
	@RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public ResponseMsg login(@Valid Users user, BindingResult errors, HttpServletRequest request) {
		Object[] users = userLoginRepository.getUsers(user.getUserName());

		Users userses=null;
		try {
			userses = new Users(users[0].toString(), users[1].toString(), users[2].toString(),Integer.parseInt(users[3].toString()));
		} catch (Exception e) {
			return new ResponseMsg(5, "�û���������", null);
		}
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUsersPassword());
		Subject subject = SecurityUtils.getSubject();
		
		//������֤
		/*
		HttpSession session = request.getSession();  
		String code = (String) session.getAttribute("code");  
		String phone = (String) session.getAttribute("phone");  
		String inputCode = request.getParameter("code");  
		String inputPhone = request.getParameter("mobilePhone");  
		if(phone==null||"".equals(phone)){
			return new ResponseMsg(4, "��֤�����", null); 
		}
		if(code==null||"".equals(code)){
			return new ResponseMsg(6, "��֤�����", null); 
		}
		if(!phone.equals(inputPhone)){  
			return new ResponseMsg(3, "�绰��Ϣ����", null); 
		} 
		if(!code.equalsIgnoreCase(inputCode)){
			return new ResponseMsg(7, "��֤���������", null); 
		}*/
		try {
			subject.login(token);
		} catch (UnknownAccountException uae) {
			return new ResponseMsg(1, "�û������������", null);
		} catch (IncorrectCredentialsException ice) {
			return new ResponseMsg(1, "�û������������", null);
		} catch (LockedAccountException lae) {
			return new ResponseMsg(2, "�˻�������", null);
		} catch (AuthenticationException ae) {
			return new ResponseMsg(2, "�˻��쳣", null);
		}
		return  new ResponseMsg(0, "��½�ɹ�", null);


	}


	@RequestMapping("/duanxin")  
	@ResponseBody  
	public void sendCode(String phone, HttpServletRequest request) throws HttpException, IOException {  
		StringBuilder code = new StringBuilder();  
		Random random = new Random();  
		// 6λ��֤��  
		for (int i = 0; i < 4; i++) {  
			code.append(String.valueOf(random.nextInt(10)));  
		}  
		HttpSession session = request.getSession();  
		session.setAttribute("phone", phone);  
		session.setAttribute("code", code.toString());  
		session.setAttribute("time", new Date().getTime()); 
		session.setMaxInactiveInterval(60);
		String smsText = "��֤�룺" + code;  
		System.out.println("�ֻ��ţ�" + phone + ", " + smsText);  
		SendMsg_webchinese.sendMessage(phone, smsText);  
	}  

	/*@RequestMapping("validate.html")  
	@ResponseBody  
	protected String validate(HttpServletRequest request){  

	}  */


	/*@RequestMapping(value={"/logout"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public String logout(HttpServletRequest request)
	{
		Subject subject = SecurityUtils.getSubject();
		Users user = (Users)subject.getSession().getAttribute("cUser");
		this.applicationContext.publishEvent(new UserLogEvent(request.getRemoteAddr(), UserAction.login, user));
		subject.logout();
		return "redirect:/manage/login";
	}

	@ResponseBody
	@RequestMapping(value={"/sendTestValSms"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public ResponseMsg sendTestValSms(String phone, Integer type)
	{
		ResponseMsg msg = new ResponseMsg();
		Integer code = Integer.valueOf(RandowNumber.CreateValidateCode());
		String regExp = "^1[3-9][0-9]\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(phone);
		if (!m.find()) {
			msg = ResponseMsg.getError("�ֻ������ʽ����");
		} else {
			Integer smstype = type;
			SmsInterface smsInterface = this.smsService.getSmsInterface(smstype);
			String result = this.smsService.sendValidateSms(smsInterface, phone, code.toString());
			this.smsService.saveSmsRecord(smstype, phone, code.toString(), smsInterface.getContent(), new Date(), result);
			msg = ResponseMsg.getOk("��֤����ŷ��ͳɹ�");
		}
		return msg;
	}

	@ResponseBody
	@RequestMapping(value={"/checkedSms"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public ResponseMsg checkedSms(String mobilePhone)
	{
		ResponseMsg msg = new ResponseMsg();
		String regExp = "^1[3-9][0-9]\\d{8}$";
		Pattern p = Pattern.compile(regExp);
		Matcher m = p.matcher(mobilePhone);
		if (!m.find()) {
			msg = ResponseMsg.getError("�ֻ������ʽ����");
		} else {
			Users users = this.userInfoService.findUserInfoByPhone(mobilePhone);
			if (users != null)
				msg = ResponseMsg.getOk("�ֻ�������ȷ");
			else {
				msg = ResponseMsg.getError("�ֻ����벻��ȷ");
			}
		}
		return msg;

	}
	 */

}