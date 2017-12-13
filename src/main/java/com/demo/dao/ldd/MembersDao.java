package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

public interface MembersDao {
	//两表联查，理财师查询
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//理财师查询总数
	public Integer getcounts(Map<String, Object> maps);

	//两表联查，绑卡管理
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);
	//理财师查询总数
	public Integer getcountsbankcards(Map<String, Object> maps);


	//两表联查，付息计划
	public List<Object[]> selectsubject(Map<String, Object> maps,Integer page,Integer rowsize);
	//理财师查询总数
	public Integer getcountssubject(Map<String, Object> maps);

	//两表联查，付息计划-体验金付息
	public List<Object[]> selectsubjectBbinpurchaserecord(Integer id,Integer page,Integer rowsize);
	//理财师查询总数
	public Integer getcountssubjectBbinpurchaserecord(Integer id);

	//两表联查，付息计划-付息列表
	public List<Object[]> selectsubjectpurchaserecord(Integer id,Integer page,Integer rowsize);
	//理财师查询总数
	public Integer getcountssubjectpurchaserecord(Integer id);
}
