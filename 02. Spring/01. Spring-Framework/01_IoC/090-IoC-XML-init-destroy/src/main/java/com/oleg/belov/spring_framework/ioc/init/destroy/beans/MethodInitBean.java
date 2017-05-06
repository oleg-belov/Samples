package com.oleg.belov.spring_framework.ioc.init.destroy.beans;

import static com.oleg.belov.spring_framework.ioc.init.destroy.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodInitBean {

	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void someInitMethod() {
        log.debug("");
        log.debug("someInitMethod invoked");
    }

    public void someDestroyMethod() {
        log.debug("");
        log.debug("someDestroyMethod invoked");
    }

}
