package dao;

import java.util.List;
public interface Dao<T> {
	List<T> getAll();
	List<T> getPaginate(int first );
	List<T> getLikeName(String key);
	int count();
	T getById(int id);
	boolean add(T t);
	boolean edit(T t);
	boolean remote(int id);
}
