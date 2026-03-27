package com.hieudev.ss7_springdatajpa_blog.service;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    // cả lưu và sửa
    boolean save(Blog blog);

    // hiển thị danh sách blog
    Page<Blog> findAll( Pageable pageable);

    // tìm theo id
    Blog findById(int id);

    // xoá theo id
    void delete(int id);

    // list blog theo tên

    Page<Blog> searchAll(String title, Pageable pageable);
}
