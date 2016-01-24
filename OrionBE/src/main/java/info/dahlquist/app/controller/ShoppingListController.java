package info.dahlquist.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.dahlquist.app.domain.ShoppingList;
import info.dahlquist.app.service.ServiceShoppingList;


@RestController
@RequestMapping("/shoppinglist")
public class ShoppingListController {
	
	
	//TODO Error handling if list does not exists and so on
	
	@Autowired
	@Qualifier(value="serviceShoppingList")
	ServiceShoppingList serviceShoppingList;
	
	
	@RequestMapping(value = "/{uid}", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Collection<ShoppingList> getShoppingListsForUser(@PathVariable Long userId) {
		return serviceShoppingList.getAll(userId);
	}
	
	@ExceptionHandler(Exception.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces ="application/json")
	public @ResponseBody ShoppingList getShoppingListByIdForUser(@PathVariable Long listId){
		return serviceShoppingList.findDataObject(listId);
	}
	
	@RequestMapping(value = "/{uid}", method = RequestMethod.POST, produces ="application/json")
	public @ResponseBody ShoppingList createShoppingList(@RequestBody ShoppingList shoppingList, @PathVariable Long userId){
		return serviceShoppingList.createDataObject(userId, shoppingList);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces ="application/json")
	public @ResponseBody ShoppingList updateShoppingList(@RequestBody ShoppingList shoppingList){
		return serviceShoppingList.updateDataObject(shoppingList);
	}
	
	//TODO throw new InvalidDataException("could not create...");
}
