package no.jforce.fundament.aop;

import no.jforce.fundament.annotations.NotNull;

import org.testng.annotations.Test;

public class NotNullAspectTestCase {

	/**
	 * Constructor-based tests:
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void constructorSingleNullArgument() {
		new Jalla(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void constructorTwoArgumentsWithFirstBeingNull() {
		new Jalla(null, "testing");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void constructorTwoArgumentsWithSecondBeingNull() {
		new Jalla("testing", null);
	}

	@Test
	public void constructorThreeMixedArgumentsWithLegalNullValue()
			throws Exception {
		new Jalla("testing", null, 1L);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void constructorThreeMixedArgumentsWithIllegalNullValue()
			throws Exception {
		new Jalla("testing", "testing", null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void constructorFourMixedArgumentsWithIllegalNullValue()
			throws Exception {
		new Jalla("testing", "testing", null, 666);
	}

	@Test
	public void constructorFourMixedArgumentsWithNotNullValueSet()
			throws Exception {
		new Jalla(null, null, 1L, null);
	}

	/**
	 * Method-call tests:
	 */
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void methodSingleNullArgument() throws Exception {
		new Jalla().method(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void methodTwoArgumentsWithFirstBeingNull() {
		new Jalla().method(null, "testing");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void methodTwoArgumentsWithSecondBeingNull() {
		new Jalla().method("testing", null);
	}

	@Test
	public void methodThreeMixedArgumentsWithLegalNullValue() throws Exception {
		new Jalla().method("testing", null, 1L);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void methodThreeMixedArgumentsWithIllegalNullValue()
			throws Exception {
		new Jalla().method("testing", "testing", null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void methodFourMixedArgumentsWithIllegalNullValue() throws Exception {
		new Jalla().method("testing", "testing", null, 666);
	}

	@Test
	public void methodFourMixedArgumentsWithNotNullValueSet() throws Exception {
		new Jalla().method(null, null, 1L, null);
	}

	/**
	 * Method return tests:
	 */
	@Test(expectedExceptions = RuntimeException.class)
	public void methodReturningNullValue() {
		new Jalla().returning(null);	
	}

	public static class Jalla {

		public Jalla() {

		}

		public Jalla(@NotNull String first) {

		}

		public Jalla(@NotNull String first, @NotNull String second) {

		}

		public Jalla(@NotNull String first, String second, @NotNull Long third) {

		}

		public Jalla(String first, String second, @NotNull Long third,
				Integer fouth) {

		}

		public void method() {

		}

		public void method(@NotNull String value) {

		}

		public void method(@NotNull String value, @NotNull String second) {

		}

		public void method(@NotNull String first, String second,
				@NotNull Long third) {

		}

		public void method(String first, String second, @NotNull Long third,
				Integer fouth) {

		}

		@NotNull
		public String returning(String value) {
			return value;
		}

	}

}
