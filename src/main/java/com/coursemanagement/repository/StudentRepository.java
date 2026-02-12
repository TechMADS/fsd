package com.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coursemanagement.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
