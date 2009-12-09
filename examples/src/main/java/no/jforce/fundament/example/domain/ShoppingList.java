package no.jforce.fundament.example.domain;

import no.jforce.fundament.annotations.NotNull;
import no.jforce.fundament.domain.AbstractEntity;

public class ShoppingList extends AbstractEntity<ShoppingList, Long> {

	private final String title;

	public ShoppingList(@NotNull final Long id, @NotNull final String title) {
		super(id);
		this.title = title;
	}

	protected ShoppingList() {
		this.title = null;
	}

}
