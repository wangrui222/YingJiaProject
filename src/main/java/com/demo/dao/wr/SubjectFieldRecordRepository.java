package com.demo.dao.wr;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.SubjectFieldRecord;

public interface SubjectFieldRecordRepository extends JpaRepository<SubjectFieldRecord, Integer> {
	
	@Query("FROM SubjectFieldRecord s WHERE s.subjectId = ?")
	public List<SubjectFieldRecord> getSubjectFieldRecord(Integer subjectId);
	
	

}
