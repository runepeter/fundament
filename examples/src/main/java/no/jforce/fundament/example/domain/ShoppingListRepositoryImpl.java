package no.jforce.fundament.example.domain;

public class ShoppingListRepositoryImpl implements ShoppingListRepository {

	@Override
	public void delete(ShoppingList entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public ShoppingList get(Long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingList save(ShoppingList entity) {
		System.out.println("PERSIST");
		return null;
	}

}
