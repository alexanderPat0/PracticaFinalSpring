package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.models.CourseModel;
import com.example.demo.services.CourseService;
import com.example.demo.services.TeacherService;

@Controller
@RequestMapping("/courses")
public class CourseController {
	
	public static final String COURSELIST_VIEW = "course/courseList";
	public static final String FORM_VIEW = "course/courseAdd";
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/courseList")
	public ModelAndView listCourses() {
		ModelAndView mav = new ModelAndView(COURSELIST_VIEW);
		List<CourseModel> coursesList = courseService.listAllCourses();
		mav.addObject(coursesList);
		return mav;
	}
	
	@GetMapping("/addCourse")
	public String addCourse(@ModelAttribute("course") CourseModel courseModel, RedirectAttributes flash) {		
		return FORM_VIEW;
	}
	
	@GetMapping("/editCourse")
	public ModelAndView editCourse(CourseModel course) {
		ModelAndView mav = new ModelAndView(FORM_VIEW);
		mav.addObject(course);
		return mav;
	}

}