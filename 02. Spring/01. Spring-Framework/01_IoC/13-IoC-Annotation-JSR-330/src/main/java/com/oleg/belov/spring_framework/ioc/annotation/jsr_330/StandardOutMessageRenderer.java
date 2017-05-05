package com.oleg.belov.spring_framework.ioc.annotation.jsr_330;

import static com.oleg.belov.spring_framework.ioc.annotation.jsr_330.utils.ClassNameUtil.getCurrentClassName;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("messageRenderer")
@Singleton
public class StandardOutMessageRenderer implements MessageRenderer {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    @Inject
    @Named("messageProvider")
    private MessageProvider messageProvider = null;

    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException(
                "You must set the property messageProvider of class:"
                + StandardOutMessageRenderer.class.getName());
        }

        log.info(messageProvider.getMessage());
    }

    public void setMessageProvider(MessageProvider provider) {
        this.messageProvider = provider;
    }

    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
