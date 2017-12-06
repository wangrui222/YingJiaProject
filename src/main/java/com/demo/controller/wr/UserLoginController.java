package com.demo.controller.wr;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.servlet.ModelAndView;

import com.demo.dao.wr.UserLoginRepository;
import com.demo.model.Users;
import com.demo.until.ResponseMsg;


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
		Object[] users = userLoginRepository.getUsers("admin");
		Users userses = new Users(users[0].toString(), users[1].toString(), users[2].toString(),Integer.parseInt(users[3].toString()));
		
		
		if (user != null){
			if (user.getMobilePhone().equals(userses.getMobilePhone()))
			{
				UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUsersPassword());
				Subject subject = SecurityUtils.getSubject();
				try {
//					HttpSession session = request.getSession();
//					session.setAttribute("Users", userses);
					subject.login(token);
//					session.removeAttribute("Users");
				} catch (UnknownAccountException uae) {
					return new ResponseMsg(1, "用户名或密码错误", null);
				} catch (IncorrectCredentialsException ice) {
					return new ResponseMsg(1, "用户名或密码错误", null);
				} catch (LockedAccountException lae) {
					return new ResponseMsg(2, "账户被锁定", null);
				} catch (AuthenticationException ae) {
					return new ResponseMsg(2, "账户异常", null);
				}
			}
			else
			{
				return new ResponseMsg(1, "用户名或手机号码错误", null);
			}
		}
		else return new ResponseMsg(1, "用户名或手机号码错误", null);

		return new ResponseMsg(0, "登录成功", null); 
	}

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
			msg = ResponseMsg.getError("手机号码格式错误");
		} else {
			Integer smstype = type;
			SmsInterface smsInterface = this.smsService.getSmsInterface(smstype);
			String result = this.smsService.sendValidateSms(smsInterface, phone, code.toString());
			this.smsService.saveSmsRecord(smstype, phone, code.toString(), smsInterface.getContent(), new Date(), result);
			msg = ResponseMsg.getOk("验证码短信发送成功");
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
			msg = ResponseMsg.getError("手机号码格式错误");
		} else {
			Users users = this.userInfoService.findUserInfoByPhone(mobilePhone);
			if (users != null)
				msg = ResponseMsg.getOk("手机号码正确");
			else {
				msg = ResponseMsg.getError("手机号码不正确");
			}
		}
		return msg;

	}
	 */

}