package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.FinanceProductSubscribe;

public interface FinanceProductSubscribeRepository extends JpaRepository<FinanceProductSubscribe, Integer>,FinanceProductSubscribeDao {

}
