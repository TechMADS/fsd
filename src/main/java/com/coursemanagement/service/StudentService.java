package com.coursemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.coursemanagement.model.Student;
import com.coursemanagement.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
