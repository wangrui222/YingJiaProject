package com.demo.dao.wr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.SubjectPurchaseRecord;

public interface SubjectPurchaseRecordRepository extends JpaRepository<SubjectPurchaseRecord, Integer> {

	@Query(value="SELECT COALESCE (SUM(s.amount),0) sumamount  FROM subject_purchase_record  s WHERE s.subject_Id = ?",nativeQuery=true)
	public Float getSumamount(Integer subjectId);
}
