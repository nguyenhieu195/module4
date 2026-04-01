package com.hieudev.m4_ss9_aop_book.exception;

import com.hieudev.m4_ss9_aop_book.exception.InvalidBorrowCodeException;
import com.hieudev.m4_ss9_aop_book.exception.OutOfStockException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OutOfStockException.class)
    public String handleOutOfStock() {
        return "error";
    }

    @ExceptionHandler(InvalidBorrowCodeException.class)
    public String handleInvalidCode() {
        return "error";
    }
}
