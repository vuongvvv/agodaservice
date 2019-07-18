package com.cagataygurturk.services.transaction;

import com.cagataygurturk.services.transaction.repository.TransactionRepository;
import com.cagataygurturk.services.util.PasswordValidation;
import com.cagataygurturk.services.util.StringSimilarity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImpl implements TransactionService {

	protected TransactionRepository repository;

	@Autowired
	public TransactionServiceImpl(@Qualifier("transaction_repository_inmemory") TransactionRepository repository) {

		this.repository = repository;

	}

	public Boolean changePassword(String oldPassword, String newPassword) {
		System.out.println(oldPassword);
		System.out.println(newPassword);
		if (!PasswordValidation.isOldPassword(oldPassword)) {
			System.out.println("oldPassword");
			return false;
		} else if (!PasswordValidation.isValidPassword(newPassword)) {
			System.out.println("isValidPassword");
			return false;
		} else if (StringSimilarity.similarity(oldPassword, newPassword) * 100 > 80) {
			System.out.println("similarity");
			return false;
		}
		return true;
	}
}
