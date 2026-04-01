package com.hieudev.m4_ss9_aop_book.repository;

import com.hieudev.m4_ss9_aop_book.entity.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowRecordRepository extends JpaRepository<BorrowRecord, String> {
}
