package com.example.repository;

import java.util.List;

public interface IRepository<T> {
	List<T>readAll();
	T getById(long id);
	void create(T entity);
	void update(long id, T entity);
	void delete(long id);
	void remove(T entity);
}
