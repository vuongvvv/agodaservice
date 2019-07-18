package com.cagataygurturk.models;

import java.io.Serializable;

import com.cagataygurturk.storage.Storable;


public class Transaction implements Serializable, Storable {

    protected String oldPassword;
    
    protected String newPassword;

    public Transaction(String oldPassword, String newPassword) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }
}
