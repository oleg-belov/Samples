package com.oleg.belov.spring.data.mongo.converters;

import org.springframework.core.convert.converter.Converter;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.oleg.belov.spring.data.mongo.documents.Grade;

public class GradeToDbObjectConverter implements Converter<Grade, DBObject> {

	@Override
	public DBObject convert(Grade source) {
		DBObject obj = new BasicDBObject();
		obj.put("date", source.getDate());
		obj.put("grade", source.getGrade());
		obj.put("score", source.getScore());
		return obj;
	}
}
