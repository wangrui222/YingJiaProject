package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Users;

public interface UserLoginRepository extends JpaRepository<Users, Integer>,UserDao {



}
