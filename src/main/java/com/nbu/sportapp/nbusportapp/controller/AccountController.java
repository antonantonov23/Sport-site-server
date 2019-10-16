package com.nbu.sportapp.nbusportapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;


import com.nbu.sportapp.nbusportapp.dao.AccountDAO;
import com.nbu.sportapp.nbusportapp.entity.account.Account;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
@RequestMapping("/sportapp")
public class AccountController {

	@Autowired
	AccountDAO accountDAO;

	/* to save an account */
	@PostMapping("/account")
	public Account createAccount(@Valid @RequestBody Account account) {
		return this.accountDAO.save(account);
	}

	/* get all accounts */
	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return this.accountDAO.findAll();
	}

	/* get an account by ID */
	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable(value = "id") Long accountId) {
		Account account = this.accountDAO.findOne(accountId);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(account);
	}

	/* update an account */
	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Long accountId,
			@Valid @RequestBody Account accountDetails) {
		Account account = this.accountDAO.findOne(accountId);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		account.setFullName(accountDetails.getFullName());
		account.setEmail(accountDetails.getEmail());
		account.setPassword(accountDetails.getPassword());

		Account updateAccount = this.accountDAO.save(account);
		return ResponseEntity.ok().body(updateAccount);

	}

	/* delete an account */
	@DeleteMapping("/account/{id}")
	public ResponseEntity<Account> deleteAccount(@PathVariable(value = "id") Long accountId) {

		Account account = this.accountDAO.findOne(accountId);
		if (account == null) {
			return ResponseEntity.notFound().build();
		}
		this.accountDAO.delete(account);

		return ResponseEntity.ok().build();
	}

}