package com.oleg.belov.spring_framework.ioc.init.destroy.beans;

import static com.oleg.belov.spring_framework.ioc.init.destroy.utils.ClassNameUtil.getCurrentClassName;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class SpringInterfaceInitBean implements InitializingBean, DisposableBean {

	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());

    @Override
    public void afterPropertiesSet() throws Exception {
        log.debug("");
        log.debug("afterPropertiesSet invoked");
    }

    @Override
    public void destroy() throws Exception {
        log.debug("");
        log.debug("destroy invoked");
    }

}
