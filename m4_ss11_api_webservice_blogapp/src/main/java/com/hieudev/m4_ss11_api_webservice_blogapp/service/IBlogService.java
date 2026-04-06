package com.hieudev.m4_ss11_api_webservice_blogapp.service;

import com.hieudev.m4_ss11_api_webservice_blogapp.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    // cả lưu và sửa
    Blog save(Blog blog);

    // hiển thị danh sách blog
    Page<Blog> findAll( Pageable pageable);
    List<Blog> findAll();

    // tìm theo id
    Blog findById(int id);

    // xoá theo id
    void delete(int id);

    // list blog theo tên

    Page<Blog> searchAll(String title, Pageable pageable);
    List<Blog> searchAll(String title);
}
