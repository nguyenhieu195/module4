package com.hieudev.demo.Controller;


import com.hieudev.demo.Entity.Student;
import com.hieudev.demo.Service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String home(Model model) {
        List<Student> students = studentService.getStudents();
        model.addAttribute("students", students);
        return "list";
    }
}
