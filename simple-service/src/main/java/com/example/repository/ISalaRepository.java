package com.example.repository;

import java.util.List;

public interface ISalaRepository<T> {
	List<T>readAll();
	T getById(long id);
	long create(int valor);
	void update(long id, T entity);
	void remove(T entity);
}