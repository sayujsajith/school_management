package com.schoolmgnt.serviceImp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgnt.dto.StudentDTO;
import com.schoolmgnt.entity.Student;
import com.schoolmgnt.repositories.StudentRepository;
import com.schoolmgnt.service.StudentService;

@Service
public class StudentServiceImp implements StudentService 
{
	@Autowired
	StudentRepository studentRepo;
	
								//Inserting the Student Details in Student Table.
	@Override
	public Student insertStudent(StudentDTO studentDTO) 
	{
		Student student=Student.builder().studentName(studentDTO.getStudentName())
										 .studentDOB(studentDTO.getStudentDOB())
										 .email(studentDTO.getEmail())
										 .address(studentDTO.getAddress())
										 .phoneNumber(studentDTO.getPhoneNumber())
										 .build();
								
		return studentRepo.save(student);
	}
	
	
								//Retrieve the Student Details by given StudentID.
	@Override
	public Student getDetailsById(int studentId ) 
	{
		return studentRepo.findById(studentId).get();
	}
	
	
	
						//Retrieve the All Student Details
	@Override
	public List<Student> getDetailsAll() 
	{
		return studentRepo.findAll();
	}
	
	
								//Delete the Student Details By given ID
	@Override
	public String deleteId(int studentId) 
	{
	 studentRepo.deleteById(studentId);
	return "Students details Deleted sucessfully";
	}
	
								//Delete the All Student Details
	@Override
	public String deleteAll()
	{
		studentRepo.deleteAll();
		return "All Student details deleted";
	}
	
	
								//Update the Student Details by given ID.
	@Override
	public  Student updateDetails(Student params,int studentId) 
	{
		Student stud=studentRepo.findById(studentId).get();
		stud.setStudentName (params.getStudentName());
		stud.setPhoneNumber (params.getPhoneNumber());
		stud.setStudentDOB  (params.getStudentDOB());
		stud.setEmail(params.getEmail());
		stud.setAddress     (params.getAddress());
		
		return studentRepo.save(stud);
	}	
}
