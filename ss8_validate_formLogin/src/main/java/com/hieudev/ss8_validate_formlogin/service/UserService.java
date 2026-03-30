package com.hieudev.ss8_validate_formlogin.service;

import com.hieudev.ss8_validate_formlogin.entity.User;
import com.hieudev.ss8_validate_formlogin.repository.IUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUser iUser;

    @Override
    public boolean save(User user) {
        User user1 = iUser.save(user);
        return user1 != null;
    }
}
