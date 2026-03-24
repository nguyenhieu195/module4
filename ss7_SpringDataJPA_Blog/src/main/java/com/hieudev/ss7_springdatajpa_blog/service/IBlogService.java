package com.hieudev.ss7_springdatajpa_blog.service;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    // cả lưu và sửa
    boolean save(Blog blog);

    // hiển thị danh sách blog
    List<Blog> findAll();

    // tìm theo id
    Blog findById(int id);

    // xoá theo id
    void delete(int id);

    // list blog theo tên
    List<Blog> findAllByTitle(String title);

    List<Blog> findAllByContent(String title);

    List<Blog> findAllByAuthor(String title);
}
