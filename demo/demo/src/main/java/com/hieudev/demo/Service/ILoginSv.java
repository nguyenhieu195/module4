package com.hieudev.demo.Service;

import com.hieudev.demo.Entity.Account;

import java.util.List;

public interface ILoginSv {


    List<Account> getListAccount();

    Account checkLogin(String username, String password);
}
