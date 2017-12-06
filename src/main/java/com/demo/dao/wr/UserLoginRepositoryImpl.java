package com.demo.dao.wr;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.Users;

public class UserLoginRepositoryImpl implements UserDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Object[] getUsers(String usersName) {
		String hql = "select user_name,users_password,mobile_phone,status from users u where u.user_Name = '"+usersName+"'";
		Query query = entityManager.createNativeQuery(hql);
		Object[] list = (Object[]) query.getSingleResult();
		return list;
	}

}
