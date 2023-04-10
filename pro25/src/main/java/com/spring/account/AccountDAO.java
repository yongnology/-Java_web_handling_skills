package com.spring.account;

import org.apache.ibatis.session.SqlSession;
import org.springframework.dao.DataAccessException;

public class AccountDAO {
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public void updateBalace1() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance1");
	}
	
	public void updateBalace2() throws DataAccessException {
		sqlSession.update("mapper.account.updateBalance2");
	}
}
