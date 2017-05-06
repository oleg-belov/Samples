package com.oleg.belov.spring_framework.ioc.init.destroy.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.oleg.belov.spring_framework.ioc.init.destroy.utils.ClassNameUtil.getCurrentClassName;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class AnnotationsInitBean {

	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @PostConstruct
    public void annotatedInitMethod() {
        log.debug("");
        log.debug("annotatedInitMethod invoked");
    }

    @PreDestroy
    public void annotatedDestroyMethod() {
        log.debug("");
        log.debug("annotatedDestroyMethod invoked");
    }

}
