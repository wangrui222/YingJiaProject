package com.demo.service.wr;

public interface MemberService {
	/**
	 * 验证用户 和绑定卡
	 * @param members
	 */
	

	public void addMemberYanZheng(Integer memberid, String userName, String identity);
	
	/**
	 * 修改密码
	 * @param password
	 * @param memberId
	 */
	public void updateMemberPassword(String password,Integer memberId);

}
