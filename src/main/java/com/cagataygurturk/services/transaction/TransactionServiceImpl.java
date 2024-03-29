package com.cagataygurturk.services.transaction;

import com.cagataygurturk.services.transaction.repository.TransactionRepository;
import com.cagataygurturk.services.util.PasswordValidation;
import com.cagataygurturk.services.util.StringSimilarity;

import javax.validation.constraints.Null;

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
		if(oldPassword==null || newPassword == null) {
			return false;
		}
		if (!PasswordValidation.isOldPassword(oldPassword)) {
			return false;
		} else if (!PasswordValidation.isValidPassword(newPassword)) {
			return false;
		} else if (StringSimilarity.isSimilarityExceedPercent(oldPassword, newPassword, 80)) {
			return false;
		}
		return true;
	}
}
