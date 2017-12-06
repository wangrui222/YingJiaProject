package com.demo.service.wr.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.wr.UserLoginRepository;
import com.demo.service.wr.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserLoginRepository usersRepepository;

	@Override
	public Set<String> findRoles(String username) {
		String sql = "select ename  from users u,user_role r,user_role_relation ur  where  ur.user_id=u.users_id   and ur.role_id = r.user_role_id  and u.user_name ='"+username+"'";
		return usersRepepository.findRoles(sql);
	}


}
