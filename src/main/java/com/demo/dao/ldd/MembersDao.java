package com.demo.dao.ldd;

import java.util.List;
import java.util.Map;

public interface MembersDao {
	//�������飬���ʦ��ѯ
	public List<Object[]> selectfinancialplanner(Map<String, Object> maps,Integer page,Integer rowsize);
	//���ʦ��ѯ����
	public Integer getcounts(Map<String, Object> maps);

	//�������飬�󿨹���
	public List<Object[]> selectmemberbankcards(Map<String, Object> maps,Integer page,Integer rowsize);
	//���ʦ��ѯ����
	public Integer getcountsbankcards(Map<String, Object> maps);
}
