package com.crud.ideacrm.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	//메인 화면
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView authmain(HttpServletRequest request){
		ModelAndView mView = new ModelAndView();

		mView.setViewName("page/index");
		return mView;
	}

	
}
