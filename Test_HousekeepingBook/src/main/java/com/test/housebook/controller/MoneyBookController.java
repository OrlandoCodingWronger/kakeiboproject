package com.test.housebook.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.housebook.service.MoneyBookService;
import com.test.housebook.vo.MoneyBookVO;

@Controller
@RequestMapping(value = "/moneybook")
public class MoneyBookController {

	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	private MoneyBookService service;

	@RequestMapping(value = "/selectList", method = RequestMethod.GET)
	public String selectList(Model model,
			@RequestParam(value = "search_type", defaultValue = "all") String searchType,
			@RequestParam(value = "search_value", defaultValue = "") String searchValue) {
		logger.info("가계부 이동");
		ArrayList<HashMap<String, Object>> list = service.selectList(searchType, searchValue);
		model.addAttribute("list", list);
		return "moneybook/selectList";
	}

	@RequestMapping(value = "/insertForm", method = RequestMethod.GET)
	public String insertForm() {
		logger.info("가계부 입력 폼 이동");
		return "moneybook/insertForm";
	}

	@RequestMapping(value = "/insertMoneyBook", method = RequestMethod.POST)
	public String insertMoneyBook(MoneyBookVO moneyBook) {
		logger.info("가계부 입력 시작");
		logger.info("입력할 데이터: {}", moneyBook);
		service.insertMoneyBook(moneyBook);
		logger.info("가계부 입력 종료");
		return "redirect:/moneybook/selectList";
	}

	@RequestMapping(value = "/updateForm", method = RequestMethod.GET)
	public String updateForm(Model model, String moneybook_no) {
		logger.info("가계부 수정 폼 이동");
		MoneyBookVO moneybook = service.selectOne(moneybook_no);
		logger.info("mb: {}", moneybook);
		model.addAttribute("moneybook", moneybook);
		return "moneybook/updateForm";
	}

	@RequestMapping(value = "/updateMoneyBook", method = RequestMethod.POST)
	public String updateMoneyBook(MoneyBookVO moneyBook) {
		logger.info("가계부 수정 시작");
		logger.info("수정할 데이터: {}", moneyBook);
		service.updateMoneyBook(moneyBook);
		logger.info("가계부 수정 종료");
		return "redirect:/moneybook/selectList";
	}

	@RequestMapping(value = "/deleteMoneyBook", method = RequestMethod.GET)
	public String deleteMoneyBook(String moneybook_no) {
		logger.info("가계부 삭제 시작");
		logger.info("삭제할 번호: {}", moneybook_no);
		service.deleteMoneyBook(moneybook_no);
		logger.info("가계부 삭제 종료");
		return "redirect:/moneybook/selectList";
	}

	@ResponseBody
	@RequestMapping(value = "/totalResult", method = RequestMethod.GET)
	public String totalResult(String searchType) {
		return service.totalResult(searchType);
	}

	@ResponseBody
	@RequestMapping(value = "/minMax", method = RequestMethod.GET)
	public String minMax(String searchType) {
		return service.minMax(searchType);
	}
}
