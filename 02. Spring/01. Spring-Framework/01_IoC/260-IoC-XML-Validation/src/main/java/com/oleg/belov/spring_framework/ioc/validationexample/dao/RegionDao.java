package com.oleg.belov.spring_framework.ioc.validationexample.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;

import com.oleg.belov.spring_framework.ioc.validationexample.model.Region;
import com.oleg.belov.spring_framework.ioc.validationexample.validation.RegionValidator;

import static com.oleg.belov.spring_framework.ioc.validationexample.utils.ClassNameUtil.getCurrentClassName;

import java.util.Locale;

public class RegionDao {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @Autowired
    private RegionValidator validator;

    @Autowired
    private MessageSource messageSource;

    public void saveRegion(Region region) {
        final BindException errors = new BindException(region, region.getClass().getName());
        validator.validate(region, errors);
        if (errors.hasErrors()) {
            for (ObjectError e : errors.getAllErrors()) {
               log.info(e.getCode() + " " + e.getDefaultMessage());
               log.info(messageSource.getMessage(e, Locale.getDefault()));
            }
            return;
        }
       log.info("Region Saved...");

    }

}
