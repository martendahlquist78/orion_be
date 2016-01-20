package info.dahlquist.app.persistance.shoppinglist;

import java.util.Collection;

import javax.persistence.TypedQuery;

import info.dahlquist.app.domain.ShoppingList;
import info.dahlquist.app.persistance.base.DAOImpl;

public class ShoppingListDAO extends DAOImpl<ShoppingList> implements IShoppingListDAO{

	public ShoppingListDAO(){
		super(ShoppingList.class);
	}
	
	@Override
	public Collection<ShoppingList> getAllListForUser(long userId) {
		TypedQuery<ShoppingList> query = entityManager.createQuery("select sl from shoppinglist sl where sl.owner = ?1", ShoppingList.class);
		query.setParameter(1,userId);
		return query.getResultList();
	}

}
