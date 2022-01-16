package com.techwave.service;

import java.util.List;
import java.util.Optional;

import com.techwave.model.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();

	public Student save(Student student);
	public Optional<Student> getStudentById(Integer id);
}
