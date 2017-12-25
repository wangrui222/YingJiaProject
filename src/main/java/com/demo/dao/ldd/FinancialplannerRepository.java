package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.FinancialPlanner;

/**
 * 理财师记录
 * @author ldd
 *
 */
public interface FinancialplannerRepository extends JpaRepository<FinancialPlanner, Integer> {
	@Query("select f from FinancialPlanner f where f.memberId=?1")
	public FinancialPlanner selectFinancialPlannert(Integer id);
	
	@Modifying
	@Query("update FinancialPlanner f set f.status=?1 where f.memberId=?2")
	public void updateFinancialPlannert(Integer status,Integer id);
	
	
	
	
}
