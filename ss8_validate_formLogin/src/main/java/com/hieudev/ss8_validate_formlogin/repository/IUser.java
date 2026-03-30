package com.hieudev.ss8_validate_formlogin.repository;

import com.hieudev.ss8_validate_formlogin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User, Integer> {

}
