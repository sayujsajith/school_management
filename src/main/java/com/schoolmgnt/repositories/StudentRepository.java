package com.schoolmgnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgnt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
