package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.test.housebook.vo.MoneyBookVO;

public interface MoneyBookMapper {
	public ArrayList<HashMap<String, Object>> selectList(HashMap<String, Object> map);
	public int insertMoneyBook(MoneyBookVO moneyBook);
	public MoneyBookVO selectOne(String moneybook_no);
	public int updateMoneyBook(MoneyBookVO moneyBook);
	public int deleteMoneyBook(String moneybook_no);
	public String monthlyIncome(String loginId);
	public String totalResult(HashMap<String, Object> map);
	public String minMax(HashMap<String, Object> map);
}
