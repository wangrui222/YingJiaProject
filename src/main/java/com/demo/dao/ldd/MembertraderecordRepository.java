package com.demo.dao.ldd;


import com.demo.model.MemberTradeRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MembertraderecordRepository extends JpaRepository<MemberTradeRecord, Integer> {

	@Query("select m from MemberTradeRecord m where m.memberId=?1")
	public List<MemberTradeRecord> selectMemberTradeRecord(Integer id);

}
