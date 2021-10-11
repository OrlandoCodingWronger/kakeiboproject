package com.test.housebook.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.housebook.vo.AccountVO;

@Repository
public class AccountDAO {

	@Autowired
	private SqlSession session;

	public int insertAccount(AccountVO account) {
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		int cnt = 0;

		try {
			cnt = mapper.insertAccount(account);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return cnt;
	}

	public AccountVO selectAccountOne(String acc_id) {
		AccountMapper mapper = session.getMapper(AccountMapper.class);
		AccountVO account = null;

		try {
			account = mapper.selectAccountOne(acc_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return account;
	}
}
