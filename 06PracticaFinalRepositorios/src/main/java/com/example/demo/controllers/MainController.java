package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.services.CourseService;
import com.example.demo.services.TeacherService;

@Controller
@RequestMapping("/")
public class MainController {
	
	private static final String HOME_VIEW = "Main/Home.html";
	
	@Autowired
	@Qualifier("courseService")
	private CourseService courseService;
	
	@Autowired
	@Qualifier("teacherService")
	private TeacherService teacherService;
	
	@GetMapping("/home")
	public String home() {
		return HOME_VIEW;
	}
	

}
