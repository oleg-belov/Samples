package com.oleg.belov.mongodb.basic.repository.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.oleg.belov.mongodb.basic.documents.Student;
import com.oleg.belov.mongodb.basic.repository.MongoDBCollection;
import com.oleg.belov.mongodb.basic.repository.StudentRepository;

@Repository
public class StudentRepositoryImpl implements StudentRepository{
	private MongoCollection<Document> studentCollection;
	
	@Autowired
	public void setCollection(MongoDBCollection studentCollection) throws IOException {
		this.studentCollection = studentCollection.getCollection();
	}

	@Override
	public List<Student> findAll() {
		Gson gson = new Gson();
		List<Student> students = new ArrayList<>();
		Iterator<Document> cursor = studentCollection.find().iterator();
		
		while(cursor.hasNext()) {
			Student student = gson.fromJson(cursor.next().toJson(), Student.class);
			students.add(student);
		}
		
		return students;
	}

	@Override
	public void updateStudentById(Long studentId) {
		// TODO Auto-generated method stub
		
	}
}
