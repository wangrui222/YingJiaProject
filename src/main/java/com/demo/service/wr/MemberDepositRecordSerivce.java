package com.demo.service.wr;

import com.demo.model.MemberDepositRecord;

public interface MemberDepositRecordSerivce {
	
	/**
	 * ��Ա�˻���ֵ
	 * @param memberDepositRecord
	 */
	public void addMemberDepositRecord(MemberDepositRecord memberDepositRecord);
	
	/**
	 *֧���ɹ����������޸� 
	 * @param out_trade_no
	 * @param trade_no
	 */
	public void updateMemberDepositRecordSerivce(String out_trade_no, String trade_no);
	
	
	

	


}
