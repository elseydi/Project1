package formation.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	public void insert(T obj);
	public T update(T obj);
	public void delete(T obj);
	public T findByKey(K key);
	public List<T> findAll();
}
