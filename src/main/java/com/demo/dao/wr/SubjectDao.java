package com.demo.dao.wr;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.demo.model.Subject;
import com.demo.model.Users;

public interface SubjectDao {
	
	//前端界面
	
	/**
	 * 投资记录
	 * @param memberid
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> findTouZiJiLu(Integer memberid,Integer page,Integer rowsize);
	
	/**
	 * 投资记录分页查询的总条数
	 * @param memberid
	 * @return
	 */
	public Integer getCount(Integer memberid);
	
	/**
	 * 体验金
	 * @param memberid
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> findTiYanJin(Integer memberid,Integer page,Integer rowsize);
	/**
	 * 体验金的总条数
	 * @param memberid
	 * @return
	 */
	public Integer getTiYanJinCount(Integer memberid);
	
	/**
	 * 前台固收类理财
	 * @param subject
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> selectSubject(Subject subject, Integer page, Integer rowsize);
	
	/**
	 * 固收理财总条数
	 * @return
	 */
	public Integer getGushouCount();
	
	/**
	 * 固收购买
	 * @param subjectId
	 * @return
	 */
	public  Object[] getGushouGouMai(Integer subjectId);
	
	


}
