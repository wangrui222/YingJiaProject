package com.demo.dao.jian;


import org.springframework.data.jpa.repository.JpaRepository;


import com.demo.model.MemberDepositRecord;

public interface SubjectOrderRecordRepository extends JpaRepository<MemberDepositRecord, Integer>,SubjectOrderDao{

}
