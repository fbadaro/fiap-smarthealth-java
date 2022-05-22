package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.Membro;

public class MembroService implements GenericService<Membro, Integer> {
	
	private GenericDAOImpl<Membro, Integer> dao;
	
	public MembroService() {
		this.dao = new GenericDAOImpl<>(Membro.class);
	}
	
	public static MembroService factory() {
		return new MembroService();
	}
	
	@Override
	public Integer create(Membro entity) {
		return this.dao.create(entity);
	}

	@Override
	public Membro read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public Membro update(Membro entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}
}
