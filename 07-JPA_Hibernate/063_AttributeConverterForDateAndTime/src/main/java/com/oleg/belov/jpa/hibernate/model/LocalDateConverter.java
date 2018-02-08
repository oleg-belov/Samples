package com.oleg.belov.jpa.hibernate.model;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		log.info("Convert to java.sql.Date");
		return Date.valueOf(attribute);
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
		log.info("Convert to java.time.LocalDate");
		return dbData.toLocalDate();
	}
}
