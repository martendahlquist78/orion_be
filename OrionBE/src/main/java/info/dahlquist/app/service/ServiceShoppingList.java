package info.dahlquist.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.dahlquist.app.domain.ShoppingList;
import info.dahlquist.app.persistance.shoppinglist.IShoppingListDAO;

@Service
@Transactional
public class ServiceShoppingList implements IServiceActions<ShoppingList>{

	@Autowired
	protected IShoppingListDAO shoppingListDAOInterface;
	
	@Override
	public ShoppingList createDataObject(Long uId, ShoppingList sl) {
		return shoppingListDAOInterface.insertRow(sl);
	}

	@Override
	public Boolean deleteDataObject(Long slId) {
		ShoppingList slTest = shoppingListDAOInterface.find(slId);
		if(slTest != null){
			return shoppingListDAOInterface.delete(slTest);
		}
		return false;
	}

	@Override
	public ShoppingList updateDataObject(ShoppingList sl) {
		return shoppingListDAOInterface.updateRow(sl);
	}

	@Override
	public ShoppingList findDataObject(Long slId) {
		return shoppingListDAOInterface.find(slId);
	}

	@Override
	public Collection<ShoppingList> getAll(Long userId) {
		return shoppingListDAOInterface.getAllListForUser(userId);
	}

}
