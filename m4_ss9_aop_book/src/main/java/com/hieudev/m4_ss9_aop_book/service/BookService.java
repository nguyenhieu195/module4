package com.hieudev.m4_ss9_aop_book.service;

import com.hieudev.m4_ss9_aop_book.entity.Book;
import com.hieudev.m4_ss9_aop_book.entity.BorrowRecord;
import com.hieudev.m4_ss9_aop_book.exception.InvalidBorrowCodeException;
import com.hieudev.m4_ss9_aop_book.exception.OutOfStockException;
import com.hieudev.m4_ss9_aop_book.repository.IBookRepository;
import com.hieudev.m4_ss9_aop_book.repository.IBorrowRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository iBookRepository;

    @Autowired
    private IBorrowRecordRepository borrowRecordRepository;

    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public String borrowBook(Long bookId) {
        Book book = findById(bookId);
        if (book == null || book.getQuantity() <= 0) {
            throw new OutOfStockException();
        }
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);

        String code;
        do {
            code = String.format("%05d", new Random().nextInt(100000));
            /*
                %d : số nguyên
                5  : độ dài = 5 ký tự
                0  : nếu thiếu → thêm số 0 phía trước
             */
        } while (borrowRecordRepository.existsById(code));

        BorrowRecord record = new BorrowRecord(code, book);
        borrowRecordRepository.save(record);

        return code;
    }

    @Override
    @Transactional
    public void returnBook(String code) {
        BorrowRecord record = borrowRecordRepository.findById(code).orElse(null);
        if (record == null) {
            throw new InvalidBorrowCodeException();
        }
        Book book = record.getBook();
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
        borrowRecordRepository.delete(record);
    }
}
