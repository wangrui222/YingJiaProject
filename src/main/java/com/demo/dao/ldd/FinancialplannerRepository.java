package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.FinancialPlanner;
/**
 * 理财师记录
 * @author ldd
 *
 */
public interface FinancialplannerRepository extends JpaRepository<FinancialPlanner, Integer> {

}
