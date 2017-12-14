package com.demo.dao.wr;

import java.util.Set;

import com.demo.model.Users;

public interface UserDao {
	
	/**
	 * ��ѯ�û���Ϣ��½
	 * @param sql
	 * @return
	 */
	
	public Object[] getUsers(String usersName);
	
	/**
	 * ��ѯ��ɫ
	 * @param sql
	 * @return
	 */
	public Set<String> findRoles(String sql);
	
	
	public Object[] getUsersWithMobilePhone(String mobilePhone);

}
