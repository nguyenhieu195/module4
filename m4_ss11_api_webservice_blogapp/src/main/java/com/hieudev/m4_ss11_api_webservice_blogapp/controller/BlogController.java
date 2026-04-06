package com.hieudev.m4_ss11_api_webservice_blogapp.controller;

import com.hieudev.m4_ss11_api_webservice_blogapp.entity.Blog;
import com.hieudev.m4_ss11_api_webservice_blogapp.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

//    @GetMapping("/list")
//    public String home(ModelMap model,@PageableDefault(size = 5, sort = "createdAt", direction = Sort.Direction.ASC) Pageable pageable) {
//        Page<Blog> blogs = iBlogService.findAll(pageable);
//        model.addAttribute("blogs", blogs);
//        return "blogs/list";
//    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return iBlogService.findAll();
    }

//    @GetMapping("/listtt")
//    public  List home1(ModelMap model){
//        List<Blog> blogs = iBlogService.findAll();
//        return blogs;
//    }

    // hiển thị form tạo
//    @GetMapping("/create")
//    public String showFormCreate(Model model) {
//        model.addAttribute("blog", new Blog());
//        return "blogs/create";
//    }

    // tạo blog mới
//    @PostMapping("/create")
//    public String create(@ModelAttribute("blog") Blog blog) {
//        iBlogService.save(blog);
//        return "redirect:/blogs/list";
//    }

    @PostMapping("/createe")
    public Blog create2(@RequestBody Blog blog) {
        return iBlogService.save(blog);
    }

    // xoá blog
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        iBlogService.delete(id);
    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam("id") Integer id) {
//        iBlogService.delete(id);
//        return "redirect:/blogs/list";
//    }

    // xem chi tiết
    @GetMapping("/{id}")
    public Blog getById(@PathVariable Integer id) {
        return iBlogService.findById(id);
    }
//    @GetMapping("/detail")
//    public String details(@RequestParam("id") Integer id, ModelMap model) {
//        Blog blog = iBlogService.findById(id);
//        if (blog == null) {
//            return "redirect:/blogs/list";  // Nếu blog không tồn tại, quay về danh sách
//        }
//        model.addAttribute("blog", blog);
//        return "blogs/detail";
//    }

    // tìm kiếm theo tên
    @GetMapping("/search")
    public List<Blog> search(@RequestParam String key) {
        return iBlogService.searchAll(key);
    }
//    @GetMapping("/search")
//    public String search(@RequestParam("key") String key,
//                         ModelMap model,
//                         @PageableDefault(size = 5) Pageable pageable) {
//        model.addAttribute("blogs", iBlogService.searchAll(key, pageable));
//        model.addAttribute("key", key); // giữ lại keyword khi chuyển trang
//        return "blogs/list";
//    }
}
