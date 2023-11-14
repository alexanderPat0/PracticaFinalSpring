package com.example.demo.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Course;
import com.example.demo.models.CourseModel;
import com.example.demo.repository.CourseRepository;
import com.example.demo.services.CourseService;

@Service("courseService")
public class CourseServicesImpl implements CourseService {

	@Autowired
	@Qualifier("courseRepository")
	private CourseRepository courseRepository;

	private CourseModel entity2model(Course course) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(course, CourseModel.class);
	}

	private Course model2entity(CourseModel courseModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(courseModel, Course.class);
	}

	@Override
	public List<CourseModel> listAllCourses() {
		List<CourseModel> courseList = new ArrayList<>();
		for (Course c : courseRepository.findAll()) {
			courseList.add(entity2model(c));
		}
		return courseList;
	}

	@Override
	public Course addCourse(CourseModel courseModel) {
		return courseRepository.save(model2entity(courseModel));
	}

	@Override
	public int removeCourse(int id) {
		courseRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course updateCourse(CourseModel courseModel) {
		return courseRepository.save(model2entity(courseModel));
	}

}
