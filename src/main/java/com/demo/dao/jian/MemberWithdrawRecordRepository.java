package com.demo.dao.jian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.demo.model.MemberWithdrawRecord;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2017��12��7��
*��˵��
*/
public interface MemberWithdrawRecordRepository extends JpaRepository<MemberWithdrawRecord, Integer>,JpaSpecificationExecutor<MemberWithdrawRecord> {

}
