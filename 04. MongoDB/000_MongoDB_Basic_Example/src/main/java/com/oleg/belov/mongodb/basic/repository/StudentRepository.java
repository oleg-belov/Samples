package com.oleg.belov.mongodb.basic.repository;

import java.util.List;

import com.oleg.belov.mongodb.basic.documents.Student;

public interface StudentRepository {
	public List<Student> findAll();
	public void updateStudentById(Long studentId);
}
