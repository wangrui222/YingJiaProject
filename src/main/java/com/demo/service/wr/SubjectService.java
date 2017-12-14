package com.demo.service.wr;

import org.springframework.data.domain.Page;

import com.demo.model.Subject;

public interface SubjectService {
	
	public Page<Subject> selectSubject( Subject subject, Integer page, Integer rowsize);

}
