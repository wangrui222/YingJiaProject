package com.demo.controller.ldd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="ldd")
public class LDDController {
	//后台会员管理-账号管理
	@RequestMapping(value="sysmember/index")
	public String HYzhgl() {

		return "/sysmember/zhgl";

	}
	//后台会员管理-理财师审核
	@RequestMapping(value="sysmember/financia")
	public String HYlcssh() {

		return "/sysmember/financia";

	}
	//后台会员管理-绑卡管理
	@RequestMapping(value="sysmember/dahua")
	public String HYbkgl() {

		return "/sysmember/bkgl";

	}
	//后台会员管理-付息计划
	@RequestMapping(value="sysmember/payment")
	public String HYfxjh() {

		return "/sysmember/fxjh";

	}
}
