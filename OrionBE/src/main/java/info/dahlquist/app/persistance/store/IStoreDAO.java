package info.dahlquist.app.persistance.store;

import java.util.Collection;

import info.dahlquist.app.domain.Store;
import info.dahlquist.app.persistance.base.IDataDAO;

public interface IStoreDAO extends IDataDAO<Store>{

	public Collection<Store> getAllStores();
	
	public Collection<Store> getAllStoresForUser(Long userId);
}
