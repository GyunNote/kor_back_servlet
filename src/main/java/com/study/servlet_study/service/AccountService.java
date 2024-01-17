package com.study.servlet_study.service;

import java.util.List;

import com.study.servlet_study.entity.Account;
import com.study.servlet_study.repository.AccountRepository;
import com.study.servlet_study.service.AccountService;

public class AccountService {
	
	private static AccountService instance;
	private AccountRepository accountRepository;
	
	private AccountService() {
		accountRepository = AccountRepository.getInstance();
		
	}
	
    public static AccountService getInstance(){
    	
        if(instance == null){
            instance = new AccountService();
        }
        return instance;
    }
    
    public int addAccount(Account account) {
		return accountRepository.saveAccount(account);
	}
    
    public Account getAccount(String username) {
    	return accountRepository.findAccountByUsername(username);
    }

}
