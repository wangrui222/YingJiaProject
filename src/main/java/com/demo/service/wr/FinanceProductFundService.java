package com.demo.service.wr;

import org.springframework.data.domain.Page;

import com.demo.model.FinanceProductFunds;

public interface FinanceProductFundService {
	
	public Page<FinanceProductFunds> selectGuShouAndGuQuan(String name, Integer page, Integer rowsize);
	
}
