package com.hieudev.m4_ss9_aop_book.controller;

import com.hieudev.m4_ss9_aop_book.entity.Book;
import com.hieudev.m4_ss9_aop_book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.findAll());
        return "list";
    }

    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable Long id, Model model) {
        Book book = bookService.findById(id);
        if (book == null) {
            return "error";
        }
        model.addAttribute("book", book);
        return "detail";
    }

    @PostMapping("/borrow/{id}")
    public String borrowBook(@PathVariable Long id, Model model) {
        try {
            String code = bookService.borrowBook(id);
            model.addAttribute("code", code);
            return "borrowSuccess";
        } catch (Exception e) {
            return "error";
        }
    }

    @GetMapping("/return")
    public String returnForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam String code, Model model) {
        try {
            bookService.returnBook(code);
            model.addAttribute("message", "Book returned successfully");
            return "returnSuccess";
        } catch (Exception e) {
            return "error";
        }
    }
}
