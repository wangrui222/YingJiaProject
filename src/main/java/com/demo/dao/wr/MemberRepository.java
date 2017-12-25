package com.demo.dao.wr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.demo.model.Members;

public interface MemberRepository extends JpaRepository<Members, Integer> {
	
	/**
	 * 登陆查询会员信息
	 * @param mobilePhone
	 * @return
	 */
	@Query("From Members s where s.mobilePhone = ?")
	public Members findMember(String mobilePhone);
	
	
	@Query("From Members s where s.memberId = ? ")
	public Members findMemberAll(Integer memberId);

	
	@Modifying
	@Query("update Members m set m.names = :names ,m.memberIdentity = :identity where  m.memberId = :memberid")
	public void addMember(@Param("memberid")Integer memberid, @Param("names")String userName, @Param("identity") String identity);


	@Modifying
	@Query("update Members m set m.passwords = :password where m.memberId = :memberId")
	public void updateMemberPassword(@Param("password")String password,@Param("memberId")Integer memberId);
	
	

}
