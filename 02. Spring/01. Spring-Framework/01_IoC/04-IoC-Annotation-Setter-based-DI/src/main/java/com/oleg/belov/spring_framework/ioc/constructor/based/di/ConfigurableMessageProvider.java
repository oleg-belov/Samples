package com.oleg.belov.spring_framework.ioc.constructor.based.di;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;
    
    public ConfigurableMessageProvider() {
    }

    @Override
    public String getMessage() {
    	return this.message;
    }

    @Autowired
	public void setMessage(String message) {
		this.message = message;
	}
    
}
