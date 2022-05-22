package br.com.smarthealth.dao;

import java.io.Serializable;

public interface GenericDAO<T, PK extends Serializable> {

	PK create(T entity);
	
	T read(PK id);
	
	T update(T entity);
	
	void delete(PK id);
}
