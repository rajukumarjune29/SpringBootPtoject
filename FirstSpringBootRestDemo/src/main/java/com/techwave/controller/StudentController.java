package com.techwave.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techwave.model.Student;
import com.techwave.service.StudentService;



@RestController
@RequestMapping("student")
public class StudentController {
	@Autowired
	private StudentService service;
	@GetMapping("/students")
	public ResponseEntity<List<Student>> students() {
		List<Student> students= service.getAllStudents();
		return ResponseEntity.ok(students);
	}
	
	@PostMapping("/student")
	public ResponseEntity<Student> saveSundent(@RequestBody() Student student){
		return ResponseEntity.ok(service.save(student));
		
	}
	@GetMapping("/student/{id}")
	public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id") Integer id){
		System.out.println(id);
		return ResponseEntity.ok(service.getStudentById(id));
	}

}
