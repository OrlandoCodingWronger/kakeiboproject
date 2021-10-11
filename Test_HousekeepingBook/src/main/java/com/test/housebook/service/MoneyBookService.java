package com.test.housebook.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.housebook.dao.MoneyBookDAO;
import com.test.housebook.vo.MoneyBookVO;

@Service
public class MoneyBookService {
	
	@Autowired
	private MoneyBookDAO dao;

	@Autowired
	private HttpSession session;
	
	public ArrayList<HashMap<String, Object>> selectList(String searchType, String searchValue) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		map.put("loginId", (String) session.getAttribute("loginId"));
		return dao.selectList(map);
	}

	public void insertMoneyBook(MoneyBookVO moneyBook) {
		moneyBook.setAcc_id((String) session.getAttribute("loginId"));
		if (moneyBook.getMoneybook_type().equals("income"))
			moneyBook.setMoneybook_type("収入");
		else
			moneyBook.setMoneybook_type("支出");
		int cnt = dao.insertMoneyBook(moneyBook);
		if (cnt > 0) {
			// 입력 성공
		} else {
			// 입력 실패
		}
	}
	
	public MoneyBookVO selectOne(String moneybook_no) {
		return dao.selectOne(moneybook_no);
	}

	public void updateMoneyBook(MoneyBookVO moneyBook) {
		if (moneyBook.getMoneybook_type().equals("income"))
			moneyBook.setMoneybook_type("収入");
		else
			moneyBook.setMoneybook_type("支出");
		int cnt = dao.updateMoneyBook(moneyBook);
		if (cnt > 0) {
			// 수정 성공
		} else {
			// 수정 실패
		}
	}

	public void deleteMoneyBook(String moneybook_no) {
		int cnt = dao.deleteMoneyBook(moneybook_no);
		if (cnt > 0) {
			// 삭제 성공
		} else {
			// 삭제 실패
		}
	}

	public String totalResult(String searchType) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("loginId", (String) session.getAttribute("loginId"));
		String result = dao.totalResult(map);

		return result;
	}

	public String minMax(String searchType) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("searchType", searchType);
		map.put("loginId", (String) session.getAttribute("loginId"));
		String result = dao.minMax(map);
		
		return result;
	}

}
