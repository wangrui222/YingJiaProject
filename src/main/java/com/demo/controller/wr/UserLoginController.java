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
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.dao.jian.MemberAccountRepository;
import com.demo.dao.wr.MemberRepository;
import com.demo.dao.wr.UserLoginRepository;
import com.demo.model.MemberAccount;
import com.demo.model.Members;
import com.demo.model.Users;
import com.demo.until.ResponseMsg;
import com.demo.until.SendMsg_webchinese;


@Controller
@RequestMapping("/wangrui")
public class UserLoginController {

	@Autowired
	UserLoginRepository userLoginRepository;
	@Autowired
	MemberRepository memberRepository;
	
	@Autowired
	MemberAccountRepository memberAccountRepository;

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
			return new ResponseMsg(5, "用户名不存在", null);
		}
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUsersPassword());
		Subject subject = SecurityUtils.getSubject();

		//短信验证
		/*
		HttpSession session = request.getSession();  
		String code = (String) session.getAttribute("code");  
		String phone = (String) session.getAttribute("phone");  
		String inputCode = request.getParameter("code");  
		String inputPhone = request.getParameter("mobilePhone");  
		if(phone==null||"".equals(phone)){
			return new ResponseMsg(4, "验证码错误", null); 
		}
		if(code==null||"".equals(code)){
			return new ResponseMsg(6, "验证码错误", null); 
		}
		if(!phone.equals(inputPhone)){  
			return new ResponseMsg(3, "电话信息错误", null); 
		} 
		if(!code.equalsIgnoreCase(inputCode)){
			return new ResponseMsg(7, "验证码输入错误", null); 
		}*/
		try {
			subject.login(token);
		} catch (UnknownAccountException uae) {
			return new ResponseMsg(1, "用户名或密码错误", null);
		} catch (IncorrectCredentialsException ice) {
			return new ResponseMsg(1, "用户名或密码错误", null);
		} catch (LockedAccountException lae) {
			return new ResponseMsg(2, "账户被锁定", null);
		} catch (AuthenticationException ae) {
			return new ResponseMsg(2, "账户异常", null);
		}
		
		request.getSession().setAttribute("usersname", userses.getUserName());
		return  new ResponseMsg(0, "登陆成功", null);


	}


	@RequestMapping("/duanxin")  
	@ResponseBody  
	public void sendCode(String phone, HttpServletRequest request) throws HttpException, IOException {  
		StringBuilder code = new StringBuilder();  
		Random random = new Random();  
		// 6位验证码  
		for (int i = 0; i < 4; i++) {  
			code.append(String.valueOf(random.nextInt(10)));  
		}  
		HttpSession session = request.getSession();  
		session.setAttribute("phone", phone);  
		session.setAttribute("code", code.toString());  
		session.setAttribute("time", new Date().getTime()); 
		session.setMaxInactiveInterval(60);
		String smsText = "验证码：" + code;  
		System.out.println("手机号：" + phone + ", " + smsText);  
		SendMsg_webchinese.sendMessage(phone, smsText);  
	}  


	@RequestMapping(value={"/indexLogin"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public ResponseMsg userIndexLogin(HttpServletRequest request) {
		String usersPassword = request.getParameter("password");
		String mobilePhone = request.getParameter("mobilePhone");
		Members members  = memberRepository.findMember(mobilePhone);
		try {
			Object credentials = new SimpleHash("MD5", usersPassword, ByteSource.Util.bytes(mobilePhone), 1024);
	 
			if(members!=null&&members.getMobilePhone()!=null&&credentials.toString().contains(members.getPasswords())){
				request.getSession().setAttribute("members",members);
				 MemberAccount memberAccount = memberAccountRepository.getMemberbbinAmount(members.getMemberId());
				 request.getSession().setAttribute("memberAccount", memberAccount);
				return  new ResponseMsg(0, "登陆成功", null);
			}else{
				return new ResponseMsg(1, "手机号或密码错误", null);
			}
		} catch (UnknownAccountException uae) {
			return new ResponseMsg(1, "手机号或密码错误", null);
		} 


	}
	
	public static void main(String[] args) {
		Object credentials = new SimpleHash("MD5", "123456", ByteSource.Util.bytes("17683900063"), 1024);
		System.out.println(credentials);
	}


}