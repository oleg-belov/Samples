package com.oleg.belov.javase.method.invocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodInvocationExample {
	public static void setObjectName(Object obj, String name) {
		Class objClass = obj.getClass();

		try {
			// only for public methods
			Method method = objClass.getMethod("setName", new Class[]{String.class});

			method.invoke(obj, new Object[] {name});
		} catch (NoSuchMethodException ex) {
			throw new IllegalArgumentException(objClass.getName() + " does not support method setName(String)");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException("Insufficient access permissions to call setName(String) in class "
					+ objClass.getName());
		} catch (InvocationTargetException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void setObjectPrivateName(Object obj, String name) {
		Class objClass = obj.getClass();

		try {
			Method method = objClass.getDeclaredMethod("setName", new Class[]{String.class});

			method.invoke(obj, new Object[] {name});
		} catch (NoSuchMethodException ex) {
			throw new IllegalArgumentException(objClass.getName() + " does not support method setName(String)");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException("Insufficient access permissions to call setName(String) in class "
					+ objClass.getName());
		} catch (InvocationTargetException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void setObjectSetAccessiblePrivateName(Object obj, String name) {
		Class objClass = obj.getClass();

		try {
			Method method = objClass.getDeclaredMethod("setName", new Class[]{String.class});

			method.setAccessible(true);

			// obj may be null for static methods
			method.invoke(obj, new Object[] {name});
		} catch (NoSuchMethodException ex) {
			throw new IllegalArgumentException(objClass.getName() + " does not support method setName(String)");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException("Insufficient access permissions to call setName(String) in class "
					+ objClass.getName());
		} catch (InvocationTargetException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void getDeclareMethod_GrabOnlyDeclaredInTtarget(Object obj) {
		Class objClass = obj.getClass();

		try {
			Method method = objClass.getDeclaredMethod("toString", new Class[]{});

			method.invoke(obj, new Object[] {});
		} catch (NoSuchMethodException ex) {
			throw new IllegalArgumentException(objClass.getName() + " does not support method setName(String)");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException("Insufficient access permissions to call setName(String) in class "
					+ objClass.getName());
		} catch (InvocationTargetException ex) {
			throw new RuntimeException(ex);
		}
	}

	public static void setObjectIfNotExistSearchInParentSetAccessiblePrivateName(Object obj, String name) {
		Class objClass = obj.getClass();

		try {
			Method method = getSupportedMethod(objClass, "setName", new Class[]{String.class});

			method.setAccessible(true);

			method.invoke(obj, new Object[] {name});
		} catch (NoSuchMethodException ex) {
			throw new IllegalArgumentException(objClass.getName() + " does not support method setName(String)");
		} catch (IllegalAccessException ex) {
			throw new IllegalArgumentException("Insufficient access permissions to call setName(String) in class "
					+ objClass.getName());
		} catch (InvocationTargetException ex) {
			throw new RuntimeException(ex);
		}
	}

	private static Method getSupportedMethod( Class cls, String name, Class[] paramTypes)
			throws NoSuchMethodException
	{
		if (cls == null) {
			throw new NoSuchMethodException();
		}

		try {
			return cls.getDeclaredMethod( name, paramTypes );
		} catch (NoSuchMethodException ex) {
			return getSupportedMethod( cls.getSuperclass(), name, paramTypes );
		}
	}
}
