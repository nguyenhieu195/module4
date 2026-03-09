package com.hieudev.demo.Service;

import com.hieudev.demo.Entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getStudents();

    void save(Student student);

    Student findById(int id);
}
