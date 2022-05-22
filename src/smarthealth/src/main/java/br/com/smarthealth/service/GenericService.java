package br.com.smarthealth.service;

import java.io.Serializable;

import br.com.smarthealth.entity.BaseEntity;

public interface GenericService<T extends BaseEntity<PK>, PK extends Serializable> {
	
	PK create(T entity);
	
	T read(PK id);
	
	T update(T entity);
	
	void delete(PK id);
}
