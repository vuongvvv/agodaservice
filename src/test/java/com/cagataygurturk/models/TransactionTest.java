package com.cagataygurturk.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransactionTest {

	protected String oldPassword = "AgodaService2!@1";
	protected String newPassword = "AgodaService2!@132";

	protected Transaction getTransactionObject() {
		return new Transaction(oldPassword, newPassword);
	}

	@Test
	public void testSetTransaction() throws Exception {
		Transaction transaction = getTransactionObject();
		assertEquals(oldPassword, transaction.oldPassword);
		assertEquals(newPassword, transaction.newPassword);
	}
}