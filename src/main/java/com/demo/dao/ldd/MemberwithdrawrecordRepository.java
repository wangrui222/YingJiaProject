package com.demo.dao.ldd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberTradeRecord;
import com.demo.model.MemberWithdrawRecord;

/**
 * Ã·œ÷º«¬º
 * @author ldd
 *
 */
public interface MemberwithdrawrecordRepository extends JpaRepository<MemberWithdrawRecord, Integer>{
	@Query("select m from MemberWithdrawRecord m where m.members.memberId=?1")
	public List<MemberWithdrawRecord> selectMemberWithdrawRecord(Integer id);
}
