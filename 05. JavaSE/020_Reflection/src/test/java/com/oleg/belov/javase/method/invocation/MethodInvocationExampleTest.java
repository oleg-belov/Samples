package com.oleg.belov.javase.method.invocation;

import com.oleg.belov.javase.method.invocation.model.Dog;
import com.oleg.belov.javase.method.invocation.model.DogConservator;
import com.oleg.belov.javase.method.invocation.model.DogDefault;
import com.oleg.belov.javase.method.invocation.model.DogDiversant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MethodInvocationExampleTest {

	private final String DOG_NAME = "Laika";

	@Test
	void shouldSetDogName() {

		Dog dog = new Dog();

		MethodInvocationExample.setObjectName(dog, DOG_NAME);

		Assertions.assertEquals(DOG_NAME, dog.getName());
	}

	@Test
	void notFoundMethodOnClass() {
		DogConservator dog = new DogConservator(DOG_NAME);

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MethodInvocationExample.setObjectName(dog, DOG_NAME));

		assertAll(
				() -> assertEquals("com.oleg.belov.javase.method.invocation.model.DogConservator does not support method setName(String)", exception.getMessage()),
				() -> assertNull(exception.getCause())
		);
	}

	@Test
	void notFoundPublicMethod() {
		DogDefault dog = new DogDefault();

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MethodInvocationExample.setObjectName(dog, DOG_NAME));

		assertAll(
				() -> assertEquals("com.oleg.belov.javase.method.invocation.model.DogDefault does not support method setName(String)", exception.getMessage()),
				() -> assertNull(exception.getCause())
		);
	}

	@Test
	void cantSetNameByPrivateMethod() {
		DogDefault dog = new DogDefault();

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MethodInvocationExample.setObjectPrivateName(dog, DOG_NAME));

		assertAll(
				() -> assertEquals("Insufficient access permissions to call setName(String) in class com.oleg.belov.javase.method.invocation.model.DogDefault", exception.getMessage()),
				() -> assertNull(exception.getCause())
		);
	}

	@Test
	void setNameAllowAccessToPrivateMethod() {
		DogDefault dog = new DogDefault();

		MethodInvocationExample.setObjectSetAccessiblePrivateName(dog, DOG_NAME);

		Assertions.assertEquals(DOG_NAME, dog.getName());
	}

	@Test
	void setNameIfNotExistSearchInParentAllowAccessToPrivateMethod() {
		DogConservator dog = new DogConservator("Dog name");

		MethodInvocationExample.setObjectIfNotExistSearchInParentSetAccessiblePrivateName(dog, DOG_NAME);

		Assertions.assertEquals(DOG_NAME, dog.getName());
	}

	@Test
	void throwsErrorOnTryToSetName() {
		DogDiversant dog = new DogDiversant();

		final RuntimeException exception = assertThrows(RuntimeException.class, () -> MethodInvocationExample.setObjectName(dog, DOG_NAME));

		assertAll(
				() -> assertEquals("java.lang.reflect.InvocationTargetException", exception.getMessage()),
				() -> assertNotNull(exception.getCause()),
				() -> assertSame(UnsupportedOperationException.class, exception.getCause().getCause().getClass()),
				() -> assertEquals("Can not modify name!", exception.getCause().getCause().getMessage())
		);
	}

	@Test
	void getDeclareMethod_GRAB_ONLY_DECLATED_IN_TARGET() {
		DogDefault dog = new DogDefault();

		final IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MethodInvocationExample.getDeclareMethod_GrabOnlyDeclaredInTtarget(dog));

		assertAll(
				() -> assertEquals("com.oleg.belov.javase.method.invocation.model.DogDefault does not support method setName(String)", exception.getMessage()),
				() -> assertNull(exception.getCause())
		);
	}

	@Test
	void check_if_is_primitive() {
		assertAll(
				() -> assertTrue(void.class.isPrimitive()),
				() -> assertTrue(int.class.isPrimitive()),
				() -> assertTrue(double.class.isPrimitive()),
				() -> assertTrue(char.class.isPrimitive())
		);
	}

	@Test
	void check_if_is_not_primitive() {
		assertAll(
				() -> assertFalse(Void.class.isPrimitive()),
				() -> assertFalse(Integer.class.isPrimitive()),
				() -> assertFalse(Double.class.isPrimitive()),
				() -> assertFalse(Character.class.isPrimitive())
		);
	}

	@Test
	void check_if_is_interface() {
		assertAll(
				() -> assertTrue(Collection.class.isInterface()),
				() -> assertTrue(List.class.isInterface())
		);
	}

	@Test
	void check_if_is_not_interface() {
		assertAll(
				() -> assertFalse(ArrayList.class.isInterface()),
				() -> assertFalse(String.class.isInterface())
		);
	}

	@Test
	void check_if_is_array() {
		assertAll(
				() -> assertTrue(Object[].class.isArray()),
				() -> assertTrue(int[].class.isArray())
		);
	}

	@Test
	void must_return_full_class_name() {
		assertEquals("java.lang.String", String.class.getName());
	}

	@Test
	void must_return_class_name() {
		assertEquals("String", String.class.getSimpleName());
	}
}