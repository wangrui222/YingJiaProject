package com.demo.service.wr;

public interface MemberAmountService {
	
	
	/**
	 * ��ֵ
	 * @param parseFloat
	 * @param memberId
	 */
	public void updateMemberAmount(float parseFloat,Integer memberId);
	/**
	 * ����
	 * @param parseFloat
	 * @param memberId
	 */
	public void updateMemberAmounts(float parseFloat,Integer memberId);
	
	
	/**
	 * ��Ĺ��� ������
	 * @param parseFloat
	 * @param memberid
	 */
	public void updateMA(float parseFloat,Integer memberid);

}
