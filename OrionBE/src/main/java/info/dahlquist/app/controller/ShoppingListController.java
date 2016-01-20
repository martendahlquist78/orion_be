package info.dahlquist.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.dahlquist.app.domain.ShoppingList;
import info.dahlquist.app.service.ServiceShoppingList;

@Controller
public class ShoppingListController {
	
	@Autowired
	ServiceShoppingList serviceShoppingList;
	
	@RequestMapping(value = {"/","/updatedPage"}, method = RequestMethod.GET)
	public String savePage(Model model) {
		model.addAttribute("shoppingList", new ShoppingList());
		model.addAttribute("allShoppingLists", (ArrayList<ShoppingList>)serviceShoppingList.getAll(new Long(0)));  //TODO UserId should exist in session??
		return "savepage";
	}
	
	@RequestMapping(value = {"/shoppinglist/create/{uid}"}, method = RequestMethod.POST)
	public String createShoppingList(@ModelAttribute("shoppinglist") ShoppingList shoppingList,
			@PathVariable("uid") Long uId
			/*final RedirectAttributes redirectAttributes*/) {
		
		if(serviceShoppingList.createDataObject(uId,shoppingList) !=null) {
			//redirectAttributes.addFlashAttribute("saveList", "success");
		} else {
			//redirectAttributes.addFlashAttribute("saveList", "unsuccess");
		}
		return "redirect:/updatedPage";
	}
	
	@RequestMapping(value = "/shoppinglist/{operation}/{slid}", method = RequestMethod.PUT)
	public String updateDeleteShoppingList(@PathVariable("operation") String operation,
			@PathVariable("slid") Long slId, /*final RedirectAttributes redirectAttributes,*/
			Model model) {
		if(operation.equals("delete")) {
			if(serviceShoppingList.deleteDataObject(slId)) {
				//redirectAttributes.addFlashAttribute("deletion", "success");
			} else {
				//redirectAttributes.addFlashAttribute("deletion", "unsuccess");
			}
		} else if(operation.equals("update")){
		  ShoppingList shoppingList = serviceShoppingList.findDataObject(slId);
		  if(shoppingList!=null) {
		       model.addAttribute("updateShoppingList", shoppingList);
		       return "editpage";
		  } else {
			  //redirectAttributes.addFlashAttribute("status","notfound");
		  }
		}
		return "redirect:/updatedPage";
	}
}
