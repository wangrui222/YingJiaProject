package com.demo.dao.wr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.MemberWithdrawRecord;

public class MemberWithdrawRecordRepositoryImpl implements MemberWithdrawRecordDao{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<MemberWithdrawRecord> getMemberWithdrawRecord(Integer memberid, Integer page, Integer rowsize) {
		String sql = "From MemberWithdrawRecord m  where m.members.memberId= "+memberid+" order by m.mwrId ";
		Query query=entityManager.createQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		return query.getResultList();
	}

	@Override
	public Integer getMemberWithdrawRecordCount(Integer memberid) {
		String sql = "SELECT count(*) FROM member_withdraw_record WHERE member_id =  "+memberid;
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}
	
	

}
