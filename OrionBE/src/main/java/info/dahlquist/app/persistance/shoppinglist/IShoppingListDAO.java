package info.dahlquist.app.persistance.shoppinglist;

import java.util.Collection;

import info.dahlquist.app.domain.ShoppingList;
import info.dahlquist.app.persistance.base.IDataDAO;

public interface IShoppingListDAO extends IDataDAO<ShoppingList>{

	public Collection<ShoppingList> getAllListForUser(long userId);
}
