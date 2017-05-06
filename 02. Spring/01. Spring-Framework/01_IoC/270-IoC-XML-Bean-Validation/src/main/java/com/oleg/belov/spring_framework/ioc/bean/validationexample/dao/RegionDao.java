package com.oleg.belov.spring_framework.ioc.bean.validationexample.dao;

import static com.oleg.belov.spring_framework.ioc.bean.validationexample.utils.ClassNameUtil.getCurrentClassName;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.oleg.belov.spring_framework.ioc.bean.validationexample.model.Region;
import com.oleg.belov.spring_framework.ioc.bean.validationexample.validation.RegionValidator;

public class RegionDao {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @Autowired
    private RegionValidator validator;

    @Autowired
    private MessageSource messageSource;

    public void createRegion(Region region) {

        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();

        Set<ConstraintViolation<Region>> constraintViolations = validator.validate(region);
        log.info(String.format("Кол-во ошибок: %d",
                constraintViolations.size()));

        for (ConstraintViolation<Region> cv : constraintViolations)
            log.info(String.format(
                    "Внимание, ошибка! property: [%s], value: [%s], message: [%s]",
                    cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));

        log.info("Region Saved...");

    }

}
