package com.oleg.belov.spring_framework.ioc.lazy.init.utils;

public class ClassNameUtil {

	public ClassNameUtil() {
	}

	public static String getCurrentClassName() {
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			return e.getStackTrace()[1].getClassName();
		}
	}

}
