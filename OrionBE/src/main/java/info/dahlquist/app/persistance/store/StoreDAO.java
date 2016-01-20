package info.dahlquist.app.persistance.store;

import java.util.Collection;

import javax.persistence.TypedQuery;

import info.dahlquist.app.domain.Store;
import info.dahlquist.app.persistance.base.DAOImpl;

public class StoreDAO extends DAOImpl<Store> implements IStoreDAO{

	public StoreDAO(){
		super(Store.class);
	}
	
	@Override
	public Collection<Store> getAllStores() {
		TypedQuery<Store> query = entityManager.createQuery("select st from store st", Store.class);
		return query.getResultList();
	}

}
