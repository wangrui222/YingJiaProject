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
}
