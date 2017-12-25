package com.demo.dao.ldd;


import com.demo.model.MemberTradeRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MembertraderecordRepository extends JpaRepository<MemberTradeRecord, Integer> {

	@Query("select m from MemberTradeRecord m where m.memberId=?1")
	public List<MemberTradeRecord> selectMemberTradeRecord(Integer id);

	@Modifying
	@Query("update MemberTradeRecord m set m.tradeStatus = :status where m.mtrId = :id ")
	public void updateMTR(@Param("status")Integer status,@Param("id")Integer id);

}
