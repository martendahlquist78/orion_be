package info.dahlquist.app.service;

import java.util.Collection;

public interface IServiceActions<T> {
	
	public T createDataObject(Long userId, T data);
	public Boolean deleteDataObject(Long dataId);
	public T updateDataObject(T data);
	public T findDataObject(Long dataId);
	public Collection<T> getAll(Long userId);
}
