package com.schoolmgnt.service;

import java.util.List;

import com.schoolmgnt.dto.TeacherDTO;
import com.schoolmgnt.entity.Teacher;

public interface TeacherService 
{
	Teacher insertDataRecord(TeacherDTO teacherDTO);
	
	Teacher getDetailsById(int teacherId);
	
	List<Teacher> getDetalisAll();
	
	String deleteTeacherDetails(int teacherId);
	
	Teacher updateTeacherDetails(Teacher teacher,int teacherId);
	
	String deletedetailsAll();
}
