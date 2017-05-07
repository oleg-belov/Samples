package com.oleg.belov.spring_framework.aop.around.advice;

import static com.oleg.belov.spring_framework.aop.around.advice.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkerBean {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void doSomeWork(int noOfTimes) {
        for(int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        log.info("");
    }
}
