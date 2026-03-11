package com.hieudev.demo.Repo;

import com.hieudev.demo.Entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LoginRp implements ILoginRp {

    private static List<Account> list = new ArrayList<>();

    static {
        list.add(new Account("nguyenhieu", "1"));
        list.add(new Account("vanhieu", "3"));
        list.add(new Account("hieu", "2"));
    }

    @Override
    public List<Account> getListAccount() {
        return list;
    }
    @Override
    public Account checkLogin(String username, String password) {

        for (Account acc : list) {
            if (acc.getUsername().equals(username) &&
                    acc.getPassword().equals(password)) {
                return acc;
            }
        }

        return null;
    }
}
