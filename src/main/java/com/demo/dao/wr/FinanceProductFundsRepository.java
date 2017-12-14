package com.demo.dao.wr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.FinanceProductFunds;
import com.demo.model.Subject;

public interface FinanceProductFundsRepository extends JpaRepository<FinanceProductFunds, Integer>,JpaSpecificationExecutor<FinanceProductFunds> {
	
	
	//@Query("FROM FinanceProductFunds f where f.financeProductFundsType = ? ")
	//List<FinanceProductFunds> getSiMuList(String name);
	
	 
	@Query("FROM FinanceProductFunds f WHERE f.financeProductFundsId = ?")	  
    FinanceProductFunds getSiMuGouMai(Integer financeProductFundsId);
	
	
	
	
	

}
