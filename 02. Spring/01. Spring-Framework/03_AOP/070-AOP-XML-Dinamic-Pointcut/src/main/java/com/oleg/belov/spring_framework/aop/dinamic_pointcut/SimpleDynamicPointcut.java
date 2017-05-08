package com.oleg.belov.spring_framework.aop.dinamic_pointcut;

import static com.oleg.belov.spring_framework.aop.dinamic_pointcut.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    @Override
    public boolean matches(Method method, Class<?> cls) {
        log.info("Static check for " + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public boolean matches(Method method, Class<?> cls, Object[] args) {
        log.info("Dynamic check for " + method.getName());

        int x = ((Integer) args[0]).intValue();

        return (x != 100);
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            public boolean matches(Class<?> cls) {
                return (cls == SampleBean.class);
            }
        };
    }
}
