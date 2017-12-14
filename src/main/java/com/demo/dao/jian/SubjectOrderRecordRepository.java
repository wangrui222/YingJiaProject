package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.model.SubjectOrderRecord;

public interface SubjectOrderRecordRepository extends JpaRepository<SubjectOrderRecord, Integer>,JpaSpecificationExecutor<SubjectOrderRecord>{

}
