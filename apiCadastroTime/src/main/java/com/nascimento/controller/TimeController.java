package com.nascimento.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TimeController {
	
	@RequestMapping(value = "/timeView", method = RequestMethod.GET)
	public String getTimeView() {
		     
		   return "timeView";
	}
	
	@RequestMapping(value = "/timeView2", method = RequestMethod.GET)
	public String getTimeView2() {
		     
		   return "timeView2";
	}
	
	@RequestMapping(value = "/timeView3", method = RequestMethod.GET)
	public String getTimeView3() {
		     
		   return "timeView3";
	}

}
