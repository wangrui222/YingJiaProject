package com.demo.service.wr;

public interface MemberService {
	/**
	 * ��֤�û� �Ͱ󶨿�
	 * @param members
	 */
	

	public void addMemberYanZheng(Integer memberid, String userName, String identity);
	
	/**
	 * �޸�����
	 * @param password
	 * @param memberId
	 */
	public void updateMemberPassword(String password,Integer memberId);

}
