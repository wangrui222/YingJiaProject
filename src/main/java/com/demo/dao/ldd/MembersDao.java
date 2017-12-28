package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

import com.demo.model.Subject;
/**
 * �˺ż�¼Dao
 * @author ldd
 *
 */
public interface MembersDao {
	//�˺����飬Ͷ�ʼ�¼
	public List<Object[]> selectTouzi(Integer id);
	//�������飬���ʦ��ѯ
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//���ʦ��ѯ����
	public Integer getcounts(Map<String, Object> maps);

	//�������飬�󿨹���
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);
	//���ʦ��ѯ����
	public Integer getcountsbankcards(Map<String, Object> maps);


	//�������飬��Ϣ�ƻ�
	public List<Object[]> selectsubject(Map<String, Object> maps,Integer page,Integer rowsize);
	//���ʦ��ѯ����
	public Integer getcountssubject(Map<String, Object> maps);
	
	

	//�������飬��Ϣ�ƻ�-�����Ϣ
	public List<Object[]> selectsubjectBbinpurchaserecord(Integer id,Integer page,Integer rowsize);
	//�������飬��Ϣ�ƻ�-�����Ϣ��ѯ����
	public Integer getcountssubjectBbinpurchaserecord(Integer id);
	//�������飬��Ϣ�ƻ�-��Ϣ�б�id��ѯ������Ϣ
	public Object selectsubjectBbinpurchaserecord(Integer id);

	//�������飬��Ϣ�ƻ�-��Ϣ�б�
	public List<Object[]> selectsubjectpurchaserecord(Integer id,Integer page,Integer rowsize);
	//�������飬��Ϣ�ƻ�-��Ϣ�б��ѯ����
	public Integer getcountssubjectpurchaserecord(Integer id);
}
