package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


public class MembersRepositoryImpl implements MembersDao {

	@PersistenceContext
	EntityManager em;


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
		if (maps.get("time")!=null&&!"".equals(maps.get("time"))) {
			sql+=" and fp.createDate ="+maps.get("time");
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
		if (maps.get("time")!=null&&!"".equals(maps.get("time"))) {
			sql+=" and fp.createDate ="+maps.get("time");
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
		String sql=" SELECT b.*,m.names,m.mobile_Phone,m.member_name,m.member_identity FROM member_bankcards b,members m WHERE b.member_id=m.member_id";
		if (maps.get("iphone")!=null&&!"".equals(maps.get("iphone"))) {
			sql+=" and m.mobile_Phone like'%"+maps.get("iphone")+"%'";
		}
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and fp.financial_Planner_Name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and fp.status ="+maps.get("status");
		}
		if (maps.get("time")!=null&&!"".equals(maps.get("time"))) {
			sql+=" and fp.createDate ="+maps.get("time");
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
			sql+=" and fp.financialPlannerName like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and fp.status ="+maps.get("status");
		}
		if (maps.get("time")!=null&&!"".equals(maps.get("time"))) {
			sql+=" and fp.createDate ="+maps.get("time");
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
		String sql=" SELECT * FROM subject s where 1=1";	
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and s.subject_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and s.status ="+maps.get("status");
		}
		if (maps.get("type")!=null&&!"".equals(maps.get("type"))) {
			sql+=" and s.subject_type ="+maps.get("type");
		}
		sql+=" order by s.start_date desc";
		Query query=em.createNativeQuery(sql);
		query.setFirstResult((page-1)*rowsize);
		query.setMaxResults(rowsize);
		List<Object[]> list=(List<Object[]>) query.getResultList();
		return list;
	}
	//付息计划查询总数
	@Override
	public Integer getcountssubject(Map<String, Object> maps) {
		String sql="SELECT count(*) FROM subject s where 1=1";	
		if (maps.get("name")!=null&&!"".equals(maps.get("name"))) {
			sql+=" and s.subject_name like'%"+maps.get("name")+"%'";
		}
		if (maps.get("status")!=null&&!"".equals(maps.get("status"))) {
			sql+=" and s.status ="+maps.get("status");
		}
		if (maps.get("type")!=null&&!"".equals(maps.get("type"))) {
			sql+=" and s.subject_type ="+maps.get("type");
		}
		sql+=" order by s.start_date desc";
		Query query=em.createNativeQuery(sql);		
		Object object=query.getSingleResult();
		Integer count=Integer.parseInt(object.toString());
		return count;
	}


}
