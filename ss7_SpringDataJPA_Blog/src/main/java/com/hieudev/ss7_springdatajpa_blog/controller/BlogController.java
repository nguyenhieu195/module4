package com.hieudev.ss7_springdatajpa_blog.controller;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import com.hieudev.ss7_springdatajpa_blog.service.IBlogService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String home(ModelMap model) {
        List<Blog> blogs = iBlogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blogs/list";
    }

    // hiển thị form tạo
    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("blog", new Blog());
        return "blogs/create";
    }

    // tạo blog mới
    @PostMapping("/create")
    public String create(@ModelAttribute("blog") Blog blog, ModelMap model) {
        iBlogService.save(blog);
        return "redirect:/blogs";
    }

    // xoá blog
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        iBlogService.delete(id);
        return "redirect:/blogs";
    }

    // xem chi tiết
    @GetMapping("/detail")
    public String details(@RequestParam("id") Integer id, ModelMap model) {
        Blog blog = iBlogService.findById(id);
        model.addAttribute("blog", blog);
        return "blogs/detail";
    }

    // tìm kiếm theo tên
    @GetMapping("/search")
    public String search(@RequestParam("key") String key, ModelMap model) {
        List<Blog> blogs = iBlogService.findAllByTitle(key);

        if (blogs.isEmpty()) {
            blogs = iBlogService.findAllByAuthor(key);
        }

        if (blogs.isEmpty()) {
            blogs = iBlogService.findAllByContent(key);
        }
        model.addAttribute("blogs",blogs);
        return "blogs/list";
    }
}
