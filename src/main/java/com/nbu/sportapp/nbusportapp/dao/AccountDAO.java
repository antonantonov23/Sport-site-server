package com.nbu.sportapp.nbusportapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nbu.sportapp.nbusportapp.entity.account.Account;
import com.nbu.sportapp.nbusportapp.repository.AccountRepository;

// DATA ACCESS OBJECT
@Service
public class AccountDAO {

	@Autowired
	private AccountRepository accountRepository;

	/* to save an account in DB */

	public Account save(Account account) {
		return this.accountRepository.save(account);
	}

	/* search all accounts */

	public List<Account> findAll() {
		return this.accountRepository.findAll();
	}

	/* get an account */

	public Account findOne(Long accountId) {
		return this.accountRepository.findOne(accountId);
	}

	/* delete an account */

	public void delete(Account account) {
		this.accountRepository.delete(account);
	}
}
