package com.demo.controller.ldd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping(value="ldd")
public class LDDController {
	//��̨��Ա����-�˺Ź���
	@RequestMapping(value="sysmember/index")
	public String HYzhgl() {

		return "/sysmember/zhgl";

	}
	//��̨��Ա����-���ʦ���
	@RequestMapping(value="sysmember/financia")
	public String HYlcssh() {

		return "/sysmember/financia";

	}
	//��̨��Ա����-�󿨹���
	@RequestMapping(value="sysmember/dahua")
	public String HYbkgl() {

		return "/sysmember/bkgl";

	}
	//��̨��Ա����-��Ϣ�ƻ�
	@RequestMapping(value="sysmember/payment")
	public String HYfxjh() {

		return "/sysmember/fxjh";

	}
}
