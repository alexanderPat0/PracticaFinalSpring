package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Course;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Serializable>{

}
