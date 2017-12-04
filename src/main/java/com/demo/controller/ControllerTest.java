package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest {

	@RequestMapping("a")
	public String test(){
		System.out.println("11111");
		return "";
		
	}
	
	
}