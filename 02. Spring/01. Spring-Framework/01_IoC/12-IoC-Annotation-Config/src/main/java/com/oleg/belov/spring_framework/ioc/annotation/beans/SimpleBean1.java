package com.oleg.belov.spring_framework.ioc.annotation.beans;

import static com.oleg.belov.spring_framework.ioc.annotation.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleBean1 {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    public void methodForFirst() {
        log.info("methodForFirst");
    }
}
