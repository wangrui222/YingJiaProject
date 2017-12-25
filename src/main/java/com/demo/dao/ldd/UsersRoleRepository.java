package com.demo.dao.ldd;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.model.UserRole;
import com.demo.model.Users;
/**
 * µÇÂ½ÕËºÅ
 * @author ldd
 *
 */
public interface UsersRoleRepository extends JpaRepository<UserRole, Integer>,JpaSpecificationExecutor<UserRole> {
	
}
