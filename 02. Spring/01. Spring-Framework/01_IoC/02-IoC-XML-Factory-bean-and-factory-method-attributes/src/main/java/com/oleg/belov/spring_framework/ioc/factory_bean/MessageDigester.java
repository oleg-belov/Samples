package com.oleg.belov.spring_framework.ioc.factory_bean;

import static com.oleg.belov.spring_framework.ioc.factory_bean.utils.ClassNameUtil.getCurrentClassName;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDigester {
	private static Logger log = LoggerFactory.getLogger(getCurrentClassName());
	
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1) {
        this.digest1 = digest1;
    }

    public void setDigest2(MessageDigest digest2) {
        this.digest2 = digest2;
    }

    public void digest(String msg) {
    	log.debug("");
    	
    	log.debug("Using digest1");
        digest(msg, digest1);

        log.debug("Using digest2");
        digest(msg, digest2);
    }

    private void digest(String msg, MessageDigest digest) {
    	log.debug("Using alogrithm: " + digest.getAlgorithm());
        digest.reset();
        byte[] bytes = msg.getBytes();
        byte[] out = digest.digest(bytes);
        log.debug(out.toString());
    }
}
