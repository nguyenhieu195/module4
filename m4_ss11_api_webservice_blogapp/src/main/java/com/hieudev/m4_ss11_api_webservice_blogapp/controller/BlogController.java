package com.hieudev.m4_ss11_api_webservice_blogapp.controller;

import com.hieudev.m4_ss11_api_webservice_blogapp.entity.Blog;
import com.hieudev.m4_ss11_api_webservice_blogapp.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    // Lấy danh sách blog
    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        List<Blog> blogs = iBlogService.findAll();

        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(blogs); // 200
    }

    // Tạo blog
    @PostMapping
    public ResponseEntity<Blog> create(@RequestBody Blog blog) {
        Blog saved = iBlogService.save(blog);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved); // 201
    }

    // Xoá blog
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);

        if (blog == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        iBlogService.delete(id);
        return ResponseEntity.noContent().build(); // 204
    }

    // Xem chi tiết
    @GetMapping("/{id}")
    public ResponseEntity<Blog> getById(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);

        if (blog == null) {
            return ResponseEntity.notFound().build(); // 404
        }

        return ResponseEntity.ok(blog); // 200
    }

    // Tìm kiếm
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> search(@RequestParam String key) {
        List<Blog> blogs = iBlogService.searchAll(key);

        if (blogs.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(blogs); // 200
    }

    // Danh sách category
    @GetMapping("/categories")
    public ResponseEntity<List<String>> getCategories() {
        List<String> categories = iBlogService.findAllCategories();

        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }

        return ResponseEntity.ok(categories); // 200
    }
}
