
package com.demo.dao.jian;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *@author ���ߣ�
 *@version ����ʱ�䣺2017��12��5��
 *��˵��
 */
public class SubjectOrderRecordDaoImpl implements SubjectOrderRecordDao {

	@PersistenceContext
	EntityManager entityManager;

	/* (non-Javadoc)
	 * @see com.demo.dao.jian.SubjectOrderRecordDao#FindSubjectOrderRecord()
	 */
	
	@Override
	public List<Object[]> FindSubjectOrderRecord() {
		String sql="";
		List<Object[]> olist=entityManager.createNativeQuery(sql).getResultList();
		return olist;
	}

	


}
