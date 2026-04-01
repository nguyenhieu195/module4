package com.hieudev.m4_ss9_aop_book.service;

import com.hieudev.m4_ss9_aop_book.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(Long id);
    String borrowBook(Long bookId);
    void returnBook(String code);
}
