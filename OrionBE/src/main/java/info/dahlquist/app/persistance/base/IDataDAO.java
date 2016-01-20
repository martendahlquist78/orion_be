package info.dahlquist.app.persistance.base;


public interface IDataDAO<T> {
	 public T insertRow(T dataObject);

	 public T find(Long id);

	 public T updateRow(T dataObject);

	 public boolean delete(T dataObject);
	 
}