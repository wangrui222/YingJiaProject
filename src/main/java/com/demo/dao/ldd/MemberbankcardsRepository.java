package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberBankcards;

public interface MemberbankcardsRepository extends JpaRepository<MemberBankcards, Integer> {
	@Modifying
	@Query("update MemberBankcards m set m.delflag=?1 where m.memberId=?2")
	public void updateMemberbankcards(Integer delflag,Integer id);
	/**
	 * ∞Ûø®»œ÷§≤È—Ø
	 * @param memberId
	 * @return
	 */
	@Query("From MemberBankcards m where m.memberId = ?")
	public MemberBankcards findMemberBankcards(Integer memberId);

}
