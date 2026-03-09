package com.hieudev.demo.Repository;

import com.hieudev.demo.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements IStudentRepo{

    private static List<Student> students = new ArrayList<>();

     static {
        students.add(new Student(1,"hieu", 10));
        students.add(new Student(2,"tai", 4));
        students.add(new Student(3,"huy", 1));
        students.add(new Student(4,"thao", 3));
        students.add(new Student(5,"dai", 8));
        students.add(new Student(6,"nhi", 0));
    }

    @Override
    public List<Student> getStudents() {
        return students;
    }

    @Override
    public void addStudent(Student student) {
        students.add(student);
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
