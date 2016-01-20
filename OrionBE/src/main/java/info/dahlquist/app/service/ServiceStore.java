package info.dahlquist.app.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import info.dahlquist.app.domain.Store;
import info.dahlquist.app.persistance.store.IStoreDAO;

@Service
@Transactional
public class ServiceStore implements IServiceActions<Store>{

	@Autowired
	protected IStoreDAO storeDAOInterface;
	
	@Override
	public Store createDataObject(Long uId, Store sl) {
		return storeDAOInterface.insertRow(sl);
	}

	@Override
	public Boolean deleteDataObject(Long slId) {
		return false;
	}

	@Override
	public Store updateDataObject(Store sl) {
		return storeDAOInterface.updateRow(sl);
	}

	@Override
	public Store findDataObject(Long slId) {
		return storeDAOInterface.find(slId);
	}

	@Override
	public Collection<Store> getAll(Long userId) {
		if(userId > 0)
			return storeDAOInterface.getAllStoresForUser(userId);
		return storeDAOInterface.getAllStores();
	}

}
