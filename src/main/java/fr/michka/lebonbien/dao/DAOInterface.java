package fr.michka.lebonbien.dao;

public interface DAOInterface<T> {
    public int create(T data);
    public int update(T data);
    public int delete(T data);
    public T findById(int id);
    public T[] findAll();
}
