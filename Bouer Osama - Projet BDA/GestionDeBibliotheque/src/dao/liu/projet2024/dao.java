package dao.liu.projet2024;

import java.util.List;

import metier.liu.projet2024.Associé;

public interface dao<T> {
	//CRUD

	public T get(long id); // select by id

	public List<T> getAll(); // select all

	public void save(T t); // insert

	public void update(T t, String[] params); //update

	public void delete(T t); // delete

}
