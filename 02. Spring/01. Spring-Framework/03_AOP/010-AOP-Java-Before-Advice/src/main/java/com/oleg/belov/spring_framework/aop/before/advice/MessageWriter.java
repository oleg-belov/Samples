package com.oleg.belov.spring_framework.aop.before.advice;

import static com.oleg.belov.spring_framework.aop.before.advice.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageWriter {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void writeMessage() {
        log.info("World");
    }
}
