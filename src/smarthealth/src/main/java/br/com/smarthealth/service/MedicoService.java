package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.Medico;

public class MedicoService implements GenericService<Medico, Integer> {
	
	private GenericDAOImpl<Medico, Integer> dao;
	
	public MedicoService() {
		this.dao = new GenericDAOImpl<>(Medico.class);
	}
	
	public static MedicoService factory() {
		return new MedicoService();
	}
	
	@Override
	public Integer create(Medico entity) {
		return this.dao.create(entity);
	}

	@Override
	public Medico read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public Medico update(Medico entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}
}
