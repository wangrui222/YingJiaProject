package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.demo.model.Subject;

/**
 * 账号记录DaoImpl
 * @author ldd
 *
 */
public class MembersRepositoryImpl implements MembersDao {

	@PersistenceContext
	EntityManager em;

	//账号详情，投资记录
	//, Integer page, Integer rowsize
	@Override
	public List<Object[]> selectTouzi(Integer id) {
		String sql="select * from (select s.subject_name,ss.* from (select t.subject_id,t.serial_number,t.member_id,t.amount,t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_PURCHASE_RECORD t  union all  select t.subject_id,t.serial_number,t.member_id,t.amount,t.amount+t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_BBIN_PURCHASE_RECORD t)ss,subject s where ss.subject_id=s.subject_id) sss where sss.member_id="+id;		
		sql+=" order BY sss.create_date desc";
		Query query=em.createNativeQuery(sql);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//两表联查，理财师查询
	@Override
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize) {
		String sql="SELECT fp.*,m.mobile_Phone FROM financial_planner fp,Members m WHERE fp.member_id =m.member_id ";
		if (maps.get("iphone")!=null&&!"".equals(maps.get("iphone"))) {
			sql+=" and m.mobile_Phone like'%"+maps.get("iphone")+"%'";
		}
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and fp.financial_Planner_Name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and fp.status ="+maps.get("status");
		}
		sql+=" order by fp.create_date desc";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//理财师查询总数
	@Override
	public Integer getcounts(Map<String, Object> maps) {
		String sql="SELECT count(*) FROM financial_planner fp,Members m WHERE fp.member_id =m.member_id ";
		if (maps.get("iphone")!=null&&!"".equals(maps.get("iphone"))) {
			sql+=" and m.mobile_Phone like'%"+maps.get("iphone")+"%'";
		}
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and fp.financialPlannerName like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and fp.status ="+maps.get("status");
		}
		sql+=" order by fp.create_date desc";
		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}

	//两表联查，绑卡管理
	@Override
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize) {
		String sql="SELECT b.*,m.names,m.mobile_Phone,m.member_name,m.member_identity FROM member_bankcards b,members m WHERE b.member_id=m.member_id";
		if (maps.get("iphone")!=null&&!"".equals(maps.get("iphone"))) {
			sql+=" and m.mobile_Phone like'%"+maps.get("iphone")+"%'";
		}
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and m.member_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("CardNo")!=null&&!"".equals(maps.get("CardNo"))) {
			sql+=" and b.card_no ="+maps.get("CardNo");
		}
		sql+=" order by b.create_date desc";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//绑卡管理查询总数
	@Override
	public Integer getcountsbankcards(Map<String, Object> maps) {
		String sql="SELECT count(*) FROM member_bankcards b,members m WHERE b.member_id=m.member_id ";
		if (maps.get("iphone")!=null&&!"".equals(maps.get("iphone"))) {
			sql+=" and m.mobile_Phone like'%"+maps.get("iphone")+"%'";
		}
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and m.member_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("CardNo")!=null&&!"".equals(maps.get("CardNo"))) {
			sql+=" and b.card_no ="+maps.get("CardNo");
		}
		sql+=" order by b.create_date desc";
		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}
	//两表联查，付息计划
	@Override
	public List<Object[]> selectsubject(Map<String, Object> maps, Integer page, Integer rowsize) {
		String sql="select ss.* from   (SELECT s.*,a.counts,a.money FROM subject s,(select a.subject_id,a.counts,b.money from  (select ss.subject_id,sum(ss.sums)as counts from(select t.subject_id,count(t.subject_id) as sums from SUBJECT_PURCHASE_RECORD t group by t.subject_id union all select t.subject_id,count(t.subject_id) as sums from SUBJECT_BBIN_PURCHASE_RECORD t group by t.subject_id union all select s.subject_id,s.bought as sums from subject s) ss group by ss.subject_id ) a left join (select ss.subject_id,sum(ss.sums)as money from(select t.subject_id,sum(t.amount) as sums from SUBJECT_PURCHASE_RECORD t group by t.subject_id union all select t.subject_id,sum(t.amount) as sums from SUBJECT_BBIN_PURCHASE_RECORD t group by t.subject_id) ss group by ss.subject_id) b on a.subject_id=b.subject_id) a where s.subject_id=a.subject_id)ss where 1=1";	
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and ss.subject_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and ss.status ="+maps.get("status");
		}
		if (maps.get("type")!=null&&!"".equals(maps.get("type"))) {
			sql+=" and ss.subject_type ="+maps.get("type");
		}
		sql+=" order by ss.start_date desc";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//付息计划查询总数
	@Override
	public Integer getcountssubject(Map<String, Object> maps) {
		String sql="select count(*) from   (SELECT s.*,a.counts,a.money FROM subject s,(select a.subject_id,a.counts,b.money from  (select ss.subject_id,sum(ss.sums)as counts from(select t.subject_id,count(t.subject_id) as sums from SUBJECT_PURCHASE_RECORD t group by t.subject_id union all select t.subject_id,count(t.subject_id) as sums from SUBJECT_BBIN_PURCHASE_RECORD t group by t.subject_id union all select s.subject_id,s.bought as sums from subject s) ss group by ss.subject_id ) a left join (select ss.subject_id,sum(ss.sums)as money from(select t.subject_id,sum(t.amount) as sums from SUBJECT_PURCHASE_RECORD t group by t.subject_id union all select t.subject_id,sum(t.amount) as sums from SUBJECT_BBIN_PURCHASE_RECORD t group by t.subject_id) ss group by ss.subject_id) b on a.subject_id=b.subject_id) a where s.subject_id=a.subject_id)ss where 1=1";	
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and ss.subject_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and ss.status ="+maps.get("status");
		}
		if (maps.get("type")!=null&&!"".equals(maps.get("type"))) {
			sql+=" and ss.subject_type ="+maps.get("type");
		}
		sql+=" order by ss.start_date desc";
		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}
	//两表联查，付息计划-体验金付息
	@Override
	public List<Object[]> selectsubjectBbinpurchaserecord(Integer id, Integer page, Integer rowsize) {
		String sql="SELECT pr.subject_id,pr.serial_number,m.mobile_phone,m.member_name,m.member_identity, pr.amount,pr.interest,pr.create_date+pr.pay_interest_times,pr.ispayment FROM subject_bbin_purchase_record pr, members m WHERE pr.member_id = m.member_id ";	
		sql+=" and pr.subject_id ="+id;
		sql+=" order BY pr.create_date desc";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//付息计划-体验金付息查询总数
	@Override
	public Integer getcountssubjectBbinpurchaserecord(Integer id) {
		String sql="SELECT count(*) FROM subject_bbin_purchase_record pr, members m WHERE pr.member_id = m.member_id ";	
		sql+=" and pr.subject_id ="+id;
		sql+=" order BY pr.create_date desc";
		Query query=em.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());
					
	}

	//两表联查，付息计划-付息列表
	@Override
	public List<Object[]> selectsubjectpurchaserecord(Integer id, Integer page, Integer rowsize) {
		String sql="select * from(select ss.*, m.member_name,m.mobile_phone, m.member_identity from members m,(select t.subject_id,t.serial_number,t.member_id,t.amount,t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_PURCHASE_RECORD t union all select t.subject_id,t.serial_number,t.member_id,t.amount,t.amount+t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_BBIN_PURCHASE_RECORD t)ss) sss where sss.subject_id="+id;	
		sql+=" order BY sss.create_date DESC";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//付息计划-付息列表查询总数
	@Override
	public Integer getcountssubjectpurchaserecord(Integer id) {
		String sql="select count(*) from (select ss.*, m.member_name,m.mobile_phone, m.member_identity from members m,(select t.subject_id,t.serial_number,t.member_id,t.amount,t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_PURCHASE_RECORD t union all select t.subject_id,t.serial_number,t.member_id,t.amount,t.amount+t.interest,t.create_date,(t.create_date+t.pay_interest_times),t.ispayment from SUBJECT_BBIN_PURCHASE_RECORD t)ss) sss where sss.subject_id="+id;	
		sql+=" order BY sss.create_date DESC";
		Query query=em.createNativeQuery(sql);
		return Integer.parseInt(query.getSingleResult().toString());			
	}
	//两表联查，付息计划-付息列表按id查询三个信息
	@Override
	public Object selectsubjectBbinpurchaserecord(Integer id) {
		String sql="select t.subject_name,t.period,t.year_rate,t.subject_id from SUBJECT t where t.subject_id="+id;	
		Query query=em.createNativeQuery(sql);		
		Object subject=query.getSingleResult();
		return subject;
	}
}
