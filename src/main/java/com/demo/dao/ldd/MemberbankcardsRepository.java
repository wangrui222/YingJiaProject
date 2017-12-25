package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberBankcards;
/**
 * °ó¿¨¹ÜÀíÐÞ¸Ä×´Ì¬
 * @author ldd
 *
 */
public interface MemberbankcardsRepository extends JpaRepository<MemberBankcards, Integer> {
	@Modifying
	@Query("update MemberBankcards m set m.delflag=?1 where m.memberId=?2")
	public void updateMemberbankcards(Integer delflag,Integer id);
}
