package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Subject;

public interface SubjectsRepository extends JpaRepository<Subject, Integer>,SubjectsDao{

}
