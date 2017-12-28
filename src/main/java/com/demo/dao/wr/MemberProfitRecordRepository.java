package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.MemberProfitRecord;

public interface MemberProfitRecordRepository extends JpaRepository<MemberProfitRecord, Integer>,MemberProfitRecordDao{

}
