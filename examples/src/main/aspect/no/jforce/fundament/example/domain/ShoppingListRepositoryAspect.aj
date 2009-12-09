package no.jforce.fundament.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import no.jforce.fundament.annotations.NotNull;
import no.jforce.fundament.domain.Entity;
import no.jforce.fundament.domain.Repository;

@Configurable
public aspect ShoppingListRepositoryAspect {

	@Autowired
	private static transient ShoppingListRepository repository;
	
	public void no.jforce.fundament.example.domain.ShoppingList.persist() {
		System.err.println("[BEFORE]");
		repository.save(this);
		System.err.println("[AFTER]");
	}

}
