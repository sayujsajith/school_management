package com.schoolmgnt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmgnt.dto.TeacherDTO;
import com.schoolmgnt.entity.Teacher;
import com.schoolmgnt.exception.TeacherNotFoundException;
import com.schoolmgnt.serviceImp.TeacherServiceImp;

@RestController
public class TeacherController 
{
	@Autowired
	TeacherServiceImp teacherSerImp;
	//Beginning of mapping
	
	@PostMapping("/teacher")
	public ResponseEntity<Teacher> insertDataRecords(@RequestBody @Valid TeacherDTO teacherDto)
	{
		try
		{
			Teacher teach= teacherSerImp.insertDataRecord(teacherDto);
			if(teach!=null)
			{
				return new ResponseEntity<>(teacherSerImp.insertDataRecord(teacherDto),HttpStatus.CREATED);
			}
		}
			catch(Exception e)
			{
				throw new TeacherNotFoundException("Student data not inserted ! please enter the valid input");
			}
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/teacher/details/{teacherId}")
	public ResponseEntity<Teacher> getDetailsById(@PathVariable ("teacherId")int teacherId)
	{
		try
		{
			Teacher teach=teacherSerImp.getDetailsById(teacherId);
			if(teach != null)
			{
			 return new ResponseEntity<>(teacherSerImp.getDetailsById(teacherId),HttpStatus.FOUND);
			}
		}
		catch(Exception e)
		{
			throw new TeacherNotFoundException("Teacher data not Found ! please enter the valid input");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/teacher/delete/{teacherId}")
	public ResponseEntity<String> deleteTeacherDetails(@PathVariable("teacherId") int teacherId)
	{
		try
		{
			String teach=teacherSerImp.deleteTeacherDetails(teacherId);
			if(teach != null)
			//if(teach == teacherSerImp.teachId)
			{
				return new ResponseEntity<String>(teach,HttpStatus.FOUND);
				//teacherSerImp.deleteTeacherDetails(teacherId);
			}
		}
		catch(Exception e)
		{
			throw new TeacherNotFoundException("Teacher data not Deleted ! please enter the valid input");

		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/teacher/update/{teacherId}")
	 public ResponseEntity<Teacher> updateTeacherDetails(@RequestBody Teacher teacher,@PathVariable int teacherId) 
	{
		try
		{
			Teacher teach=teacherSerImp.updateTeacherDetails(teacher, teacherId);
			if(teach != null)
			{
				teacherSerImp.updateTeacherDetails(teacher, teacherId);
			}
		}
		catch(Exception e)
		{
			throw new TeacherNotFoundException("Teacher data not Modified ! please enter the valid input");
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@GetMapping("/teacher/details/all")
	public ResponseEntity<List<Teacher>> getDetalisAll() 
	{
		try
		{
			List<Teacher> teach=teacherSerImp.getDetalisAll();
			if(teach!=null)
			{
				//List<Teacher> teach=teacherSerImp.getDetalisAll();
				return new ResponseEntity<List<Teacher>>(teach,HttpStatus.FOUND);
			}
		}
		catch(Exception e)
		{
			throw new TeacherNotFoundException("Teader details not found");
		}
		return new ResponseEntity<List<Teacher>>(HttpStatus.NOT_FOUND);
	}
	
	
	
	@DeleteMapping("/teacher/delete/all")
	ResponseEntity<String> deletedetailsAll()
	{
		try
		{
			String  teach=teacherSerImp.deletedetailsAll();
			if(teach!=null)
			{
				teacherSerImp.deletedetailsAll();
				return new ResponseEntity<>(HttpStatus.ACCEPTED);
			}
		}
		catch(Exception e)
		{
			throw new TeacherNotFoundException("Teacher details not deleted");
		}
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}

}
