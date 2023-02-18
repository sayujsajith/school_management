package com.schoolmgnt.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO 
{	
//	@NotBlank(message="empty is not allow")
//	@NotNull(message="null not allowed")
//	Integer studentId;
	
	@NotBlank(message="empty is not allow")
	@NotNull(message="null not allowed")
	@Size(min=3,max=15,message="Name must 3 - 15 character") 
	String studentName;

	@Pattern(regexp="\\d{10}")
	String phoneNumber;
	
	@NotBlank(message="empty is not allow")
	@NotNull(message="null is not allowed")
	String studentDOB;
	
	@Email(message="Invalid Email Id")
	String email;
	
	@Size(min=10,max=100,message="Full Address required")
	String address;

}
