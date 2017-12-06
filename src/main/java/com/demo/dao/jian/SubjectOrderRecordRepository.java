
package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.SubjectOrderRecord;

/**
*@author 作者：
*@version 创建时间：2017年12月5日
*类说明
*/
public interface SubjectOrderRecordRepository extends JpaRepository<SubjectOrderRecord, Integer>,SubjectOrderRecordDao{
	

}
