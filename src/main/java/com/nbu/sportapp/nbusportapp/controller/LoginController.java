package com.nbu.sportapp.nbusportapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nbu.sportapp.nbusportapp.dao.AccountDAO;
import com.nbu.sportapp.nbusportapp.entity.account.Account;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class LoginController {

	@Autowired
	AccountDAO accountDAO;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	private PasswordEncoder encoder;

	@PostMapping("/account/registerUserAccount")
	public ResponseEntity<Account> registerUserAccount(@RequestBody Account jsonAccount) {
		Account account = new Account();
		account.setFullName(jsonAccount.getFullName());
		account.setPassword(encoder.encode(jsonAccount.getPassword()));
		account.setEmail(jsonAccount.getEmail());
		if (!accountExists(jsonAccount)) {
			this.accountDAO.save(account);
			return ResponseEntity.ok().body(account);
		} else
			return ResponseEntity.badRequest().build();
	}

	@PostMapping("/account/registerAdminAccount")
	public ResponseEntity<Account> registerAdminAccount(@Valid @RequestBody Account jsonAccount) {
		Account account = new Account();
		account.setFullName(jsonAccount.getFullName());
		account.setPassword(encoder.encode(jsonAccount.getPassword()));
		account.setEmail(jsonAccount.getEmail());
		account.setIsAdmin(true);
		if (!accountExists(jsonAccount)) {
			this.accountDAO.save(account);
			return ResponseEntity.ok().body(account);
		} else
			return ResponseEntity.badRequest().build();
	}

	@PostMapping("/account/login")
	public ResponseEntity<Account> login(@Valid @RequestBody Account account) {
		List<Account> accountList = this.accountDAO.findAll();
		for (Account currentAccount : accountList) {
			if (areEqual(account, currentAccount))
				return ResponseEntity.ok().body(currentAccount);
		}
		return ResponseEntity.notFound().build();
	}

	private boolean areEqual(Account firstAccount, Account secondAccount) {
		return firstAccount.getEmail().equals(secondAccount.getEmail())
				&& this.encoder.matches(firstAccount.getPassword(), secondAccount.getPassword());
	}

	private boolean accountExists(Account account) {
		List<Account> accountList = this.accountDAO.findAll();
		for (Account currentAccount : accountList) {
			if (currentAccount.getEmail().equals(account.getEmail()))
				return true;
		}
		return false;
	}

}
