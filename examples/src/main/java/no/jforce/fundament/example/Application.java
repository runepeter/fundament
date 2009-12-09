package no.jforce.fundament.example;

import no.jforce.fundament.example.domain.ShoppingList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");

		ShoppingList shoppingList = new ShoppingList(1L, "Test Shopping list");
		shoppingList.persist();

	}

}
