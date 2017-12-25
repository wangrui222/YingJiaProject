package com.demo.service.wr.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.demo.dao.ldd.FinancialplannerRepository;
import com.demo.model.FinancialPlanner;
import com.demo.service.wr.FinancialPlannerService;

@Service
public class FinancialPlannerServiceImpl implements FinancialPlannerService{

	@Autowired
	FinancialplannerRepository  financialplannerRepository;

	@Transactional
	@Override
	public void addFinancialPlanner(FinancialPlanner financialPlanner) {
		financialplannerRepository.save(financialPlanner);
	}

}
