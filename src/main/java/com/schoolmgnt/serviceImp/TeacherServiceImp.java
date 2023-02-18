package com.schoolmgnt.serviceImp;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schoolmgnt.dto.StudentDTO;
import com.schoolmgnt.dto.TeacherDTO;
import com.schoolmgnt.entity.Student;
import com.schoolmgnt.entity.Teacher;
import com.schoolmgnt.repositories.StudentRepository;
import com.schoolmgnt.repositories.TeacherReporsitory;
import com.schoolmgnt.service.TeacherService;

@Service
public class TeacherServiceImp implements TeacherService 
{
	@Autowired
	TeacherReporsitory teacherRepo;
	
	public Teacher teachId;
	
	
									//  1.Inserting the Student Details in Student Table.
	@Override
	public Teacher insertDataRecord(@Valid TeacherDTO teacherDTO) 
	{
		Teacher teacher = Teacher.builder()	.teacherName(teacherDTO.getTeacherName())
											.subject(teacherDTO.getSubject())
											.phoneNumber(teacherDTO.getPhoneNumber())							 
				 							.techEmail(teacherDTO.getTechEmail())
				 							.address(teacherDTO.getAddress())
				 							.student(teacherDTO.getStudent())
				 							.build();
		return teacherRepo.save(teacher);
	}

									//2.Retrieve the Teacher Details by given StudentID.
	@Override
	public Teacher getDetailsById(int teacherId)
	{
		return teacherRepo.findById(teacherId).get();
	}

	
									//3.Delete the Teacher Details By given ID
	@Override
	public String deleteTeacherDetails(int teacherId)
	{
		
			teacherRepo.deleteById(teacherId);
			return "teacher details deleted sucessfully";
			
	
	}
									//4.Update the Teacher Details by given ID.
	@Override
	public Teacher updateTeacherDetails(Teacher params, int teacherId) 
	{
		Teacher teach=teacherRepo.findById(teacherId).get();
				teach.setTeacherName  (params.getTeacherName());
				teach.setPhoneNumber  (params.getPhoneNumber());
				teach.setSubject	  (params.getSubject());
				teach.setTechEmail 	  (params.getTechEmail());
				teach.setAddress	  (params.getAddress());
		
		return teacherRepo.save(teach);
	}

									//5.Retrieve the All Teachers Details in Teacher Table.

	@Override
	public List<Teacher> getDetalisAll() 
	{
		return teacherRepo.findAll();
	}
									//6.Delete All the Teachers Details in table

	@Override
	public String deletedetailsAll()
	{
		teacherRepo.deleteAll();
		return "All Teacher details are deleted";
	}

}
