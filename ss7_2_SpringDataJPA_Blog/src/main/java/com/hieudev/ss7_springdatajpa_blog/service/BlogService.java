package com.hieudev.ss7_springdatajpa_blog.service;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import com.hieudev.ss7_springdatajpa_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public boolean save(Blog blog) {
        if (blog.getCreatedAt() == null) {
            blog.setCreatedAt(LocalDateTime.now());
        }
        return blogRepository.save(blog) != null;
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchAll(String title, Pageable pageable) {
        return blogRepository.searchAll(title,  pageable);
    }
}
