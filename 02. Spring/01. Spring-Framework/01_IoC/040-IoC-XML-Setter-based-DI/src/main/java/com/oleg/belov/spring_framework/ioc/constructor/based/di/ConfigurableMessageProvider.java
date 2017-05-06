package com.oleg.belov.spring_framework.ioc.constructor.based.di;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider() {
    }
    
    @Override
    public String getMessage() {
        return message;
    }

	public void setMessage(String message) {
		this.message = message;
	}
}
