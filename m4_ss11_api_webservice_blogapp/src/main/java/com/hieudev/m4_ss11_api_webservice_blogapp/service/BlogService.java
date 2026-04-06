package com.hieudev.m4_ss11_api_webservice_blogapp.service;

import com.hieudev.m4_ss11_api_webservice_blogapp.entity.Blog;
import com.hieudev.m4_ss11_api_webservice_blogapp.repository.IBlogRepository;
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
    public Blog save(Blog blog) {
        if (blog.getCreatedAt() == null) {
            blog.setCreatedAt(LocalDateTime.now());
        }
//        return blogRepository.save(blog) != null;
        return blogRepository.save(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
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

    @Override
    public Page<Blog> searchAll(String title, Pageable pageable) {
        return blogRepository.searchAll(title,  pageable);
    }

    public List<Blog> getListCategory(String title) {}
}
