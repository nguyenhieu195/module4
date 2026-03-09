package com.hieudev.demo.Repository;

import com.hieudev.demo.Entity.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> getStudents();

    void addStudent(Student student);

    Student findById(int id);
}
