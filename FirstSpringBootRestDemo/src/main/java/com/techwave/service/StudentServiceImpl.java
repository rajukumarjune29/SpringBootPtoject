package com.techwave.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techwave.model.Student;
import com.techwave.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository repo;

	@Override
	public List<Student> getAllStudents() {
		
		return repo.findAll();
	}
	@Override
	public Student save(Student student) {
		return repo.save(student);
	}
	@Override
	public Optional<Student> getStudentById(Integer id) {
		
		return repo.findById(id);
	}
	
}
