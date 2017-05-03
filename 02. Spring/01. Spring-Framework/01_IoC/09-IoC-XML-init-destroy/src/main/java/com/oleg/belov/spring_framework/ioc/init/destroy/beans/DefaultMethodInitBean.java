package com.oleg.belov.spring_framework.ioc.init.destroy.beans;

import static com.oleg.belov.spring_framework.ioc.init.destroy.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultMethodInitBean {

	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void someDefaultInitMethod() {
        log.debug("");
        log.debug("someDefaultInitMethod invoked");
    }

    public void someDefaultDestroyMethod() {
        log.debug("");
        log.debug("someDefaultDestroyMethod invoked");
    }

}
