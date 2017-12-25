package com.demo.dao.jian;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class SubjectsRepositoryImpl implements SubjectsDao{
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public Object[] findSubject(Integer memberId) {
		String sql= "select  z.period,z.year_rate,z.useable_balance from("+
				"select m.member_id,s.period,s.year_rate,a.useable_balance from subject s ,"
				+ " Member_withdraw_record w,members m,member_account a  where s.serial_number=w.serial_number "+
				"and m.member_id=a.member_id and m.member_id=w.member_id)z  where z.member_id="+memberId+" "; 
		Object[] o=(Object[]) entityManager.createNativeQuery(sql).getSingleResult();
		return o;
	}

}
