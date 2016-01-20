package info.dahlquist.app.persistance.base;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOImpl<T> implements IDataDAO<T>{

	   protected EntityManager entityManager;
	    private Class<T> classType;
	 
	    public DAOImpl() {
	    }
	 
	    public DAOImpl(Class<T> classType) {
	        this.classType = classType;
	    }
	 
	    public EntityManager getEntityManager() {
	        return entityManager;
	    }
	 
	    @PersistenceContext
	    public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	    }
	    public T insertRow(T obj) {
	        entityManager.persist(obj);
	        entityManager.flush();
	        return obj;
	    }
	 
	    public boolean delete(T obj) {
	        try {
	             entityManager.remove(obj);
	        } catch (Exception ex) {
	            return false;
	        }
	        return true;
	    }
	 
	    public T updateRow(T obj) {
	        try{
	           return entityManager.merge(obj);
	        } catch(Exception ex) {
	            return null;
	        }
	    }
	 
	    public T find(Long id) {
	        return (T) entityManager.find(classType, id);
	    }
	
}
