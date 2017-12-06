package com.demo.controller.wr;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Users;
import com.demo.until.ResponseMsg;


@Controller
@RequestMapping("/wangrui")
public class UserLoginController {

	/*
	@RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public String login() { 
		System.out.println("123");
		return "0";
	}
	 */
	@RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	public ModelAndView login()
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping(value={"/login"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@ResponseBody
	public ResponseMsg login(@Valid Users user, BindingResult errors, HttpServletRequest request) { ModelAndView mv = new ModelAndView();
	//Users userInfo = this.userInfoService.findUserInfoByUserName(user.getUserName());
	if (user != null){
		if (user.getMobilePhone().equals(user.getMobilePhone()))
		{
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getUsersPassword());
			Subject subject = SecurityUtils.getSubject();
			try {
				subject.login(token);
				//				Session session = subject.getSession();
				//				session.setAttribute("cUser", userInfo);
				//				session.setAttribute("userRole", this.userInfoService.getUserRole(userInfo.getId()));
				//				this.applicationContext.publishEvent(new UserLogEvent(request.getRemoteAddr(), UserAction.login, userInfo));
			} catch (UnknownAccountException uae) {
				//this._logger.debug("账户不存在!");
				mv.setViewName("login");
				return new ResponseMsg(1, "用户名或密码错误", null);
			} catch (IncorrectCredentialsException ice) {
				//this._logger.debug("密码不正确!");
				mv.setViewName("login");
				return new ResponseMsg(1, "用户名或密码错误", null);
			} catch (LockedAccountException lae) {
				//this._logger.debug("账户被禁了!");
				mv.setViewName("login");
				return new ResponseMsg(2, "账户异常", null);
			} catch (AuthenticationException ae) {
				//this._logger.debug("认证错误!");
				mv.setViewName("login");
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