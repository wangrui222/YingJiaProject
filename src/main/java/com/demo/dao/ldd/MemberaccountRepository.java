package com.demo.dao.ldd;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.MemberAccount;
/**
 * 资金查询记录
 * @author ldd
 *
 */
public interface MemberaccountRepository extends JpaRepository<MemberAccount, Integer> {

}
