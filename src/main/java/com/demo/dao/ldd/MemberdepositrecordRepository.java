package com.demo.dao.ldd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberAccount;
import com.demo.model.MemberDepositRecord;

public interface MemberdepositrecordRepository extends JpaRepository<MemberDepositRecord, Integer> {
	@Query("select m from MemberDepositRecord m where m.memberId=?1")
	public List<MemberDepositRecord> selectMemberDepositRecord(Integer id);
}
