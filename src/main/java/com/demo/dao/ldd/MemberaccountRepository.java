package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.MemberAccount;


/**
 * 资金查询记录
 * @author ldd
 *
 */
public interface MemberaccountRepository extends JpaRepository<MemberAccount, Integer> {
	@Query("select m from MemberAccount m where m.members.memberId=?1")
	public MemberAccount selectMemberAccount(Integer id);
}
