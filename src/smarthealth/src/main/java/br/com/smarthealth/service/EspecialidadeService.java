package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.Especialidade;

public class EspecialidadeService implements GenericService<Especialidade, Integer> {
	
	private GenericDAOImpl<Especialidade, Integer> dao;
	
	public EspecialidadeService() {
		this.dao = new GenericDAOImpl<>(Especialidade.class);
	}
	
	public static EspecialidadeService factory() {
		return new EspecialidadeService();
	}
	
	@Override
	public Integer create(Especialidade entity) {
		return this.dao.create(entity);
	}

	@Override
	public Especialidade read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public Especialidade update(Especialidade entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}
}
