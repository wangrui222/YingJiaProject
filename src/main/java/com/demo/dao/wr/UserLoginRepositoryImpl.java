package com.demo.dao.wr;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.Users;

public class UserLoginRepositoryImpl implements UserDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public Object[] getUsers(String usersName) {
		String sql = "select user_name,users_password,mobile_phone,status from users u where u.user_Name = '"+usersName+"'";
		try {
			Query query = entityManager.createNativeQuery(sql);
			Object[] list = (Object[]) query.getSingleResult();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Set<String> findRoles(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		return new HashSet<>(query.getResultList());
	}

	@Override
	public Object[] getUsersWithMobilePhone(String mobilePhone) {
		String sql = "select user_name,users_password,mobile_phone,status from users u where u.MOBILE_PHONE = '"+mobilePhone+"'";
		try {
			Query query = entityManager.createNativeQuery(sql);
			Object[] list = (Object[]) query.getSingleResult();
			return list;
		} catch (Exception e) {
			return null;
		}
	}

	
}
