package com.demo.dao.ldd;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberWithdrawRecord;
import com.demo.model.SubjectPurchaseRecord;
/**
 * 会员付息记录
 * @author ldd
 *
 */
public interface SubjectpurchaserecordRepository extends JpaRepository<SubjectPurchaseRecord, Integer> {
	
	/*@Query("select m,s.subjectName from SubjectPurchaseRecord m,Subject s where m.subjectId=s.subjectId and m.memberId=?1")
	public List<SubjectPurchaseRecord> selectSubjectPurchaseRecord(Integer id);*/
}
