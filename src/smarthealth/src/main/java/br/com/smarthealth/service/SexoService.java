package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.Sexo;

public class SexoService implements GenericService<Sexo, Integer> {
	
	private GenericDAOImpl<Sexo, Integer> dao;
	
	public SexoService() {
		this.dao = new GenericDAOImpl<>(Sexo.class);			
	}
	
	public static SexoService factory() {
		return new SexoService();
	}
	
	@Override
	public Integer create(Sexo entity) {
		return this.dao.create(entity);
	}

	@Override
	public Sexo read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public Sexo update(Sexo entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);		
	}
}