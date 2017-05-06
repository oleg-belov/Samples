package com.oleg.belov.spring_framework.ioc.java_config;

import static com.oleg.belov.spring_framework.ioc.java_config.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardOutMessageRenderer implements MessageRenderer {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private MessageProvider messageProvider;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                "You must set the property messageProvider of class:"
                    + StandardOutMessageRenderer.class.getName());
        }

        log.info(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider){
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
