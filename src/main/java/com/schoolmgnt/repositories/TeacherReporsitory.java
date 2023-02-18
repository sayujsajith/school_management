package com.schoolmgnt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.schoolmgnt.entity.Teacher;

public interface TeacherReporsitory extends JpaRepository<Teacher, Integer> {

}
