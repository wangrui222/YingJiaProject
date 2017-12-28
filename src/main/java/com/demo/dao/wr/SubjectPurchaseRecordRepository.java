package com.demo.dao.wr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.SubjectPurchaseRecord;

public interface SubjectPurchaseRecordRepository extends JpaRepository<SubjectPurchaseRecord, Integer>,JpaSpecificationExecutor<SubjectPurchaseRecord> {

	@Query(value="SELECT COALESCE (SUM(s.amount),0) sumamount  FROM subject_purchase_record  s WHERE s.subject_Id = ?",nativeQuery=true)
	public Float getSumamount(Integer subjectId);
	
	
	public SubjectPurchaseRecord findSubjectPurchaseRecordBysprId(Integer sprId);
}
