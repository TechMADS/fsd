package com.coursemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coursemanagement.model.Course;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByTitleContainingIgnoreCase(String title);
}