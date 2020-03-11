package com.ak.elgato.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ak.elgato.api.dao.IGatoDao;
import com.ak.elgato.entities.Gato;

@Repository
public class GatoDao implements IGatoDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Gato create(Gato gato) {
		session().save(gato);
		return gato;
	}

	@Override
	public Gato get(Integer id) {
		return session().get(Gato.class, id);
	}

	@Override
	public void update(Gato gato) {
		session().update(gato);
	}

	@Override
	public void delete(Gato gato) {
		session().delete(gato);
	}

	@Override
	public List<Gato> getAll() {
		CriteriaBuilder criteriaBuilder = session().getCriteriaBuilder();
		CriteriaQuery<Gato> query = criteriaBuilder.createQuery(Gato.class);
		Root<Gato> root = query.from(Gato.class);
		query.select(root);
		TypedQuery<Gato> result = session().createQuery(query);
		return result.getResultList();
	}
}
