package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED)	// 클래스의 모든 메소드에 트랜잭션을 적용
public class AccountService {
	private AccountDAO accDAO;
	
	// 속성 accDAO에 빈을 주입하기 위해 setter를 구현
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	// 두개의 SQL문을 실행
	public void sendMoney() throws Exception {
		accDAO.updateBalace1();
		accDAO.updateBalace2();
	}
	
}
