package com.hieudev.demo.Service;

import com.hieudev.demo.Entity.Student;
import com.hieudev.demo.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepo studentRepo;

    @Override
    public List<Student> getStudents() {
        return studentRepo.getStudents();
    }

    @Override
    public void save(Student student) {
        studentRepo.addStudent(student);
    }

    @Override
    public Student findById(int id) {
        return studentRepo.findById(id);
    }
}
