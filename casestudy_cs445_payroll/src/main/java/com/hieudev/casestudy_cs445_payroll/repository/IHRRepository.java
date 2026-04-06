package com.hieudev.casestudy_cs445_payroll.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHR extends JpaRepository<IHR, Integer> {
}
