package com.oleg.belov.spring_framework.aop.around.advice;

import static com.oleg.belov.spring_framework.aop.throws_advice.utils.ClassNameUtil.getCurrentClassName;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

public class ProfilingInterceptor implements MethodInterceptor {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

       log.info("Executed method: " + m.getName());
       log.info("On object of type: " + 
                target.getClass().getName());

       log.info("With arguments:");
        for (int x = 0; x < args.length; x++) {
            System.out.print("       > " + args[x]);
        }
        System.out.print("\n");

       log.info("Took: " + ms + " ms");
    }
}
