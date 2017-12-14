package com.demo.controller.wr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.until.ResponseMsg;

@Controller
@RequestMapping("/index")
public class UserIndexLoginController {
	
	
	@RequestMapping("/login")
	public ResponseMsg userIndexLogin(){
		
		return null;
		
	}

}
