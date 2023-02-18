package com.schoolmgnt.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

@Builder

@Table(name="Teacher_Table")
public class Teacher 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer teacherId;
	
	@Column(name="teacher_name")
	String teacherName;
	
	@Column(name="subject_name")
	String subject;
	
	@Column(name="contact_number")
	String phoneNumber;
	String techEmail;
	String address;

	@ManyToOne(cascade = CascadeType.ALL)
	//name we can give anything which is a primary key of other table 
	//@JoinColumn(name="student_Id")
	 Student student;
	
	
	
}






