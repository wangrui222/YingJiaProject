package com.demo.dao.wr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.FinanceProductSubscribe;

public class FinanceProductSubscribeRepositoryImpl implements FinanceProductSubscribeDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<FinanceProductSubscribe> findFinanceProductSubscribe(Integer memberid,Integer page,Integer rowsize) {
		String sql ="select f From FinanceProductSubscribe f  where  f.memberId = "+memberid+" and f.status=1 order by f.createDate desc  ";

		Query query=entityManager.createQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		
		return query.getResultList();
	}

	@Override
	public Integer getCount(Integer memberid) {
		String sql = " SELECT count(*) FROM finance_product_subscribe WHERE  member_id = "+memberid+" AND status = 1";
		
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

}
