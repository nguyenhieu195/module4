package com.hieudev.demo.Repository;

import com.hieudev.demo.Entity.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> getStudents();
}
