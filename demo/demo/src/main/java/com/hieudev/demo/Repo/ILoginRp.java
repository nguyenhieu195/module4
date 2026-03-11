package com.hieudev.demo.Repo;

import com.hieudev.demo.Entity.Account;

import java.util.List;

public interface ILoginRp {
    List<Account> getListAccount();

    Account checkLogin(String username, String password);
}
