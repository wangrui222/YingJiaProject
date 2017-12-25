package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.dao.wr.MemberWithdrawRecordDao;
import com.demo.model.MemberWithdrawRecord;

/**
*@author 作者：
*@version 创建时间：2017年12月7日
*类说明
*/

public interface MemberWithdrawRecordRepository extends JpaRepository<MemberWithdrawRecord, Integer>,MemberWithdrawRecordDao,JpaSpecificationExecutor<MemberWithdrawRecord> {


}
