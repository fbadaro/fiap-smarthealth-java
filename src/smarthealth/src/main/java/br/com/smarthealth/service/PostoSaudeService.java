package br.com.smarthealth.service;

import br.com.smarthealth.dao.GenericDAOImpl;
import br.com.smarthealth.entity.PostoSaude;

public class PostoSaudeService implements GenericService<PostoSaude, Integer> {

	private GenericDAOImpl<PostoSaude, Integer> dao;
	
	public PostoSaudeService() {
		this.dao = new GenericDAOImpl<>(PostoSaude.class);
	}
	
	public static PostoSaudeService factory() {
		return new PostoSaudeService();
	}
	
	@Override
	public Integer create(PostoSaude entity) {
		return this.dao.create(entity);
	}

	@Override
	public PostoSaude read(Integer id) {
		return this.dao.read(id);
	}

	@Override
	public PostoSaude update(PostoSaude entity) {
		return this.dao.update(entity);
	}

	@Override
	public void delete(Integer id) {
		this.dao.delete(id);		
	}
}
