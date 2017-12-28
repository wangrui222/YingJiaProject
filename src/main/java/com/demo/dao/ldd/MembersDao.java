package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import com.demo.model.Subject;
/**
 * 账号记录Dao
 * @author ldd
 *
 */
public interface MembersDao {
	//账号详情，投资记录
	public List<Object[]> selectTouzi(Integer id);
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
	//两表联查，付息计划-体验金付息查询总数
	public Integer getcountssubjectBbinpurchaserecord(Integer id);
	//两表联查，付息计划-付息列表按id查询三个信息
	public Object selectsubjectBbinpurchaserecord(Integer id);

	//两表联查，付息计划-付息列表
	public List<Object[]> selectsubjectpurchaserecord(Integer id,Integer page,Integer rowsize);
	//两表联查，付息计划-付息列表查询总数
	public Integer getcountssubjectpurchaserecord(Integer id);
}
