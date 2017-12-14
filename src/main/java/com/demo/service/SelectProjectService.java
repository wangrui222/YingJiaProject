package com.demo.service;

import java.util.List;
/**
*@author 作者：
*@version 创建时间：2017年12月8日
*类说明
*/

import com.demo.model.SelectProject;
public interface SelectProjectService {
	
	public List<SelectProject> findSelectProjectService(String code);

}
