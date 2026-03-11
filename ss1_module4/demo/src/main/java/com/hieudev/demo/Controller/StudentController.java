package com.hieudev.demo.Controller;


import com.hieudev.demo.Entity.Student;
import com.hieudev.demo.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;
//    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("")
    public String home(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "student/list";
    }

    @GetMapping("/add")
    public String add(){
        return "student/add";
    }
    @PostMapping("/add")
    public String addStudent(@RequestParam("id") int id,
                             @RequestParam("name") String name,
                             @RequestParam("score") Double score,
                             RedirectAttributes redirectAttributes) {
        studentService.save(new Student(id, name, score));
        redirectAttributes.addFlashAttribute("mess", "add successfully");
        return "redirect:/student";
    }
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable int id, Model model) {
        Student student = studentService.findById(id);
        model.addAttribute("student", student);
        return "student/detail";
    }
}
