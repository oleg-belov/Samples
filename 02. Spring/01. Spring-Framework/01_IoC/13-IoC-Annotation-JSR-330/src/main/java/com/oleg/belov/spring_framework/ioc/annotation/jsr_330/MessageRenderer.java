package com.oleg.belov.spring_framework.ioc.annotation.jsr_330;

public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
