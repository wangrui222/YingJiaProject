package com.demo.dao.wr;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import com.demo.model.Subject;
import com.demo.model.Users;

public interface SubjectDao {
	
	//ǰ�˽���
	
	/**
	 * Ͷ�ʼ�¼
	 * @param memberid
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> findTouZiJiLu(Integer memberid,Integer page,Integer rowsize);
	
	/**
	 * Ͷ�ʼ�¼��ҳ��ѯ��������
	 * @param memberid
	 * @return
	 */
	public Integer getCount(Integer memberid);
	
	/**
	 * �����
	 * @param memberid
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> findTiYanJin(Integer memberid,Integer page,Integer rowsize);
	/**
	 * ������������
	 * @param memberid
	 * @return
	 */
	public Integer getTiYanJinCount(Integer memberid);
	
	/**
	 * ǰ̨���������
	 * @param subject
	 * @param page
	 * @param rowsize
	 * @return
	 */
	public List<Object[]> selectSubject(Subject subject, Integer page, Integer rowsize);
	
	/**
	 * �������������
	 * @return
	 */
	public Integer getGushouCount();
	
	/**
	 * ���չ���
	 * @param subjectId
	 * @return
	 */
	public  Object[] getGushouGouMai(Integer subjectId);
	
	


}
