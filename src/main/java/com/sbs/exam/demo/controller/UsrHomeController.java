package com.sbs.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	private int count; 
	
	public UsrHomeController() {
		count = 0; 
	}

	@RequestMapping ("/usr/home/getCount")
	@ResponseBody
	public int getCount() {
		return count;
		
	}
	@RequestMapping ("/usr/home/doSetCount")
	@ResponseBody
	public String doSetCount(int count) {
		this.count = count ;
		return "count 값을"+this.count+"로 초기화 하였습니다.";
	}
	

}
