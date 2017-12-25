package com.demo.dao.wr;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.MemberProfitRecord;

public class MemberProfitRecordRepositoryImpl implements MemberProfitRecordDao  {
	@PersistenceContext
	EntityManager entityManager;
	//select id, serial_number, type, amount, member_id, delflag, create_date, update_date, comment, purchase_id, profit_year, profit_month, profit_day from member_profit_record where member_id = ? order by id desc limit ?,?  -(:139)
	//SELECT count(*) FROM member_profit_record WHERE member_id = ?  -(:139)
	@Override
	public List<MemberProfitRecord> getMemberProfitRecord(Integer memberId,Integer page, Integer rowsize) {
		String sql = "From MemberProfitRecord m where m.memberId = "+memberId+" order by m.mprId desc ";
		Query query=entityManager.createQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		return query.getResultList();
	}

	@Override
	public Integer getMemberProfitRecordCount(Integer memberId) {
		String sql = "SELECT count(*) FROM member_profit_record WHERE member_id = "+memberId;
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

}
