package org.dragon.yunpeng.metronic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/demo")
	public String demo() {

		return "samples/demo1";
	}
	
	@GetMapping("/pageTemplate")
	public String pageTemplate() {

		return "samples/pageTemplate";
	}
	
	@GetMapping("/formExample")
	public String formDetail() {

		return "samples/formExample";
	}
}
