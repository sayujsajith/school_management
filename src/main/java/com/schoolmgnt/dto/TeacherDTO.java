package com.schoolmgnt.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.schoolmgnt.entity.Student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherDTO 
{
	@NotBlank(message="empty is not allow")
	@NotNull(message="null not allowed")
	@Size(min=3,max=15,message="Name must 3 To 30 character")
	String teacherName;
	
	@NotNull(message="empty is not allow")
	@NotNull(message="null not allowed")
	String subject;
	
	@Pattern(regexp="\\d{10}",message="Give valid phone Number")
	String phoneNumber;
	
	@Email(message="Invalid Email Id")
	String techEmail;
	
	@Size(min=5,max=100,message="Full Address required")
	String address;
	
	
	//Student student;
	Student student;
}
