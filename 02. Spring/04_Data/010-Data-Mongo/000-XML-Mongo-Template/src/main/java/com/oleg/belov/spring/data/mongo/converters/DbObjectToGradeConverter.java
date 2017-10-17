package com.oleg.belov.spring.data.mongo.converters;

import static com.oleg.belov.spring.data.mongo.utils.ClassNameUtil.getCurrentClassName;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import com.mongodb.DBObject;
import com.oleg.belov.spring.data.mongo.documents.Grade;

public class DbObjectToGradeConverter implements Converter<DBObject, Grade> {

	@Override
	public Grade convert(DBObject source) {
		Logger log = LoggerFactory.getLogger(getCurrentClassName());
		
		Grade grade = new Grade();
		try {
			grade.setDate(new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(source.get("date").toString()));
		} catch (ParseException e) {
			log.error(e.toString());
		}
		grade.setGrade(source.get("grade").toString());
		grade.setScore(Integer.parseInt(source.get("date").toString()));
		
		return grade;
	}
}
