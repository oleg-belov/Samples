package com.oleg.belov.spring_framework.ioc.validationexample.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oleg.belov.spring_framework.ioc.validationexample.model.Region;

public class RegionValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return Region.class.equals(aClass);
    }

    public void validate(Object o, Errors errors) {

        Region r = (Region) o;
        if (r.getRegionName() == null || r.getRegionName().equals(""))
            errors.rejectValue("regionName", "invalid.name");

        if (r.getPopulation() <= 0)
            errors.rejectValue("population", "invalid.population");

    }
}
