package com.demo.dao.wr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.MemberDepositRecord;

public class MemberDepositRecordRepositoryImpl implements MemberDepositRecordRepositoryDao{

	@PersistenceContext
	EntityManager entityManager;
	@Override
	public List<MemberDepositRecord> getMemberDepositRecord(Integer memberid, Integer page,
			Integer rowsize) {
		String sql = "From MemberDepositRecord m where m.memberId= "+memberid+" order by m.memberDepositRecordId ";
		Query query=entityManager.createQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		
		return query.getResultList();
	}

	@Override
	public Integer getMemberDepositRecordCount(Integer memberid) {
		String sql = "SELECT count(*) FROM Member_Deposit_Record r  WHERE r.member_id = "+memberid;
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

	
}
