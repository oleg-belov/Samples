package com.oleg.belov.spring_framework.ioc.constructor.based.di;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;
    
    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
    	return this.message;
    }
}
