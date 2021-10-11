package com.test.housebook.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.MoneyBookVO;

@Repository
public class MoneyBookDAO {

	@Autowired
	private SqlSession session;

	public ArrayList<HashMap<String, Object>> selectList(HashMap<String, Object> map) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		ArrayList<HashMap<String, Object>> list = null;

		try {
			list = mapper.selectList(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public int insertMoneyBook(MoneyBookVO moneyBook) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.insertMoneyBook(moneyBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
	public MoneyBookVO selectOne(String moneybook_no) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		MoneyBookVO result = null;

		try {
			result = mapper.selectOne(moneybook_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public int updateMoneyBook(MoneyBookVO moneyBook) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.updateMoneyBook(moneyBook);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public int deleteMoneyBook(String moneybook_no) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		int cnt = 0;
		
		try {
			cnt = mapper.deleteMoneyBook(moneybook_no);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public String monthlyIncome(String loginId) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		String result = null;
		
		try {
			result = mapper.monthlyIncome(loginId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public String totalResult(HashMap<String, Object> map) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		String result = null;

		try {
			result = mapper.totalResult(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String minMax(HashMap<String, Object> map) {
		MoneyBookMapper mapper = session.getMapper(MoneyBookMapper.class);
		String result = null;

		try {
			result = mapper.minMax(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
