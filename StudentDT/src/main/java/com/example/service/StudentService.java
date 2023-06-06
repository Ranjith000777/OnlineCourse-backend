package com.example.service;

import java.util.List;

import com.example.model.Student;


public interface StudentService {

	public Student saveStudent(Student student) ;
	public List<Student> getAllStudent() ;
	public Student saveFlush(Student student) ;
}
