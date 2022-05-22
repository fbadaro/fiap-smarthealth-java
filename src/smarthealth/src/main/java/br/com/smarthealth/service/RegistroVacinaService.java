package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.RegistroVacina;

public class RegistroVacinaService implements GenericService<RegistroVacina, Integer> {
	
	private GenericDAOImpl<RegistroVacina, Integer> dao;
	
	public RegistroVacinaService() {
		this.dao = new GenericDAOImpl<>(RegistroVacina.class);
	}
	
	public static RegistroVacinaService factory() {
		return new RegistroVacinaService();
	}
	
	@Override
	public Integer create(RegistroVacina entity) {
		return this.dao.create(entity);
	}

	@Override
	public RegistroVacina read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public RegistroVacina update(RegistroVacina entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);		
	}
}
