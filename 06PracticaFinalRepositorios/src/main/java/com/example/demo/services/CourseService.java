package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Course;
import com.example.demo.models.CourseModel;

public interface CourseService {

	List<CourseModel> listAllCourses();
	Course addCourse(CourseModel courseModel);
	int removeCourse(int id);
	Course updateCourse(CourseModel courseModel);	
	
}
