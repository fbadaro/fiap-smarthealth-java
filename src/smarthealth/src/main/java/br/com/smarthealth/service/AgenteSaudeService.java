package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.AgenteSaude;

public class AgenteSaudeService implements GenericService<AgenteSaude, Integer> {
	
	private GenericDAOImpl<AgenteSaude, Integer> dao;
	
	public AgenteSaudeService() {
		this.dao = new GenericDAOImpl<>(AgenteSaude.class);
	}
	
	public static AgenteSaudeService factory() {
		return new AgenteSaudeService();
	}

	@Override
	public Integer create(AgenteSaude entity) {
		return this.dao.create(entity);
	}

	@Override
	public AgenteSaude read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public AgenteSaude update(AgenteSaude entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);
	}
}
