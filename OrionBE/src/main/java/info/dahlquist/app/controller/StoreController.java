package info.dahlquist.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import info.dahlquist.app.domain.Store;
import info.dahlquist.app.service.ServiceStore;

@RestController
@RequestMapping("/store")
public class StoreController {
	
	
	@Autowired
	ServiceStore serviceStore;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody Collection<Store> getStores() {
		return serviceStore.getAll(new Long(0));
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces ="application/json")
	public @ResponseBody Store getStoreById(@PathVariable Long storeId){
		return serviceStore.findDataObject(storeId);
	}
	
	@RequestMapping(value = "/{uid}", method = RequestMethod.POST, produces ="application/json")
	public @ResponseBody Store createStore(@RequestBody Store store, @PathVariable Long userId){
		return serviceStore.createDataObject(userId, store);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT, produces ="application/json")
	public @ResponseBody Store updateStore(@RequestBody Store store){
		return serviceStore.updateDataObject(store);
	}	
}
