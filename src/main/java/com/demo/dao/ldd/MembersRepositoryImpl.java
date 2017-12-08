package com.demo.dao.ldd;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class MembersRepositoryImpl implements MembersDao {
	@PersistenceContext
	EntityManager em;
	@Override
	public List<Object[]> selectfinancialplanner() {
		String sql="SELECT fp.*,m.mobile_Phone FROM financial_planner fp,Members m WHERE fp.member_id =m.member_id order by fp.create_date desc";
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}

}
