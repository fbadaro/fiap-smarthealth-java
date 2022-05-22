package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.Familia;

public class FamiliaService implements GenericService<Familia, Integer> {
	
	private GenericDAOImpl<Familia, Integer> dao;
	
	public FamiliaService() {
		this.dao = new GenericDAOImpl<>(Familia.class);
	}
	
	public static FamiliaService factory() {
		return new FamiliaService();
	}
	
	@Override
	public Integer create(Familia entity) {
		return this.dao.create(entity);
	}

	@Override
	public Familia read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public Familia update(Familia entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}
}
