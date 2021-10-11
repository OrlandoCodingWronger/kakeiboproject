package com.test.housebook.dao;

import com.test.housebook.vo.AccountVO;

public interface AccountMapper {
	public int insertAccount(AccountVO account);
	public AccountVO selectAccountOne(String acc_id);
}
