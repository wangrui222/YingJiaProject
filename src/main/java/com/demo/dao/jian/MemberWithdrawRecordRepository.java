package com.demo.dao.jian;

import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberWithdrawRecord;


/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/

public interface MemberWithdrawRecordRepository extends JpaRepository<MemberWithdrawRecord, Integer>,JpaSpecificationExecutor<MemberWithdrawRecord> {
	@Query("from MemberWithdrawRecord m where m.members.memberId=?1")
    public List<MemberWithdrawRecord> selectMemberWithdrawRecord(Integer memberId);
	@Modifying
	@Query( value="Update MemberWithdrawRecord m set m.status=1 where m.members.memberId=?1")
	public void updateStatus(Integer memberId);
	@Modifying
	@Query(value="Update MemberWithdrawRecord m set m.status=4 where m.mwrId=?1")
	public void updateJieD(Integer mwrId);
	@Query(value="select m.members.memberId from MemberWithdrawRecord m where m.mwrId=?1")
	public Integer findMemberId(Integer mwrId);
}
