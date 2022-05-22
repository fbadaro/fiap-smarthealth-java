package br.com.smarthealth.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import br.com.smarthealth.entity.BaseEntity;

public class GenericDAOImpl<T extends BaseEntity<PK>, PK extends Serializable> implements GenericDAO<T, PK> {
		
	protected EntityManager entityManager;
	
	private Class<T> persistedClass;
	
	public GenericDAOImpl() {
		entityManager = Persistence.createEntityManagerFactory("SmartHealth").createEntityManager();	
	}
	
	public GenericDAOImpl(Class<T> persistedClass) {
		this();
        this.persistedClass = persistedClass;
    }
		
	@Override
	public PK create(T entity) {
		
		PK entityId = null;
		
		try {
			EntityTransaction t = getTransaction();
			
			t.begin();
			
			entityManager.persist(entity);
			entityManager.flush();
			
			t.commit();
			
			entityId = entity.getId();
		}
		catch (Exception ex) {
			rollback(ex);
		}
		finally {
			disposeEntityManager();
		}
		
		return entityId;		
	}

	@Override
	public T read(PK id) {
		
		T entity = null;
		
		try {
			entity =  entityManager.find(persistedClass, id);
		}
		catch (Exception ex) {
			rollback(ex);
		}
		finally {
			disposeEntityManager();
		}	
		
		return entity;
	}

	@Override
	public T update(T entity) {
		
		try {
			EntityTransaction t = getTransaction();
			
			t.begin();
			
			entityManager.merge(entity);
			entityManager.flush();
			
			t.commit();
		}
		catch (Exception ex) {
			rollback(ex);
		}
		finally {
			disposeEntityManager();
		}
		
		return entity;		
	}

	@Override
	public void delete(PK id) {
		
		try {
			T entity = read(id);
			
			EntityTransaction t = getTransaction();
			
			t.begin();
			
			T mergedEntity = entityManager.merge(entity);
			entityManager.remove(mergedEntity);
			entityManager.flush();
			
			t.commit();
		}
		catch (Exception ex) {
			rollback(ex);
		}
		finally {
			disposeEntityManager();
		}
	}
	
	private EntityTransaction getTransaction() {
		
		EntityTransaction transaction = null;
				
		try {
			transaction = entityManager.getTransaction();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return transaction;
	}
	
	private void rollback(Exception ex) {
		
		ex.printStackTrace();
		
		if (entityManager != null && entityManager.getTransaction().isActive()) {
			entityManager.getTransaction().rollback();
		}
	}
	
	private void disposeEntityManager() {
//      NAO FECHAR A CONEXAO SE HOUVER MULTIPLAS REQUISICOES DA MESMA ENTIDADE, VERIFICAR COMO FAZER ISSO COM O HIBERNATE
//		if (entityManager != null) {
//			entityManager.close();
//		}
	}
}
