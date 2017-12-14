package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.SelectProjectRepository;
import com.demo.model.SelectProject;

/**
*@author 作者：
*@version 创建时间：2017年12月8日
*类说明
*/
@Service
public class SelectProjectServiceImpl implements SelectProjectService {
     @Autowired
     SelectProjectRepository selectProjectRepository;
	/* (non-Javadoc)
	 * @see com.demo.service.SelectProjectService#findSelectProjectService()
	 */
	@Override
	public List<SelectProject> findSelectProjectService(String code) {
		
		return selectProjectRepository.findSelectProjectByCode(code);
	}

}
