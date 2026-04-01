package com.hieudev.m4_ss9_aop_book.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BorrowRecord {
    @Id
    private String code;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
