package com.hieudev.m4_ss9_aop_book.repository;

import com.hieudev.m4_ss9_aop_book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
