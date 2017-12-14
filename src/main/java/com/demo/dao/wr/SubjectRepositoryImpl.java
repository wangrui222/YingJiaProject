package com.demo.dao.wr;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SubjectRepositoryImpl implements SubjectDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
}
