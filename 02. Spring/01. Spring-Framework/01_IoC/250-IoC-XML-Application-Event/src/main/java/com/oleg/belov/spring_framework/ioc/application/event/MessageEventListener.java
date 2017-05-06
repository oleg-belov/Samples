package com.oleg.belov.spring_framework.ioc.application.event;

import static com.oleg.belov.spring_framework.ioc.application.event.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

public class MessageEventListener implements ApplicationListener<MessageEvent> {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public void onApplicationEvent(MessageEvent event) {
        MessageEvent msgEvt = (MessageEvent) event;
        log.info("Received: " + msgEvt.getMessage());
    }
}
