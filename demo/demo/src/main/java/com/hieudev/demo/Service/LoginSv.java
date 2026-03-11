package com.hieudev.demo.Service;

import com.hieudev.demo.Entity.Account;
import com.hieudev.demo.Repo.LoginRp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginSv implements ILoginSv {

    @Autowired
    private LoginRp loginRp;

    @Override
    public List<Account> getListAccount() {
        return loginRp.getListAccount();
    }

    @Override
    public Account checkLogin(String username, String password) {
        return loginRp.checkLogin(username, password);
    }
}
