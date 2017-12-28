package com.demo.service.wr;

import com.demo.model.MemberDepositRecord;

public interface MemberDepositRecordSerivce {
	
	/**
	 * 会员账户充值
	 * @param memberDepositRecord
	 */
	public void addMemberDepositRecord(MemberDepositRecord memberDepositRecord);
	
	/**
	 *支付成功进行数据修改 
	 * @param out_trade_no
	 * @param trade_no
	 */
	public void updateMemberDepositRecordSerivce(String out_trade_no, String trade_no);
	
	
	

	


}
