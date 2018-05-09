package com.eran.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eran.model.Response;

@Controller
@RequestMapping("user")
public class AngularjsDemoController {

	Logger log = LoggerFactory.getLogger(AngularjsDemoController.class);
	
    @RequestMapping("/tologin")
    public String tologin(){
    	log.debug("去注册吧！");
        return "angularjs_demo/login";
    }
	
	@RequestMapping("/login")
	public @ResponseBody Response login() {
		log.debug("用户注册");
		Response response = new Response();
		response.setMsg("注册成功");
		response.setStatus(200);
		return response;
	}
}
