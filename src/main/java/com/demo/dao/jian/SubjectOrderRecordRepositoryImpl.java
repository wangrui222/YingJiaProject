
package com.demo.dao.jian;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
/**
 *@author ���ߣ�
 *@version ����ʱ�䣺2017��12��5��
 *��˵��
 */
@Repository
public class SubjectOrderRecordRepositoryImpl implements SubjectOrderRecordDao {
	/**
	 * @PersistenceContext
	
	EntityManager entityManager;
	/* (non-Javadoc)
	 * @see com.demo.dao.jian.SubjectOrderRecordDao#FindSubjectOrderRecord()
	 */
	/**
	 * @Override
	public List<Object[]> FindSubjectOrderRecord() {
		String hql="select s.*,m.mobile_phone from members m,subject_order_record s where m.member_id=s.member_id";
		Query query=entityManager.createNativeQuery(hql);
		List<Object[]> olist=(List<Object[]>) query.getResultList();
		return olist;
	}

	
	 */

}
