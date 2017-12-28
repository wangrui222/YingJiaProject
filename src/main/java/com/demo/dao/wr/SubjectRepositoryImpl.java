package com.demo.dao.wr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;

import com.demo.model.Subject;

public class SubjectRepositoryImpl implements SubjectDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	/**
	 * 投资记录查询
	 */
	@Override
	public List<Object[]> findTouZiJiLu(Integer memberid,Integer page, Integer rowsize) {
		String sql = "    SELECT r.SPR_ID, r.serial_number, r.amount,"+ 
    " deal_ip, s.subject_name, member_id, r.delflag,  "+ 
   " r.create_date, r.update_date,r.interest, "+ 
   " r.ispayment FROM SUBJECT s JOIN subject_purchase_record r "+ 
   "  ON s.subject_id = r.subject_id WHERE r.member_id = "+memberid+" order by r.create_date desc  ";
		
		Query query=entityManager.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		
		return query.getResultList();
	}

	@Override
	public Integer getCount(Integer memberid) {
		
		String sql = "SELECT count(*) FROM SUBJECT s JOIN subject_purchase_record r ON s.subject_id = r.subject_id WHERE r.member_id = "+memberid;
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
		
	}

	@Override
	public List<Object[]> findTiYanJin(Integer memberid, Integer page, Integer rowsize) {
		String sql ="SELECT ha.subject_name,ha.amount,ha.period,ha.yearRate,ha.createDate,ha.yprofit,ha.interest,ha.ispayment,"
						+ "(CASE WHEN ha.SUBJECT_TYPE=0 THEN add_months(ha.createDate, ha.period) ELSE ha.end_date END) endDate "
					+ "FROM "
						+ "(SELECT s.subject_name , pr. amount , s. period , s. year_rate yearRate, pr. create_date  createDate,"
						+ "s. end_date , s. SUBJECT_TYPE , pr. interest , pr.ispayment,(SELECT COALESCE(SUM(amount), 0) FROM  member_profit_record  WHERE member_id = "+memberid+" AND purchase_id = pr.SBPR_ID ) yprofit "
						+ "FROM  subject_bbin_purchase_record  pr,  subject  s WHERE pr. subject_id  = s.subject_id  AND member_id = "+memberid+") ha "
					+ "ORDER BY ha.createDate DESC ";


		Query query=entityManager.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		
		return query.getResultList();
	}

	@Override
	public Integer getTiYanJinCount(Integer memberid) {
		String sql ="SELECT count(*) "
					+ "FROM "
						+ "(SELECT s.subject_name , pr. amount , s. period , s. year_rate yearRate, pr. create_date  createDate,"
						+ "s. end_date , s. SUBJECT_TYPE , pr. interest , pr.ispayment,(SELECT COALESCE(SUM(amount), 0) FROM  member_profit_record  WHERE member_id = 1 AND purchase_id = pr.SBPR_ID ) yprofit "
						+ "FROM  subject_bbin_purchase_record  pr,  subject  s WHERE pr. subject_id  = s.subject_id  AND member_id = 1) ha "
					+ "ORDER BY ha.createDate DESC "; 
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

	
	
	@Override
	public List<Object[]> selectSubject(Subject subject, Integer page, Integer rowsize) {
		String sql = "SELECT s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status, s.amount,s.SUBJECT_TYPE,"
				+"(COALESCE(SUM(r.amount),0)+ (SELECT COALESCE(SUM(sb.amount),0) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id)) hasSold," 
				+"(COUNT(r.spr_id)+s.bought+(SELECT COUNT(sb.sbpr_id) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id) ) hasBought "
				+"FROM SUBJECT s LEFT JOIN subject_purchase_record r ON s.subject_id = r.subject_id where s.status!=0 ";
		
		
		//标的类型
		if(subject.getSubjectType() == 0) sql=sql+" and s.subject_type = 0";
		if(subject.getSubjectType() == 1) sql=sql+" and s.subject_type = 1";
		
		//年化收益
		if(subject.getYearRate() == 6) sql=sql+" and s.Year_Rate = 6";
		if(subject.getYearRate() == 7) sql=sql+" and s.Year_Rate = 7";
		if(subject.getYearRate() == 7.5) sql=sql+" and s.Year_Rate = 7.5";
		if(subject.getYearRate() == 8) sql=sql+" and s.Year_Rate = 8";
		if(subject.getYearRate() == 9) sql=sql+" and s.Year_Rate >8";
		
		//项目期限
		if(subject.getPeriod() == 15) sql=sql+" and s.period =15";
		if(subject.getPeriod() == 30) sql=sql+" and s.period >15 and s.period<=30";
		if(subject.getPeriod() == 180) sql=sql+" and s.period >30 and s.period<=180";
		if(subject.getPeriod() == 365) sql=sql+" and s.period >180 and s.period<=365";
		if(subject.getPeriod() == 366) sql=sql+" and s.period >365 ";
		
		//标的状态：
		if(subject.getStatus() == 1) sql=sql+" and s.status =1";
		if(subject.getStatus() == 2) sql=sql+" and s.status =2";
		if(subject.getStatus() == 3) sql=sql+" and s.status =3";
		
		sql = sql+"GROUP BY  s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,"
				+ "s.period,s.bought,s.create_date,s.status, s.amount,s.SUBJECT_TYPE order by s.subject_id";
		
		
		Query query=entityManager.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		
		return query.getResultList();
	}

	@Override
	public Integer getGushouCount() {
		String sql = "select count(*) from subject s where s.status!=0 ";
		
		Query query=entityManager.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
	}

	@Override
	public Object[] getGushouGouMai(Integer subjectId) {
		
		String sql = "SELECT s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,s.period,s.bought,s.create_date,s.status, s.amount,s.SUBJECT_TYPE,s.REFUND_WAY,s.SAFEGUARD_WAY,"
				+"(COALESCE(SUM(r.amount),0)+ (SELECT COALESCE(SUM(sb.amount),0) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id)) hasSold," 
				+"(COUNT(r.spr_id)+s.bought+(SELECT COUNT(sb.sbpr_id) FROM subject_bbin_purchase_record sb WHERE s.subject_id=sb.subject_id) ) hasBought "
				+"FROM SUBJECT s LEFT JOIN subject_purchase_record r ON s.subject_id = r.subject_id where s.status!=0 and s.subject_id ="+subjectId+" "
				+ " GROUP BY  s.subject_id,s.subject_name,s.YEAR_RATE,s.floor_amount,"
				+ "s.period,s.bought,s.create_date,s.status, s.amount,s.SUBJECT_TYPE,s.REFUND_WAY,s.SAFEGUARD_WAY order by s.subject_id";
		Query query=entityManager.createNativeQuery(sql);
		return (Object[]) query.getSingleResult();
	}
	
	
	
	
}
