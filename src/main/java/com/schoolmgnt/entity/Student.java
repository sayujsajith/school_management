package com.schoolmgnt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Builder
@Entity
@Table(name="Student_Table")
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer studentId;
	
	@Column
	String studentName;
	
	@Column(name="date_of_birth")
	String studentDOB;
	@Column
	String phoneNumber;
	@Column
	String email;
	@Column
	String address;
	
	
	

}
