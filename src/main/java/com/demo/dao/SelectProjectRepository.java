package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.SelectProject;

/**
*@author 作者：
*@version 创建时间：2017年12月8日
*类说明
*/
public interface SelectProjectRepository extends JpaRepository<SelectProject, Integer>{

	public List<SelectProject> findSelectProjectByCode(String code);
}
