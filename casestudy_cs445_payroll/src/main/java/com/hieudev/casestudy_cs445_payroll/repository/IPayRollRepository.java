package com.hieudev.casestudy_cs445_payroll.repository;

import com.hieudev.casestudy_cs445_payroll.model.PayRoll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPayRoll extends JpaRepository<PayRoll, Integer> {
}
