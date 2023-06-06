package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.repository.StudRepository;


@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
	@Autowired
	
	private StudRepository studentRepository ;
	

	@PostMapping(value="/add", produces="application/json")
	public Student add(final @RequestBody Student student)
	{
		return studentRepository.save(student) ;
		
	}
	@GetMapping("/get")
	public List<Student> getAllStudent()
	{
		return studentRepository.findAll() ;
	}
	@GetMapping("/gets/{id}")
	public Student getAllStudents(@PathVariable int id)
	{
		return studentRepository.findById(id).orElse(null) ;
	}
	@PutMapping("/put/{id}")
	Student update(@RequestBody Student student, @PathVariable int id)
	{
		return studentRepository.findById(id)
				.map(students->{
					students.setName(student.getName()) ;
					students.setAge(student.getAge());
					students.setGender(student.getGender());
					students.setMobile(student.getMobile());
					students.setEmail(student.getEmail());
					students.setCourse(student.getCourse());
					students.setGraduation(student.getGraduation());
					return studentRepository.save(students);
				}).orElseThrow() ;
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		studentRepository.deleteById(id) ;
		return "Deleted Successfully" ;
	}
	
}
