package com.oleg.belov.spring.data.jpa.utils;

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
