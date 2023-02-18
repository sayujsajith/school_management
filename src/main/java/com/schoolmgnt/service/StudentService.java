package com.schoolmgnt.service;

import java.util.List;

import com.schoolmgnt.dto.StudentDTO;
import com.schoolmgnt.entity.Student;

public interface StudentService 
{
	Student insertStudent(StudentDTO studentDTO);
	
	Student getDetailsById(int studentId);
	
	List<Student> getDetailsAll();
	
	String deleteId(int studentId);
	
	String deleteAll();
	
	Student updateDetails(Student student,int studentId);

	
}
