package no.jforce.fundament.aop.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

import no.jforce.fundament.annotations.NotNull;

public class AnnotationKit {

	private AnnotationKit() {
	}

	public static boolean isNotNullPresent(Annotation[] annotations) {

		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(NotNull.class)) {
				return true;
			}
		}

		return false;
	}
	
}
