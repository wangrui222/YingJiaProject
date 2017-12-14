package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.SelectProject;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��8��
*��˵��
*/
public interface SelectProjectRepository extends JpaRepository<SelectProject, Integer>{

	public List<SelectProject> findSelectProjectByCode(String code);
}
