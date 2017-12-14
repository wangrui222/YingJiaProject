package com.demo.dao.wr;

import java.util.Set;

import com.demo.model.Users;

public interface UserDao {
	
	/**
	 * 查询用户信息登陆
	 * @param sql
	 * @return
	 */
	
	public Object[] getUsers(String usersName);
	
	/**
	 * 查询角色
	 * @param sql
	 * @return
	 */
	public Set<String> findRoles(String sql);
	
	
	public Object[] getUsersWithMobilePhone(String mobilePhone);

}
