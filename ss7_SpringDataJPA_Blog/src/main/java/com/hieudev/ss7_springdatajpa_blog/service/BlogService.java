package com.hieudev.ss7_springdatajpa_blog.service;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import com.hieudev.ss7_springdatajpa_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        blogRepository.deleteById(id);
    }
}
