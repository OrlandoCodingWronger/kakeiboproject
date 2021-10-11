package com.test.housebook.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.housebook.service.AccountService;
import com.test.housebook.vo.AccountVO;

@Controller
@RequestMapping(value="/account")
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService service;
	
	@RequestMapping(value="/loginForm" , method = RequestMethod.GET)
	public String loginForm() {
		logger.info("로그인 폼 이동");
		return "account/loginForm";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(AccountVO account) {
		logger.info("로그인 시작");
		String page = service.login(account);
		logger.info("로그인 종료");
		return page;
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout() {
		service.logout();
		return "redirect:/";
	}
	
	@RequestMapping(value="/insertAccount", method=RequestMethod.POST)
	public String insertAccount(AccountVO account) {
		logger.info("회원 가입 시작");
		String page = service.insertAccount(account);
		logger.info("회원 가입 종료");
		return page;
	}
	
	@RequestMapping(value="/insertAccountForm", method = RequestMethod.GET)
	public String insertAccountForm() {
		logger.info("회원 가입폼 이동");
		return "account/insertForm";
	}
}
