package com.example.demo.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Teacher;
import com.example.demo.models.TeacherModel;
import com.example.demo.repository.TeacherRepository;
import com.example.demo.services.TeacherService;

@Service("teacherService")
public class TeacherServicesImpl implements TeacherService {

	@Autowired
	@Qualifier("teacherRepository")
	private TeacherRepository teacherRepository;
	
	private TeacherModel entity2model(Teacher teacher) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(teacher, TeacherModel.class);
	}

	private Teacher model2entity(TeacherModel teacherModel) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(teacherModel, Teacher.class);
	}

	@Override
	public List<TeacherModel> listAllTeachers() {
		List<TeacherModel> teacherList = new ArrayList<>();
		for (Teacher t : teacherRepository.findAll()) {
			teacherList.add(entity2model(t));
		}
		return teacherList;
	}

	@Override
	public Teacher addTeacher(TeacherModel teacherModel) {
		return teacherRepository.save(model2entity(teacherModel));
	}

	@Override
	public int removeTeacher(int id) {
		teacherRepository.deleteById(id);
		return 0;
	}

	@Override
	public Teacher updateTeacher(TeacherModel teacherModel) {
		return teacherRepository.save(model2entity(teacherModel));
	}

}
