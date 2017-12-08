package com.demo.service.wr;

import java.util.Set;

import com.demo.model.Users;

public interface UserService {
	
	public Set<String> findRoles(String username);

}
