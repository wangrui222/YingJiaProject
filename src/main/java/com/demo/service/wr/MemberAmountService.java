package com.demo.service.wr;

public interface MemberAmountService {
	
	
	/**
	 * 充值
	 * @param parseFloat
	 * @param memberId
	 */
	public void updateMemberAmount(float parseFloat,Integer memberId);
	/**
	 * 体现
	 * @param parseFloat
	 * @param memberId
	 */
	public void updateMemberAmounts(float parseFloat,Integer memberId);
	
	
	/**
	 * 标的购买 余额操作
	 * @param parseFloat
	 * @param memberid
	 */
	public void updateMA(float parseFloat,Integer memberid);

}
