package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Teacher;
import com.example.demo.models.TeacherModel;

public interface TeacherService {
	
	List<TeacherModel> listAllTeachers();
	Teacher addTeacher(TeacherModel teacherModel);
	int removeTeacher(int id);
	Teacher updateTeacher(TeacherModel teacherModel);

}
