package com.hieudev.ss7_springdatajpa_blog.controller;

import com.hieudev.ss7_springdatajpa_blog.entity.Blog;
import com.hieudev.ss7_springdatajpa_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public String home(ModelMap model,@PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Blog> blogs = iBlogService.findAll(pageable);
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
    public String create(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        return "redirect:/blogs/list";
    }

    // xoá blog
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id) {
        iBlogService.delete(id);
        return "redirect:/blogs/list";
    }

    // xem chi tiết
    @GetMapping("/detail")
    public String details(@RequestParam("id") Integer id, ModelMap model) {
        Blog blog = iBlogService.findById(id);
        if (blog == null) {
            return "redirect:/blogs/list";  // Nếu blog không tồn tại, quay về danh sách
        }
        model.addAttribute("blog", blog);
        return "blogs/detail";
    }

    // tìm kiếm theo tên
    @GetMapping("/search")
    public String search(@RequestParam("key") String key,
                         ModelMap model,
                         @PageableDefault(size = 5) Pageable pageable) {
        model.addAttribute("blogs",iBlogService.searchAll(key, pageable));
        model.addAttribute("key",key); // giữ lại keyword khi chuyển trang
        return "blogs/list";
    }
}
