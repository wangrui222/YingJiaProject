package com.demo.dao.ldd;

import com.demo.model.MemberTally;
import com.demo.model.MemberTradeRecord;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembertraderecordRepository extends JpaRepository<MemberTradeRecord, Integer> {

	
}
