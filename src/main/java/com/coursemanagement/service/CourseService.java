package com.coursemanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.coursemanagement.model.Course;
import com.coursemanagement.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Save course
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    // Get course by ID
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    // Delete course
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
