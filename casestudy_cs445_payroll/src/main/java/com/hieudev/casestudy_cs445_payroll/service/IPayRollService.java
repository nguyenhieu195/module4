package com.hieudev.casestudy_cs445_payroll.service;

import com.hieudev.casestudy_cs445_payroll.model.PayRoll;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPayRollService {
    Page<PayRoll> findAll(Pageable pageable);

    PayRoll save(PayRoll payRoll);

    PayRoll findById(Integer id);

    void deleteById(Integer id);

    PayRoll update(Integer id, PayRoll payRoll);

    Page<PayRoll> searchByNameAndBenefitPlan(String name, Pageable pageable);
}

